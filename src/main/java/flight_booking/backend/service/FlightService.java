package flight_booking.backend.service;

import flight_booking.backend.controllers.AirlineController.AirlineDto;
import flight_booking.backend.models.Airline.Airline;
import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Flight.FlightRepository;
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
        List<List<Flight>> flights = mapToFlight(connections);
        return flights;
    }

    public List<List<Flight>> mapToFlight(List<List<Connection>> listConnections) {

        List<List<Flight>> allflights = new ArrayList<>();
        List<Flight> oneflight = new ArrayList<>();
        for (List<Connection> connections : listConnections) {
            for (Connection connection : connections){
                List<Flight> flights = flightRepository.findFlightsByConnection(connection);
                Flight flight = flights.get(0);
                oneflight.add(flight);
            }
            allflights.add(oneflight);
            oneflight.clear();
        }

        return allflights;
    }


}
