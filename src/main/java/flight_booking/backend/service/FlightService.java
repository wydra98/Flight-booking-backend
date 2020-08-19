package flight_booking.backend.service;

import flight_booking.backend.models.Airlines.Airline;
import flight_booking.backend.models.Connections.Connection;
import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Flights.FlightRepository;
import flight_booking.backend.models.Times;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
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

    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    public Flight addNewFlight(Long airlineDtoId,
                               int numberSeats,
                               double price,
                               String departureDate,
                               String arrivalDate,
                               String arrivalTime,
                               String departureTime,
                               Connection connection) {

        Optional<Airline> airline = airlineService.findById(airlineDtoId);
        Flight flight = Flight.builder()
                .connection(connection)
                .airline(airline.get())
                .numberSeats(numberSeats)
                .price(price)
                .times(Times.builder()
                        .departureDate(LocalDate.parse(departureDate))
                        .arrivalDate(LocalDate.parse(arrivalDate))
                        .arrivalTime(LocalTime.parse(arrivalTime))
                        .departureTime(LocalTime.parse(departureTime))
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

    public List<List<Flight>> findFlights(Long srcAirport, Long dstAirport, LocalDate departureDate, LocalTime departureTime) {

        List<List<Connection>> connections = connectionService.findConnections(srcAirport, dstAirport);
        List<List<Flight>> connections2 = null;
        List<List<List<Flight>>> flights = findAllFlights(connections);
        //List<List<Flight>> properFlights = chooseFlightsWithProperDate(flights, departureDate);

        return connections2;
        //return properFlights;
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

    public List<List<Flight>> chooseFlightsWithProperDate(List<List<List<Flight>>> allFlights, LocalDate userDate) {


        //lista wyszukanych fligtow dla jednego tripa
        List<List<Flight>> properDateFlight = new ArrayList<>();
        // ta lista w kazdej iteracji rzuca nam jednym trpem (lista connectionow)
        for (int i = 0; i < allFlights.size(); i++) {
            //dostep do jednego tripa
            List<List<Flight>> oneTrip = allFlights.get(i);
            //ta petla w kazdej iteracji bedzie nam rzucac jednym connectionem
            for (int j = 0; j < oneTrip.size(); j++) {
                List<Flight> oneConnection = oneTrip.get(j);
                if (j == 0) {
                    //petla cheba pobiera nam wszystkie zagniezdzone flight z connection jednego typu (w tym przypadku )
                    for (int k = 0; k < oneConnection.size(); k++) {
                        if ((oneConnection.get(k).getTimes().getDepartureDate().isEqual(userDate) &&
                                oneConnection.get(k).getTimes().getDepartureTime().isAfter(LocalTime.now())) ||
                                (oneConnection.get(k).getTimes().getDepartureDate().isAfter(userDate) &&
                                        oneConnection.get(k).getTimes().getDepartureDate().isBefore(userDate.plusDays(180)))) {
                            List<Flight> listForNewConnection = new ArrayList<>();
                            listForNewConnection.add(oneConnection.get(k));
                            //dla kazdego znalezionego flighta tworzysz dla niego nowa tablice, czekajaca na wypelnienie
                            properDateFlight.add(listForNewConnection);
                        }
                    }
                } else {

                    // pierwsza petla odpowiada za wyciagniecie listy na ktorej maja znalezc sie wszystkie polaczenia dajace Tripa
                    for (List<Flight> oneTripFlight : properDateFlight) {
                        Flight latestFlight = oneTripFlight.get(oneTripFlight.size() - 1);
                        for (int k = 0; k < oneConnection.size(); k++) {
                            if ((oneConnection.get(k).getTimes().getDepartureDate().isEqual(userDate) &&
                                    oneConnection.get(k).getTimes().getDepartureTime().isAfter(LocalTime.now())) ||
                                    (oneConnection.get(k).getTimes().getDepartureDate().isAfter(userDate) &&
                                            oneConnection.get(k).getTimes().getDepartureDate().isBefore(userDate.plusDays(180)))) {
                                List<Flight> listForNewConnection = new ArrayList<>();
                                listForNewConnection.add(oneConnection.get(k));
                                //dla kazdego znalezionego flighta tworzysz dla niego nowa tablice, czekajaca na wypelnienie
                                properDateFlight.add(listForNewConnection);
                            }
                        }
                    }

                }
                //properDateFlight.add(findProperWay);
            }

//                for (int k = 0; k < listFlightsFromOneConnection.size(); k++) {
//                    if ()
//                }
        }
    }

    //return properDateFlight;
}
}
