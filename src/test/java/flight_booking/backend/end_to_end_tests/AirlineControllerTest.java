package flight_booking.backend.end_to_end_tests;

import flight_booking.backend.controllers.airline.AirlineDto;
import flight_booking.backend.models.Airline;
import flight_booking.backend.repository.AirlineRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("integration")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AirlineControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    AirlineRepository repo;

    @Test
    void httpGet_returnsAllAirlines() {
        //given
        repo.save(Airline.builder()
                .name("LOT Polish Airlines")
                .country("Poland")
                .build());

        repo.save(Airline.builder()
                .name("Lufthansa")
                .country("Germany")
                .build());

        //when
        AirlineDto[] results = restTemplate.getForObject("http://localhost:" + port + "/airlines", AirlineDto[].class);

        //then
        assertThat(results).hasSize(2);
    }
}
