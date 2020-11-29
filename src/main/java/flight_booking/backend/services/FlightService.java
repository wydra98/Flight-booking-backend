package flight_booking.backend.services;

import flight_booking.backend.models.*;
import flight_booking.backend.repository.FlightRepository;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class FlightService {

    private int MAX_TIME_BREAK;
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

            if (!resultFlights.isEmpty()) {
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
            throw new NoSuchElementException("Taki lot nie istnieje w bazie!");
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

        String parsedTime = null;
        if (flightTime.length() == 1) {
            parsedTime = "0" + flightTime + ":00";
        } else {
            parsedTime = flightTime + ":00";
        }

        String parsedDepartureTime = null;
        String[] arrayString = departureTime.split(":");
        if (arrayString[0].length() == 1) {
            arrayString[0] = '0' + arrayString[0];
        }
        if (arrayString[1].length() == 1) {
            arrayString[1] = '0' + arrayString[1];
        }
        parsedDepartureTime = arrayString[0] + ":" + arrayString[1];

        Optional<Airline> airline = airlineService.findById(airlineDtoId);
        Flight flight = Flight.builder()
                .connection(connection)
                .airline(airline.get())
                .numberSeats(numberSeats)
                .availableSeats(numberSeats)
                .price(price)
                .times(Times.builder()
                        .departureDate(LocalDate.parse(departureDate))
                        .departureTime(LocalTime.parse(parsedDepartureTime))
                        .flightTime(LocalTime.parse(parsedTime))
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

    public List<List<Flight>> findFlights(Long srcAirport, Long dstAirport, LocalDate from, LocalDate to, int passengerNumber,
                                          int maxChanges, int maxTimeBetweenChanges) {

        this.MAX_TIME_BREAK = maxTimeBetweenChanges;
        List<List<Connection>> connections = connectionService.findConnections(srcAirport, dstAirport, maxChanges);
        List<List<List<Flight>>> flights = findAllFlights(connections);
        List<List<Flight>> properFlights = chooseFlightsWithProperDate(flights, dstAirport, from, to, passengerNumber);

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
                               String departureDate, String departureTime,
                               String flightTime, Optional<Long> flightOptId) {

        if (flightOptId.isPresent()) {
            if (!existsById(flightOptId.get())) {
                throw new NoSuchElementException("Taki lot nie istnieje w bazie!");
            }

            if (!connectionService.existsById(flightOptId.get())) {
                throw new NoSuchElementException("Takie połączenie nie istnieje w bazie!");
            }
        }

        if (!airlineService.existsById(airlineId)) {
            throw new NoSuchElementException("Taka linia lotnicza nie istnieje w bazie!");
        }

        if (!airportService.existsById(srcAirportId) || !airportService.existsById(dstAirportId)) {
            throw new NoSuchElementException("Takie lotnisko nie istnieje w bazie!");
        }

        if (numberSeats < 1 || numberSeats > 350) {
            throw new IllegalStateException("Liczba miejsc nie jest poprawna!");
        }

        if (Integer.parseInt(flightTime) < 1 || Integer.parseInt(flightTime) > 24) {
            throw new IllegalStateException("Liczba miejsc nie jest poprawna!");
        }

        if (price < 1 || price > 2000) {
            throw new IllegalStateException("Cena nie jest odpowiednia!");
        }

        if (srcAirportId.equals(dstAirportId)) {
            throw new IllegalStateException("Lotniska muszą się różnić.");
        }

        LocalDate.parse(departureDate);

        String[] arrayString = departureTime.split(":");
        if (arrayString[0].length() == 1) {
            arrayString[0] = '0' + arrayString[0];
        }
        if (arrayString[1].length() == 1) {
            arrayString[1] = '0' + arrayString[1];
        }
        String parsedDepartureTime = arrayString[0] + ":" + arrayString[1];
        LocalTime.parse(parsedDepartureTime);
    }

    public List<List<Flight>> chooseFlightsWithProperDate(List<List<List<Flight>>> allFlights, Long dstAirport,
                                                          LocalDate from, LocalDate to,
                                                          int passengerNumber) {

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
                    //petla cheba pobiera nam wszystkie zagniezdzone flight z connection jednego typu (w tym przypadku)
                    List<List<Flight>> newListProperDateFlight = new ArrayList<>();
                    for (int k = 0; k < oneConnection.size(); k++) {

                        if (oneConnection.get(k).getAvailableSeats() >= passengerNumber) {
                            LocalDate departureDate = oneConnection.get(k).getTimes().getDepartureDate();
                            LocalTime departureTime = oneConnection.get(k).getTimes().getDepartureTime();

                            if ((departureDate.isEqual(from) && (departureDate.isEqual(LocalDate.now()) &&
                                    departureTime.isAfter(LocalTime.now()))) ||
                                    ((departureDate.isEqual(from) && departureDate.isAfter(LocalDate.now()))) ||
                                    (departureDate.isAfter(from) && departureDate.isBefore(to.plusDays(1)))
                                            && finishListFlights.size() <= 50) {

                                List<Flight> oneTripFlightCopy = new ArrayList<>();
                                oneTripFlightCopy.add(oneConnection.get(k));
                                //dla kazdego znalezionego flighta tworzysz dla niego nowa tablice, czekajaca na wypelnienie
                                // jesli zawiera miasto docelowe dodajemy go na ostateczna liste
                                if (oneConnection.get(k).getConnection().getDstAirport().getId().equals(dstAirport) && newListProperDateFlight.size() <= 100) {
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
                        LocalDateTime arrivalLatest = LocalDateTime.of(latestFlight.getTimes().getDepartureDate(),
                                latestFlight.getTimes().getDepartureTime())
                                .plusHours(latestFlight.getTimes().getFlightTime().getHour())
                                .plusMinutes(latestFlight.getTimes().getFlightTime().getMinute())
                                .plusSeconds(latestFlight.getTimes().getFlightTime().getSecond());

                        LocalTime arrivalLatestTime = arrivalLatest.toLocalTime();
                        LocalDate arrivalLatestDate = arrivalLatest.toLocalDate();


                        for (int k = 0; k < oneConnection.size(); k++) {

                            if (oneConnection.get(k).getAvailableSeats() >= passengerNumber) {
                                LocalDateTime departureCurrent = LocalDateTime.of(oneConnection.get(k).getTimes().getDepartureDate(),
                                        oneConnection.get(k).getTimes().getDepartureTime());
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
