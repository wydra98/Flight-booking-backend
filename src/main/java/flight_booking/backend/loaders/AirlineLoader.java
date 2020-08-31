package flight_booking.backend.loaders;

import flight_booking.backend.models.Airline;
import flight_booking.backend.repository.AirlineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AirlineLoader implements CommandLineRunner {

    AirlineRepository airlineRepository;

    AirlineLoader(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (airlineRepository.amountOfRows() == 0) {

            airlineRepository.save(Airline.builder()
                    .name("LOT Polish Airlines")
                    .country("Poland")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Lufthansa")
                    .country("Germany")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("American Airlines")
                    .country("USA")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("China Airlines")
                    .country("China")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("WestJet")
                    .country("Canada")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Qantas Domestic")
                    .country("Australia")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Jetstar Japan")
                    .country("Japan")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Azul Brazilian Airlines")
                    .country("Brazil")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Norwegian Air Shuttle")
                    .country("Norway")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Air France")
                    .country("France")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("British Airways")
                    .country("Great Britain")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Aeroflot")
                    .country("Russia")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("EgyptAir")
                    .country("Egypt")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("IndiGo")
                    .country("India")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Ukraine International Airlines")
                    .country("Ukraine")
                    .build());
        }
    }
}

