package flight_booking.backend.controllers.flight;

import flight_booking.backend.models.*;
import flight_booking.backend.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final ConnectionService connectionService;
    private final FlightService flightService;
    private final AirlineService airlineService;
    private final AirportService airportService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final FlightMapper flightMapper;

    FlightController(ConnectionService connectionService,
                     FlightService flightService,
                     AirlineService airlineService,
                     AirportService airportService,
                     TicketService ticketService,
                     TripService tripService) {
        this.connectionService = connectionService;
        this.flightService = flightService;
        this.airlineService = airlineService;
        this.airportService = airportService;
        this.ticketService = ticketService;
        this.tripService = tripService;
        this.flightMapper = new FlightMapper();
    }

    @ApiOperation(value = "Get all flights", authorizations = {@Authorization(value = "authkey")})
    @GetMapping
    ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flights = flightService.findAll();

        ArrayList<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            Connection connection = flightService.findConnection(flight.getId());
            flightDtos.add(flightMapper.map(flight, connection));
        }
        return ResponseEntity.ok(flightDtos);
    }

    //TODO read about twice @Requestbody in arguments of one function
    //TODO add validators for examples like "if airlineId exists"
    @ApiOperation(value = "Add new flight", authorizations = {@Authorization(value = "authkey")})
    @PostMapping
    ResponseEntity<Flight> addNewFlight(@RequestParam Long airlineDtoId,
                                        @RequestParam int numberSeats,
                                        @RequestParam double price,
                                        @RequestParam Long srcAirportId,
                                        @RequestParam Long dstAirportId,
                                        @RequestParam String departureDate,
                                        @RequestParam String departureTime,
                                        @RequestParam String flightTime) {

        Connection connection = connectionService.addNewConnection(srcAirportId, dstAirportId);
        Flight flight = flightService.addNewFlight(airlineDtoId, numberSeats, price, departureDate,
                departureTime, flightTime, connection);
        return ResponseEntity.created(URI.create("/" + flight.getId())).body(flight);

    }

    //TODO add validators for examples like "if airlineId exists"
    @ApiOperation(value = "Update flight", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateFlight(@RequestParam Long flightId,
                                      @RequestParam Long airlineId,
                                      @RequestParam int numberSeats,
                                      @RequestParam double price,
                                      @RequestParam Long srcAirportId,
                                      @RequestParam Long dstAirportId,
                                      @RequestParam String departureDate,
                                      @RequestParam String departureTime,
                                      @RequestParam String flightTime) {

        if (!flightService.existsById(flightId)) {
            throw new NoSuchElementException("Flight with that id not exist!");
        }

        if (!connectionService.existsById(flightId)) {
            throw new NoSuchElementException("Connection with that id not exist!");
        }

        Optional<Flight> flightOptional = flightService.findById(flightId);
        Connection connection = flightService.findConnection(flightId);
        Optional<Airline> airline = airlineService.findById(airlineId);
        Optional<Airport> srcAirport = airportService.findById(srcAirportId);
        Optional<Airport> dstAirport = airportService.findById(dstAirportId);

        connection.updateForm(
                srcAirport.get(),
                dstAirport.get()
        );

        flightOptional.get().updateForm(
                airline.get(),
                numberSeats,
                price,
                departureDate,
                departureTime,
                flightTime
        );

        if (flightOptional.isPresent()) {
            flightService.save(flightOptional.get());
            connectionService.save(connection);
        }

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete flight", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {

        if (!flightService.existsById(id)) {
            throw new NoSuchElementException("Flight with that id not exist!");
        }

        Optional<Flight> flight = flightService.findById(id);

        if (flight.isPresent()) {
            List<Flight> flights = new ArrayList<>();
            List<Ticket> tickets = new ArrayList<>();
            Set<Trip> trips = new HashSet<>();
            flights.add(flight.get());

            if (!flights.isEmpty()) {
                tickets = ticketService.findTicketsByFlights(flights);
                if (!tickets.isEmpty()) {
                    trips = tripService.findTripsByTickets(tickets);
                }

                if (!trips.isEmpty()) {
                    tripService.deleteTrips(trips);
                }

                flightService.deleteFlights(flights);
            }
        }
        return ResponseEntity.ok(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<?> handleConnectionNotExistsException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }
}
