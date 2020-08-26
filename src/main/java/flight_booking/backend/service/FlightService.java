package flight_booking.backend.service;

import flight_booking.backend.models.Airlines.Airline;
import flight_booking.backend.models.Connections.Connection;
import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Flights.FlightRepository;
import flight_booking.backend.models.Times;
import org.springframework.stereotype.Service;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    FlightRepository flightRepository;
    ConnectionService connectionService;
    AirlineService airlineService;

    FlightService(FlightRepository flightRepository,
                  ConnectionService connectionService,
                  AirlineService airlineService) {
        this.flightRepository = flightRepository;
        this.connectionService = connectionService;
        this.airlineService = airlineService;
    }

    public Connection findConnection(Long flightId) {

        Long id_connection = flightRepository.findIdConnectionByFlight(flightId);
        return connectionService.findById(id_connection).get();
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public Flight save(Flight flight) {
       return flightRepository.save(flight);
    }

    public Flight addNewFlight(Long airlineDtoId,
                               int numberSeats,
                               double price,
                               String departureDate,
                               String departureTime,
                               String flightTime,
                               Connection connection) {

        Optional<Airline> airline = airlineService.findById(airlineDtoId);
        Flight flight = Flight.builder()
                .connection(connection)
                .airline(airline.get())
                .numberSeats(numberSeats)
                .price(price)
                .times(Times.builder()
                        .departureDate(LocalDate.parse(departureDate))
                        .departureTime(LocalTime.parse(departureTime))
                        .flightTime(LocalTime.parse(flightTime))
                        .build())
                .build();
        flightRepository.save(flight);

        return flight;
    }

    public boolean existsById(Long id) {
        return flightRepository.existsById(id);
    }

    public void deleteConnection(Long id) {
        flightRepository.deleteById(id);
    }

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public List<List<Flight>> findFlights(Long srcAirport, Long dstAirport, LocalDate minDepartureDate,
                                          LocalDate maxDepartureDate, int maxChange, int maxTimeBreak) {

        List<List<Connection>> connections = connectionService.findConnections(srcAirport, dstAirport, maxChange);
        List<List<List<Flight>>> flights = findAllFlights(connections);
        List<List<Flight>> properFlights = chooseFlightsWithProperDate(flights, dstAirport,
                minDepartureDate, maxDepartureDate, maxTimeBreak);

        return properFlights;
    }

    public List<List<List<Flight>>> findAllFlights(List<List<Connection>> listConnections) {

        List<List<List<Flight>>> allFlights = new ArrayList<>();
        for (List<Connection> connections : listConnections) {
            List<List<Flight>> allFlightsInOneTrip = new ArrayList<>();
            for (Connection connection : connections) {
                List<Flight> flights = flightRepository.findFlightsByConnection(connection);
                allFlightsInOneTrip.add(flights);
            }
            allFlights.add(allFlightsInOneTrip);
        }
        return allFlights;
    }

    public List<List<Flight>> chooseFlightsWithProperDate(List<List<List<Flight>>> allFlights, Long dstAirport,
                                                          LocalDate minDepartureDate, LocalDate maxDepartureDate,
                                                          int maxTimeBreak) {


        //lista wyszukanych fligtow dla jednego tripa
        List<List<Flight>> properDateFlight = new ArrayList<>();
        List<List<Flight>> finishListFlights = new ArrayList<>();

        // ta lista w kazdej iteracji rzuca nam jednym trpem (lista connectionow)
        for (int i = 0; i < allFlights.size(); i++) {
            //dostep do jednego tripa
            List<List<Flight>> oneTrip = allFlights.get(i);
            //ta petla w kazdej iteracji bedzie nam rzucac jednym connectionem
            //za pierwszym razem ma jeden ,potem skoczy na 2
            for (int j = 0; j < oneTrip.size(); j++) {

                List<Flight> oneConnection = oneTrip.get(j);

                if (j == 0) {

                    //petla cheba pobiera nam wszystkie zagniezdzone flight z connection jednego typu (w tym przypadku )
                    List<List<Flight>> newListProperDateFlight = new ArrayList<>();
                    for (int k = 0; k < oneConnection.size(); k++) {

                        LocalDate departureDate = oneConnection.get(k).getTimes().getDepartureDate();
                        LocalTime departureTime = oneConnection.get(k).getTimes().getDepartureTime();

                        if ((departureDate.isEqual(minDepartureDate) &&
                                (departureDate.isEqual(LocalDate.now()) && departureTime.isAfter(LocalTime.now()))) ||
                                (departureDate.isAfter(minDepartureDate) && departureDate.isBefore(maxDepartureDate.plusDays(1)))) {

                            List<Flight> oneTripFlightCopy = new ArrayList<>();
                            oneTripFlightCopy.add(oneConnection.get(k));
                            //dla kazdego znalezionego flighta tworzysz dla niego nowa tablice, czekajaca na wypelnienie
                            // jesli zawiera miasto docelowe dodajemy go na ostateczna liste
                            if (oneConnection.get(k).getConnection().getDstAirport().getId().equals(dstAirport)) {
                                finishListFlights.add(oneTripFlightCopy);
                            } else {
                                newListProperDateFlight.add(oneTripFlightCopy);
                            }
                        }
                    }
                    properDateFlight.clear();
                    properDateFlight = newListProperDateFlight;

                } else {
                    List<List<Flight>> newListProperDateFlight = new ArrayList<>();

                    // pierwsza petla odpowiada za wyciagniecie listy na ktorej maja znalezc sie wszystkie polaczenia dajace Tripa
                    for (List<Flight> oneTripFlight : properDateFlight) {

                        Flight latestFlight = oneTripFlight.get(oneTripFlight.size() - 1);
                        LocalDateTime arrivalLatest = LocalDateTime.of(latestFlight.getTimes().getDepartureDate(), latestFlight.getTimes().getDepartureTime())
                                .plusHours(latestFlight.getTimes().getFlightTime().getHour())
                                .plusMinutes(latestFlight.getTimes().getFlightTime().getMinute())
                                .plusSeconds(latestFlight.getTimes().getFlightTime().getSecond());

                        LocalTime arrivalLatestTime = arrivalLatest.toLocalTime();
                        LocalDate arrivalLatestDate = arrivalLatest.toLocalDate();


                        for (int k = 0; k < oneConnection.size(); k++) {

                            LocalDateTime departureCurrent = LocalDateTime.of(oneConnection.get(k).getTimes().getDepartureDate(), oneConnection.get(k).getTimes().getDepartureTime());
                            LocalDate departureCurrentDate = departureCurrent.toLocalDate();
                            LocalTime departureCurrentTime = departureCurrent.toLocalTime();

                            if ((departureCurrentDate.isEqual(arrivalLatestDate) &&
                                    ((departureCurrentTime.isAfter(LocalTime.now())) || (departureCurrentTime.equals(LocalTime.now()))) &&
                                    (departureCurrentTime.equals(arrivalLatestTime) || (departureCurrentTime.isAfter(arrivalLatestTime))) &&
                                    (departureCurrent.isAfter(arrivalLatest) && departureCurrent.isBefore(arrivalLatest.plusHours(maxTimeBreak + 1)))) ||
                                    (departureCurrentDate.isAfter(arrivalLatestDate) &&
                                            (departureCurrent.isAfter(arrivalLatest) && departureCurrent.isBefore(arrivalLatest.plusHours(maxTimeBreak + 1))))) {

                                List<Flight> oneTripFlightCopy = new ArrayList<>(oneTripFlight);
                                oneTripFlightCopy.add(oneConnection.get(k));
                                //dla kazdego znalezionego flighta tworzysz dla niego nowa tablice, czekajaca na wypelnienie
                                // jesli zawiera miasto docelowe dodajemy go na ostateczna liste
                                if (oneConnection.get(k).getConnection().getDstAirport().getId().equals(dstAirport)) {
                                    finishListFlights.add(oneTripFlightCopy);
                                } else {
                                    newListProperDateFlight.add(oneTripFlightCopy);
                                }
                            }
                        }
                    }

                    properDateFlight.clear();
                    properDateFlight = newListProperDateFlight;
                }

            }
        }
        for (List<Flight> flights : finishListFlights) {
            for (Flight flight : flights) {
                System.out.println(flight.getConnection().getSrcAirport().getName() + " - " + flight.getConnection().getDstAirport().getName() + ", ");
                System.out.println(flight.getTimes().toString());
            }
            System.out.println();
            System.out.println();
        }
        System.out.println(finishListFlights.size());

        return finishListFlights;
    }
}
