package flight_booking.backend.unit_tests;

import flight_booking.backend.controllers.authorization.TokenTransfer;
import flight_booking.backend.controllers.user.UserDto;
import flight_booking.backend.controllers.user.UserMapper;
import flight_booking.backend.models.User;
import flight_booking.backend.repository.UserRepository;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean checkIfMailExists(String email) {
        return userRepository.checkIfMailExists(email) > 0;
    }

    public User addNewUser(String name, String surname, String email, String password) {
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(passwordEncoder.encode(password))
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
        return user;
    }

    public void validateRegistration(String name, String surname, String email, String password) {
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

        if (checkIfMailExists(email)) {
            throw new IllegalStateException("Email already taken!");
        }
    }

    public void validateLogin(String email, String password) {
        if (email.length() == 0 || password.length() == 0) {
            throw new IllegalStateException("The empty field is not allowed.");
        }

        if (!EmailValidator.getInstance().isValid(email)) {
            throw new IllegalStateException("The passenger email is invalid.");
        }
    }

    public void validateId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("User with that id not exist!");
        }
    }

    public TokenTransfer login(String email, String password) {
        User user = userRepository.getUserByEmail(email);

        if (user == null) {
            throw new NullPointerException("User with that email not exists.");
        }

        UserMapper userMapper = new UserMapper();
        UserDto userDto = userMapper.map(user);

        verifyPassword(password, user.getPassword());
        String token = jwtService.sign(user.getEmail(), user.getRole());
        return new TokenTransfer(token, userDto);
    }

    public Boolean verifyPassword(String password, String hash) {
        if (!passwordEncoder.matches(password, hash)) throw new IllegalStateException("Invalid password!");
        return true;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.deleteById(user.getId());
    }


}


