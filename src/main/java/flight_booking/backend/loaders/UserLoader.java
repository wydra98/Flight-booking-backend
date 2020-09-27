package flight_booking.backend.loaders;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.User;
import flight_booking.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UserLoader implements CommandLineRunner {

    UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    UserLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (userRepository.amountOfRows() == 0) {

            userRepository.save(User.builder()
                    .name("admin")
                    .surname("admin")
                    .email("wydra.adrian98@gmail.com")
                    .password(passwordEncoder.encode("admin"))
                    .role("ROLE_ADMIN")
                    .build());
        }
    }
}
