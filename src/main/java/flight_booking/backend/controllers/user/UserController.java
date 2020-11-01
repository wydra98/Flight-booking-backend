package flight_booking.backend.controllers.user;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.models.*;
import flight_booking.backend.services.TripService;
import flight_booking.backend.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@ExceptionProcessing
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TripService tripService;
    private final UserMapper userMapper;

    UserController(UserService userService,
                   TripService tripService) {
        this.userService = userService;
        this.tripService = tripService;
        this.userMapper = new UserMapper();
    }

    @ApiOperation(value = "Get all users", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
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
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {

        userService.validateId(id);
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
}
