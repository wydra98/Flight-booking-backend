package flight_booking.backend.controllers.user;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.*;
import flight_booking.backend.services.TripService;
import flight_booking.backend.services.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;

@RestController
@ExceptionProcessing
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final TripService tripService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    UserController(UserService userService,
                   TripService tripService,
                   PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.tripService = tripService;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = new UserMapper();
    }


    @ApiOperation(value = "Get all users", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/get")
    ResponseEntity<List<UserDto>> getAllUser() {

        List<User> users = userService.findAll();

        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.map(user));
        }
        return ResponseEntity.ok(userDtos);
    }

    @ApiOperation(value = "Get user from trip", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/trip")
    ResponseEntity<UserDto> getPassengersAssignedToTrip(@RequestParam Long id) {

        tripService.validateTripId(id);
        User user = userService.findUserByTrip(id);

        UserDto userDto = userMapper.map(user);

        return ResponseEntity.ok(userDto);
    }

    @ApiOperation(value = "Delete user", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/delete")
    public ResponseEntity<Long> deleteUser(@RequestParam Long id) {

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

    @ApiOperation(value = "Modify user", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @PutMapping("/modifyUser")
    ResponseEntity<UserDto> updateUser(@RequestParam Long id,
                                       @RequestParam String name,
                                       @RequestParam String surname,
                                       @RequestParam String email,
                                       @RequestParam String newPassword) {

        userService.validateId(id);

        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalStateException("Adres email jest niepoprawny.");
        }

        if (userService.checkIfMailExists(email)) {
            throw new IllegalStateException("Ten adres email jest zajęty!");
        }

        Optional<User> userOptional = userService.findById(id);
        User user = null;
        if (userOptional.isPresent()) {
            String encodePassword = passwordEncoder.encode(newPassword);
            userOptional.get().updateForm(name, surname, email, encodePassword);
            user = userService.save(userOptional.get());
        }
        UserDto userDto = userMapper.map(user);

        return ResponseEntity.ok(userDto);
    }
}
