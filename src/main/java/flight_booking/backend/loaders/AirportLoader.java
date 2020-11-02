package flight_booking.backend.loaders;

import flight_booking.backend.repository.AirportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import flight_booking.backend.models.Airport;

import javax.transaction.Transactional;

@Component
public class AirportLoader implements CommandLineRunner {

    AirportRepository airportRepository;

    AirportLoader(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (airportRepository.amountOfRows() == 0) {

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Nowy Jork")
                    .longitude(-118.410042)
                    .latitude(33.942791)
                    .city("Nowy Jork")
                    .country("USA")
                    .timezone(-4)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Chicago-O’Hare")
                    .longitude(-87.904724)
                    .latitude(41.978611)
                    .city("Chicago")
                    .country("USA")
                    .timezone(-5)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Lotnisko Chopina")
                    .longitude(20.9678911)
                    .latitude(52.1672369)
                    .city("Warszawa")
                    .country("Polska")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Pekin")
                    .longitude(116.383331)
                    .latitude(39.916668)
                    .city("Pekin")
                    .country("Chiny")
                    .timezone(8)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Berlin-Tegel")
                    .longitude(13.404954)
                    .latitude(52.520008)
                    .city("Berlin")
                    .country("Niemcy")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Szanghaj-Pudong")
                    .longitude(121.469170)
                    .latitude(31.224361)
                    .city("Shanghaj")
                    .country("Chiny")
                    .timezone(8)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Toronto-Lester")
                    .longitude(-79.347015)
                    .latitude(43.651070)
                    .city("Toronto")
                    .country("Kanada")
                    .timezone(-4)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Sydney")
                    .longitude(151.209900)
                    .latitude(-33.865143)
                    .city("Sydney")
                    .country("Canada")
                    .timezone(10)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Tokio-Haneda")
                    .longitude(139.839478)
                    .latitude(35.652832)
                    .city("Tokio")
                    .country("Japonia")
                    .timezone(9)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Rio de Janeiro")
                    .longitude(-43.196388)
                    .latitude(-22.908333)
                    .city("Rio de Janeiro")
                    .country("Brazylia")
                    .timezone(-3)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Oslo-Gardermoen")
                    .longitude(10.757933)
                    .latitude(59.911491)
                    .city("Oslo")
                    .country("Norwegia")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Jorge Newbery")
                    .longitude(-58.381592)
                    .latitude(-34.603722)
                    .city("Buenos Aires")
                    .country("Brazylia")
                    .timezone(-3)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Paryż-Orly")
                    .longitude(2.349014)
                    .latitude(48.864716)
                    .city("Paryż")
                    .country("Francja")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Londyn-City")
                    .longitude(-0.118092)
                    .latitude(51.509865)
                    .city("Londyn")
                    .country("Wielka Brytania")
                    .timezone(1)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Los Angeles")
                    .longitude(-118.243683)
                    .latitude(34.052235)
                    .city("Los Angeles")
                    .country("USA")
                    .timezone(-7)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Moskwa-Wnukowo")
                    .longitude(37.618423)
                    .latitude(55.751244)
                    .city("Moskwa")
                    .country("Rosja")
                    .timezone(3)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Kair")
                    .longitude(31.233334)
                    .latitude(30.033333)
                    .city("Kair")
                    .country("Egipt")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Kraków-Balice")
                    .longitude(19.944544)
                    .latitude(50.049683)
                    .city("Kraków")
                    .country("Polska")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Indira Gandhi")
                    .longitude(77.216721)
                    .latitude(28.644800)
                    .city("Delhi")
                    .country("Indie")
                    .timezone(5)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Port lotniczy Kijów-Boryspol")
                    .longitude(30.517023)
                    .latitude(50.431759)
                    .city("Kijów")
                    .country("Ukraina")
                    .timezone(3)
                    .build());
        }
    }
}
