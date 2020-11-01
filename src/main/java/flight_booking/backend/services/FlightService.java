package flight_booking.backend.services;

import flight_booking.backend.models.*;
import flight_booking.backend.repository.FlightRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FlightService {

    private static final int MAX_TIME_BREAK = 12;
    private final FlightRepository flightRepository;
    private final ConnectionService connectionService;
    private final AirlineService airlineService;
    private final AirportService airportService;

    FlightService(FlightRepository flightRepository,
                  ConnectionService connectionService,
                  AirlineService airlineService,
                  AirportService airportService) {
        this.flightRepository = flightRepository;
        this.connectionService = connectionService;
        this.airlineService = airlineService;
        this.airportService = airportService;
    }

    public Connection findConnection(Long flightId) {

        Long id_connection = flightRepository.findIdConnectionByFlight(flightId);
        return connectionService.findById(id_connection).get();
    }

    public List<Flight> findFlightsByAirline(Airline airline) {

        return flightRepository.findFlightsByAirline(airline);
    }

    public List<Flight> findFlightsByConnections(List<Connection> connections) {

        List<List<Flight>> listOfFlights = new ArrayList<>();
        List<Flight> flights = new ArrayList<>();
        int i = 0;
        for (Connection connection : connections) {

            List<Flight> resultFlights = flightRepository.findFlightsByConnection(connection);

            for (Flight result : resultFlights) {
                System.out.println(result);
            }
            System.out.println();
            System.out.println(connection.toString());
            if (!resultFlights.isEmpty()) {
                System.out.println(i++);
                listOfFlights.add(resultFlights);
            }
        }

        for (List<Flight> flights1 : listOfFlights) {
            for (Flight flight : flights1) {
                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public void validateId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Flight with that id not exist!");
        }
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

    public Optional<Flight> findById(Long id) {
        return flightRepository.findById(id);
    }

    public List<List<Flight>> findFlights(Long srcAirport, Long dstAirport, LocalDate departureDate, int passengerNumber) {

        List<List<Connection>> connections = connectionService.findConnections(srcAirport, dstAirport);
        List<List<List<Flight>>> flights = findAllFlights(connections);
        List<List<Flight>> properFlights = chooseFlightsWithProperDate(flights, dstAirport, departureDate, passengerNumber);

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

    public void validateFlight(Long airlineId, int numberSeats, double price,
                               Long srcAirportId, Long dstAirportId,
                               String departureDate, String arrivalDate,
                               String flightTime, Optional<Long> flightOptId) {

        if (flightOptId.isPresent()) {
            if (existsById(flightOptId.get())) {
                throw new NoSuchElementException("Flight with that id not exist!");
            }

            if (!connectionService.existsById(flightOptId.get())) {
                throw new NoSuchElementException("Connection with that id not exist!");
            }
        }

        if (!airlineService.existsById(airlineId)) {
            throw new NoSuchElementException("Airline with that id not exist!");
        }

        if (!airportService.existsById(srcAirportId) || !airportService.existsById(dstAirportId)) {
            throw new NoSuchElementException("Airport with that id not exist!");
        }

        if (numberSeats < 0 || numberSeats > 350) {
            throw new IllegalStateException("Set number is not proper!");
        }

        if (price <= 0 || price > 2000) {
            throw new IllegalStateException("The price is not proper!");
        }

        if (srcAirportId.equals(dstAirportId)) {
            throw new IllegalStateException("Source and destination airport must be different.");
        }

        LocalDate departureDateParse = LocalDate.parse(departureDate);
        LocalDate arrivalDateParse = LocalDate.parse(arrivalDate);
        LocalTime flightTimeParse = LocalTime.parse(flightTime);

        if (arrivalDateParse.isBefore(departureDateParse)) {
            throw new IllegalStateException("The date range is invalid.");
        }
    }

    public List<List<Flight>> chooseFlightsWithProperDate(List<List<List<Flight>>> allFlights, Long dstAirport,
                                                          LocalDate userDepartureDate, int passengerNumber) {

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

                        if (oneConnection.get(k).getAvailableSeats() >= passengerNumber) {
                            LocalDate departureDate = oneConnection.get(k).getTimes().getDepartureDate();
                            LocalTime departureTime = oneConnection.get(k).getTimes().getDepartureTime();

                            if ((departureDate.isEqual(userDepartureDate) && (departureDate.isEqual(LocalDate.now()) &&
                                    departureTime.isAfter(LocalTime.now()))) ||
                                    ((departureDate.isEqual(userDepartureDate) && departureDate.isAfter(LocalDate.now())))) {

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

                            if (oneConnection.get(k).getAvailableSeats() >= passengerNumber) {
                                LocalDateTime departureCurrent = LocalDateTime.of(oneConnection.get(k).getTimes().getDepartureDate(), oneConnection.get(k).getTimes().getDepartureTime());
                                LocalDate departureCurrentDate = departureCurrent.toLocalDate();
                                LocalTime departureCurrentTime = departureCurrent.toLocalTime();

                                if ((departureCurrentDate.isEqual(arrivalLatestDate) &&
                                        ((departureCurrentTime.isAfter(LocalTime.now())) || (departureCurrentTime.equals(LocalTime.now()))) &&
                                        (departureCurrentTime.equals(arrivalLatestTime) || (departureCurrentTime.isAfter(arrivalLatestTime))) &&
                                        (departureCurrent.isAfter(arrivalLatest) && departureCurrent.isBefore(arrivalLatest.plusHours(MAX_TIME_BREAK + 1)))) ||
                                        (departureCurrentDate.isAfter(arrivalLatestDate) &&
                                                (departureCurrent.isAfter(arrivalLatest) && departureCurrent.isBefore(arrivalLatest.plusHours(MAX_TIME_BREAK + 1))))) {

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
                    }

                    properDateFlight.clear();
                    properDateFlight = newListProperDateFlight;
                }

            }
        }
        return finishListFlights;
    }

    public void deleteFlights(List<Flight> flights) {
        for (Flight flight : flights) {
            flightRepository.deleteById(flight.getId());
        }
    }
}
