package flight_booking.backend.controllers.airline;

import flight_booking.backend.models.*;
import flight_booking.backend.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;


@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineService airlineService;
    private final FlightService flightService;
    private final TicketService ticketService;
    private final TripService tripService;
    private final AirlineMapper mapper = new AirlineMapper();

    public AirlineController(AirlineService airlineService,
                             ConnectionService connectionService,
                             FlightService flightService,
                             TicketService ticketService,
                             TripService tripService) {
        this.airlineService = airlineService;
        this.flightService = flightService;
        this.ticketService = ticketService;
        this.tripService = tripService;
    }

    @ApiOperation(value = "Get all airlines")
    @GetMapping
    ResponseEntity<List<AirlineDto>> getAllAirlines() {
        List<Airline> airlines = airlineService.findAll();

        ArrayList<AirlineDto> airlineDtos = new ArrayList<>();
        for (Airline airline : airlines) {
            airlineDtos.add(mapper.map(airline));
        }

        return ResponseEntity.ok(airlineDtos);
    }

    @ApiOperation(value = "Add new airline")
    @PostMapping
    ResponseEntity<Airline> addNewAirline(@RequestBody AirlineDto airlineDto,
                                          @RequestParam String country) {

        if (airlineService.checkIfAirlineExists(airlineDto, country)) {
            throw new IllegalStateException("Airline with these data already exist ins datebase!");
        }

        Airline airline = airlineService.addNewAirline(airlineDto, country);
        return ResponseEntity.created(URI.create("/" + airline.getId())).body(airline);
    }

    @ApiOperation(value = "Delete airline")
    @Transactional
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> deleteAirline(@PathVariable Long id) {

        if (!airlineService.existsById(id)) {
            throw new NoSuchElementException("Airline with that id not exist!");
        }

        Optional<Airline> airline = airlineService.findById(id);

        if (airline.isPresent()) {
            List<Flight> flights;
            List<Ticket> tickets = new ArrayList<>();
            Set<Trip> trips = new HashSet<>();

            flights = flightService.findFlightsByAirline(airline.get());
            if (!flights.isEmpty()) {
                tickets = ticketService.findTicketsByFlights(flights);
                if (!tickets.isEmpty()) {
                    trips = tripService.findTripsByTickets(tickets);
                }
            }

            if (!trips.isEmpty()) {
                tripService.deleteTrips(trips);
            }
            if (!tickets.isEmpty()) {
                ticketService.deleteTickets(tickets);
            }
            if (!flights.isEmpty()) {
                flightService.deleteFlights(flights);
            }
            airlineService.deleteAirline(airline.get());
        }
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airline")
    @PutMapping
    ResponseEntity<Void> updateAirline(@RequestBody AirlineDto airlineDto,
                                       @RequestParam String country) {

        if (!airlineService.existsById(airlineDto.getId())) {
            throw new NoSuchElementException("Airline with that ID not exist!");
        }

        Optional<Airline> airlineOptional = airlineService.findById(airlineDto.getId());
        if (airlineOptional.isPresent()) {
            airlineOptional.get().updateForm(airlineDto, country);
            airlineService.save(airlineOptional.get());
        }

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

