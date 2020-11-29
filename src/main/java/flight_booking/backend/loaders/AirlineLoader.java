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
        System.out.println("Airline" + airlineRepository.amountOfRows());
        if (airlineRepository.amountOfRows() == 0) {

            airlineRepository.save(Airline.builder()
                    .name("LOT")
                    .country("Polska")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Lufthansa")
                    .country("Niemcy")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("American Airlines")
                    .country("USA")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("China Airlines")
                    .country("Chiny")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("WestJet")
                    .country("Kanada")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Qantas Domestic")
                    .country("Australia")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Jetstar Japan")
                    .country("Japonia")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Azul Brazilian Airlines")
                    .country("Brazylia")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Norwegian Air Shuttle")
                    .country("Norwegia")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Air France")
                    .country("Francja")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("British Airways")
                    .country("Wielka Brytania")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Aeroflot")
                    .country("Rosja")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("EgyptAir")
                    .country("Egipt")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("IndiGo")
                    .country("Indie")
                    .build());

            airlineRepository.save(Airline.builder()
                    .name("Ukraine International Airlines")
                    .country("Ukraina")
                    .build());
        }
    }
}

