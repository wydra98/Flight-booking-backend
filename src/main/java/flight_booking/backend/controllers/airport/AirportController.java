package flight_booking.backend.controllers.airport;

import flight_booking.backend.models.*;
import flight_booking.backend.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportService airportService;
    private final ConnectionService connectionService;
    private final FlightService flightService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final AirportMapper mapper = new AirportMapper();

    public AirportController(AirportService airportService,
                             ConnectionService connectionService,
                             FlightService flightService,
                             TicketService ticketService,
                             TripService tripService) {
        this.airportService = airportService;
        this.connectionService = connectionService;
        this.flightService = flightService;
        this.ticketService = ticketService;
        this.tripService = tripService;
    }

    @ApiOperation(value = "Get all airports")
    @GetMapping
    ResponseEntity<List<AirportDto>> getAllAirports() {
        List<Airport> airports = airportService.findAll();

        ArrayList<AirportDto> airportsDtos = new ArrayList<>();
        for (Airport airport : airports) {
            airportsDtos.add(mapper.map(airport));
        }
        return ResponseEntity.ok(airportsDtos);
    }

    @ApiOperation(value = "Add new airport")
    @PostMapping
    ResponseEntity<Airport> addNewAirline(@RequestBody AirportDto airportDto,
                                          @RequestParam double longitude,
                                          @RequestParam double latitude) {

        if (airportService.checkIfAirportExists(airportDto, longitude, latitude)) {
            throw new IllegalStateException("Airport with these data already exist in datebase!");
        }

        Airport airport = airportService.addNewAirport(airportDto, longitude, latitude);
        return ResponseEntity.created(URI.create("/" + airport.getId())).body(airport);
    }

    @ApiOperation(value = "Delete airport")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteAirport(@PathVariable Long id) {

        if (!airportService.existsById(id)) {
            throw new NoSuchElementException("Airport with that id not exist!");
        }

        Optional<Airport> airport = airportService.findById(id);

        if (airport.isPresent()) {
            List<Connection> connections;
            List<Flight> flights = new ArrayList<>();
            List<Ticket> tickets = new ArrayList<>();
            Set<Trip> trips = new HashSet<>();

            connections = connectionService.findConnectionsByAirport(airport.get());
            if (!connections.isEmpty()) {
                flights = flightService.findFlightsByConnections(connections);
                if (!flights.isEmpty()) {
                    tickets = ticketService.findTicketsByFlights(flights);
                    if (!tickets.isEmpty()) {
                        trips = tripService.findTripsByTickets(tickets);
                    }
                }
            }

            if (!trips.isEmpty()) {
                tripService.deleteTrips(trips);
            }
            if (!flights.isEmpty()) {
                flightService.deleteFlights(flights);
            }
            if (!connections.isEmpty()) {
                connectionService.deleteConnections(connections);
            }
            airportService.deleteAirport(airport.get());
        }
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airport")
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateAirport(@RequestBody AirportDto airportDto,
                                       @RequestParam double longitude,
                                       @RequestParam double latitude) {

        if (!airportService.existsById(airportDto.getId())) {
            throw new NoSuchElementException("Airport with that id not exist!");
        }

        Optional<Airport> airport = airportService.findById(airportDto.getId());
        if(airport.isPresent()){
            airport.get().updateForm(airportDto, longitude, latitude);
            airportService.save(airport.get());
        }

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String> handleAirportAlreadyExistsException(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<?> handleAirportNotExistsException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }

}
