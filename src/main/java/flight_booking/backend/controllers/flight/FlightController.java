package flight_booking.backend.controllers.flight;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.controllers.airline.AirlineDto;
import flight_booking.backend.controllers.airline.AirlineMapper;
import flight_booking.backend.controllers.airport.AirportDto;
import flight_booking.backend.controllers.airport.AirportMapper;
import flight_booking.backend.models.*;
import flight_booking.backend.services.*;
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
    private final AirlineMapper airlineMapper;
    private final AirportMapper airportMapper;

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
        this.airlineMapper = new AirlineMapper();
        this.airportMapper = new AirportMapper();
    }

    @ApiOperation(value = "Get all flights", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    ResponseEntity<List<FlightResponse>> getAllFlights() {
        List<Flight> flights = flightService.findAll();

        ArrayList<FlightResponse> flightResponse = new ArrayList<>();

        for (Flight flight : flights) {
            AirlineDto airlineDto = airlineMapper.map(flight.getAirline());
            AirportDto airportSrcDto = airportMapper.map(flight.getConnection().getSrcAirport());
            AirportDto airportDstDto = airportMapper.map(flight.getConnection().getDstAirport());
            flightResponse.add(new FlightResponse(flight.getId(), airlineDto.getName(), flight.getNumberSeats(), flight.getPrice(),
                    airportSrcDto.getName(), airportDstDto.getName(), flight.getTimes().getDepartureDate().toString(),
                    flight.getTimes().getDepartureTime().toString(), flight.getTimes().getFlightTime().toString()));
        }
        return ResponseEntity.ok(flightResponse);
    }

    @ApiOperation(value = "Add new flight", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @PostMapping
    ResponseEntity<Flight> addNewFlight(@RequestBody FlightRequest flightRequest) {

        flightService.validateFlight(flightRequest.getAirlineId(), flightRequest.getNumberSeats(), flightRequest.getPrice(),
                flightRequest.getSrcAirportId(), flightRequest.getDstAirportId(), flightRequest.getDepartureDate(),
                flightRequest.getDepartureTime(), flightRequest.getFlightTime(), Optional.empty());

        Connection connection = connectionService.addNewConnection(flightRequest.getSrcAirportId(), flightRequest.getDstAirportId());
        Flight flight = flightService.addNewFlight(flightRequest.getAirlineId(), flightRequest.getNumberSeats(), flightRequest.getPrice(), flightRequest.getDepartureDate(),
                flightRequest.getDepartureTime(), flightRequest.getFlightTime(), connection);
        return ResponseEntity.created(URI.create("/" + flight.getId())).body(flight);
    }

    @ApiOperation(value = "Update flight", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @PutMapping
    ResponseEntity<FlightRequest> updateFlight(@RequestBody FlightRequest flightRequest) {

        Optional<Long> flightId = Optional.of(flightRequest.getId());
        flightService.validateFlight(flightRequest.getAirlineId(), flightRequest.getNumberSeats(), flightRequest.getPrice(),
                flightRequest.getSrcAirportId(), flightRequest.getDstAirportId(), flightRequest.getDepartureDate(),
                flightRequest.getDepartureTime(), flightRequest.getFlightTime(), flightId);

        Optional<Flight> flight = flightService.findById(flightRequest.getId());
        Connection connection = flightService.findConnection(flightRequest.getId());
        Optional<Airline> airline = airlineService.findById(flightRequest.getAirlineId());
        Optional<Airport> srcAirport = airportService.findById(flightRequest.getSrcAirportId());
        Optional<Airport> dstAirport = airportService.findById(flightRequest.getDstAirportId());

        if (srcAirport.isPresent() && dstAirport.isPresent()) {
            connection.updateForm(srcAirport.get(), dstAirport.get());
        }

        flight.ifPresent(value -> value.updateForm(
                airline.get(),
                flightRequest.getNumberSeats(),
                flightRequest.getPrice(),
                flightRequest.getDepartureDate(),
                flightRequest.getDepartureTime(),
                flightRequest.getFlightTime()
        ));

        if (flight.isPresent()) {
            flightService.save(flight.get());
            connectionService.save(connection);
        }

        return ResponseEntity.ok(flightRequest);
    }

    @ApiOperation(value = "Delete flight", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteFlight(@RequestParam Long id) {

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
