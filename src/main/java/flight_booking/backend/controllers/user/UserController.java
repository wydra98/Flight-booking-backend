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

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserService userService;
    private final TripService tripService;

    UserController(UserRepository userRepository,
                   UserService userService,
                   TripService tripService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.tripService = tripService;
        this.userMapper = new UserMapper();
    }

    @ApiOperation(value = "Get all users", authorizations = {@Authorization(value = "authkey")})
    @GetMapping
    ResponseEntity<List<UserDto>> getAllUser() {
        List<User> users = userService.findAll();

        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.map(user));
        }
        return ResponseEntity.ok(userDtos);
    }

    @ApiOperation(value = "Delete user", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {

        if (!userService.existsById(id)) {
            System.out.println("Tutaj jestem");
            throw new NoSuchElementException("User with that id not exist!");
        }

        Optional<User> user = userService.findById(id);

        if (user.isPresent()) {
            Set<Trip> trips = user.get().getTrips();

            if (!trips.isEmpty()) {
                tripService.deleteTrips(trips);
            }

            userService.deleteUser(user.get());
        }

        return ResponseEntity.ok(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<?> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
