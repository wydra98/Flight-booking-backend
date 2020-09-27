package flight_booking.backend.service;

import flight_booking.backend.controllers.authorization.TokenTransfer;
import flight_booking.backend.models.User;
import flight_booking.backend.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public boolean checkIfMailExists(String email) {
        return userRepository.checkIfMailExists(email) > 0;
    }


    public User addNewUser(String name, String surname, String email, String password) {
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();

        userRepository.save(user);
        return user;
    }

    public TokenTransfer login(String email, String password) {
        User user = userRepository.getUserByEmail(email);

        if (user == null) {
            throw new NullPointerException("User with that email not exists.");
        }

        verifyPassword(password, user.getPassword());
        String token = jwtService.sign(user.getEmail(), user.getRole());
        return new TokenTransfer(token, user.getName(), user.getSurname(), user.getEmail(), user.getRole());
    }

    public Boolean verifyPassword(String password, String hash) {
        if (!passwordEncoder.matches(password, hash)) throw new IllegalStateException("Invalid password!");
        return true;
    }
}


