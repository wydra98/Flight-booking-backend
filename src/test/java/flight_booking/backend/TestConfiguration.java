package flight_booking.backend;

import flight_booking.backend.repository.AirlineRepository;
import flight_booking.backend.repository.AirportRepository;
import flight_booking.backend.repository.TestAirlineRepository;
import flight_booking.backend.repository.TestAirportRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class TestConfiguration {

    @Bean
    @Primary
    @Profile({"integration", "!prod"})
    AirlineRepository testAirlineRepo() {
        return new TestAirlineRepository();
    }

    @Bean
    @Primary
    @Profile({"integration", "!prod"})
    AirportRepository testAirportRepo() {
        return new TestAirportRepository();
    }
}
