package flight_booking.backend.controllers.authorization;

import flight_booking.backend.models.User;
import flight_booking.backend.service.UserService;
import io.swagger.annotations.*;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.regex.Pattern;

@RestController
@Api(value = "User management")
public class AuthorizationController {

    private final UserService userService;

    @Autowired
    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Create new user")
    @PostMapping(value = "/register")
    ResponseEntity<User> register(@RequestParam String name,
                                  @RequestParam String surname,
                                  @RequestParam String email,
                                  @RequestParam String password) {

        if (name.length() == 0 || surname.length() == 0 ||
                email.length() == 0 || password.length() == 0) {
            throw new IllegalStateException("The empty field is not allowed.");
        }

        Pattern pattern1 = Pattern.compile("^[\\p{L} .'-]+$");
        if (!pattern1.matcher(name).matches() ||
                !pattern1.matcher(surname).matches()) {
            throw new IllegalStateException("The passenger first name or surname is invalid.");
        }

        if (password.length() < 2 || name.length() < 2 ||
                surname.length() < 2) {
            throw new IllegalStateException("The field's length is invalid.");
        }

        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalStateException("The passenger email is invalid.");
        }

        if (userService.checkIfMailExists(email)) {
            throw new IllegalStateException("Email already taken!");
        }

        User user = userService.addNewUser(name, surname, email, password);

        return ResponseEntity.created(URI.create("/" + user.getId())).body(user);
    }

    @ApiOperation(value = "Login as user")
    @PostMapping("/login")
    public TokenTransfer login(
            @RequestParam String email,
            @RequestParam String password) {

        if (email.length() == 0 || password.length() == 0) {
            throw new IllegalStateException("The empty field is not allowed.");
        }

        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalStateException("The passenger email is invalid.");
        }

        return userService.login(email, password);
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    ResponseEntity<String> handleNullPointerException(NullPointerException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
