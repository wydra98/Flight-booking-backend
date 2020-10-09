package flight_booking.backend.controllers.flight;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.models.*;
import flight_booking.backend.unit_tests.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@RestController
@ExceptionProcessing
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

    @ApiOperation(value = "Add new flight", authorizations = {@Authorization(value = "authkey")})
    @PostMapping
    ResponseEntity<Flight> addNewFlight(@RequestParam Long airlineId,
                                        @RequestParam int numberSeats,
                                        @RequestParam double price,
                                        @RequestParam Long srcAirportId,
                                        @RequestParam Long dstAirportId,
                                        @RequestParam String departureDate,
                                        @RequestParam String departureTime,
                                        @RequestParam String flightTime) {


        flightService.validateFlight(airlineId, numberSeats, price, srcAirportId, dstAirportId, departureDate,
                departureTime, flightTime, Optional.empty());

        Connection connection = connectionService.addNewConnection(srcAirportId, dstAirportId);
        Flight flight = flightService.addNewFlight(airlineId, numberSeats, price, departureDate,
                departureTime, flightTime, connection);
        return ResponseEntity.created(URI.create("/" + flight.getId())).body(flight);
    }

    @ApiOperation(value = "Update flight", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateFlight(@RequestParam Long flightDtoId,
                                      @RequestParam Long airlineId,
                                      @RequestParam int numberSeats,
                                      @RequestParam double price,
                                      @RequestParam Long srcAirportId,
                                      @RequestParam Long dstAirportId,
                                      @RequestParam String departureDate,
                                      @RequestParam String departureTime,
                                      @RequestParam String flightTime) {

        Optional<Long> flightId = Optional.of(flightDtoId);
        flightService.validateFlight(airlineId, numberSeats, price, srcAirportId, dstAirportId, departureDate,
                departureTime, flightTime, flightId);

        Optional<Flight> flight = flightService.findById(flightDtoId);
        Connection connection = flightService.findConnection(flightDtoId);
        Optional<Airline> airline = airlineService.findById(airlineId);
        Optional<Airport> srcAirport = airportService.findById(srcAirportId);
        Optional<Airport> dstAirport = airportService.findById(dstAirportId);

        if (srcAirport.isPresent() && dstAirport.isPresent()) {
            connection.updateForm(srcAirport.get(), dstAirport.get());
        }

        flight.ifPresent(value -> value.updateForm(
                airline.get(),
                numberSeats,
                price,
                departureDate,
                departureTime,
                flightTime
        ));

        if (flight.isPresent()) {
            flightService.save(flight.get());
            connectionService.save(connection);
        }

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete flight", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {

        flightService.validateId(id);
        Optional<Flight> flight = flightService.findById(id);

        if (flight.isPresent()) {
            List<Flight> flights = new ArrayList<>();
            List<Ticket> tickets;
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
}
