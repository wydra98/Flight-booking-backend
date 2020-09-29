package flight_booking.backend.controllers.user;

import flight_booking.backend.controllers.trip.TripDto;
import flight_booking.backend.controllers.trip.TripMapper;
import flight_booking.backend.models.*;
import flight_booking.backend.repository.UserRepository;
import flight_booking.backend.service.AirportService;
import flight_booking.backend.service.PassengerService;
import flight_booking.backend.service.TripService;
import flight_booking.backend.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final TripMapper tripMapper;
    private final UserRepository userRepository;
    private final UserService userService;

    UserController(UserRepository userRepository,
                   UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.tripMapper = new TripMapper();
    }

    @ApiOperation(value = "Get all user's trips")
    @GetMapping("/{id}")
    ResponseEntity<Set<TripDto>> getAllUsersTrips(@PathVariable Long id) {

        if (!userService.existsById(id)) {
            throw new NoSuchElementException("User with that id not exist!");
        }

        Optional<User> user = userRepository.findById(id);

        Set<TripDto> tripsDtos = new HashSet<>();
        for (Trip trip : user.get().getTrips()) {
            tripsDtos.add(tripMapper.map(trip));
        }
        return ResponseEntity.ok(tripsDtos);
    }

//    @ApiOperation(value = "Delete airport", authorizations = {@Authorization(value = "authkey")})
//    @Transactional
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Long> deleteAirport(@PathVariable Long id) {
//
//        if (!airportService.existsById(id)) {
//            throw new NoSuchElementException("Airport with that id not exist!");
//        }
//
//        Optional<Airport> airport = airportService.findById(id);
//
//        if (airport.isPresent()) {
//            List<Connection> connections;
//            List<Flight> flights = new ArrayList<>();
//            List<Ticket> tickets = new ArrayList<>();
//            Set<Trip> trips = new HashSet<>();
//
//            connections = connectionService.findConnectionsByAirport(airport.get());
//            if (!connections.isEmpty()) {
//                flights = flightService.findFlightsByConnections(connections);
//                if (!flights.isEmpty()) {
//                    tickets = ticketService.findTicketsByFlights(flights);
//                    if (!tickets.isEmpty()) {
//                        trips = tripService.findTripsByTickets(tickets);
//                    }
//                }
//            }
//
//            if (!trips.isEmpty()) {
//                tripService.deleteTrips(trips);
//            }
//            if (!flights.isEmpty()) {
//                flightService.deleteFlights(flights);
//            }
//            if (!connections.isEmpty()) {
//                connectionService.deleteConnections(connections);
//            }
//            airportService.deleteAirport(airport.get());
//        }
//        return ResponseEntity.ok(id);
//    }
}
