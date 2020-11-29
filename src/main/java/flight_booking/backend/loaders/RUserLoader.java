package flight_booking.backend.loaders;

import flight_booking.backend.models.*;
import flight_booking.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class RUserLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    RUserLoader(UserRepository userRepository,
                PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        System.out.println("Connection" + userRepository.amountOfRows());
        if (userRepository.amountOfRows() == 0) {

            userRepository.save(User.builder()
                    .name("admin")
                    .surname("admin")
                    .email("wydra.adrian98@gmail.com")
                    .password(passwordEncoder.encode("wydra98"))
                    .role("ROLE_ADMIN")
                    .build());

            userRepository.save(User.builder()
                    .name("Adrian")
                    .surname("Wydra")
                    .email("adek868@interia.eu")
                    .password(passwordEncoder.encode("wydra98"))
                    .role("ROLE_USER")
                    .build());
        }

    }
}
