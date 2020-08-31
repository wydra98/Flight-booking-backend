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
                    .name("John F. Kennedy International Airport")
                    .longitude(-118.410042)
                    .latitude(33.942791)
                    .city("New York")
                    .country("USA")
                    .timezone(-4)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Chicago O'Hare International Airport")
                    .longitude(-87.904724)
                    .latitude(41.978611)
                    .city("Chicago")
                    .country("USA")
                    .timezone(-5)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Warsaw Chopin Airport")
                    .longitude(20.9678911)
                    .latitude(52.1672369)
                    .city("Warsaw")
                    .country("Poland")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Beijing Capital International Airport")
                    .longitude(116.383331)
                    .latitude(39.916668)
                    .city("Pekin")
                    .country("China")
                    .timezone(8)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Berlin Tegel Airport")
                    .longitude(13.404954)
                    .latitude(52.520008)
                    .city("Berlin")
                    .country("Germany")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Shanghai Pudong Airport")
                    .longitude(121.469170)
                    .latitude(31.224361)
                    .city("Shanghai")
                    .country("China")
                    .timezone(8)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Toronto Pearson Airport")
                    .longitude(-79.347015)
                    .latitude(43.651070)
                    .city("Toronto")
                    .country("Canada")
                    .timezone(-4)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Sydney Airport")
                    .longitude(151.209900)
                    .latitude(-33.865143)
                    .city("Sydney")
                    .country("Canada")
                    .timezone(10)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Haneda Airport")
                    .longitude(139.839478)
                    .latitude(35.652832)
                    .city("Tokyo")
                    .country("Japan")
                    .timezone(9)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Rio de Janeiro International Airport")
                    .longitude(-43.196388)
                    .latitude(-22.908333)
                    .city("Rio de Janeiro")
                    .country("Brazil")
                    .timezone(-3)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Oslo Airport - Avinor")
                    .longitude(10.757933)
                    .latitude(59.911491)
                    .city("Oslo")
                    .country("Norway")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Buenos Aires Ezeiza Airport")
                    .longitude(-58.381592)
                    .latitude(-34.603722)
                    .city("Buenos Aires")
                    .country("Brazil")
                    .timezone(-3)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Charles de Gaulle Airport")
                    .longitude(2.349014)
                    .latitude(48.864716)
                    .city("Paris")
                    .country("France")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("London City Airport")
                    .longitude(-0.118092)
                    .latitude(51.509865)
                    .city("London")
                    .country("Great Britain")
                    .timezone(1)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Los Angeles International Airport")
                    .longitude(-118.243683)
                    .latitude(34.052235)
                    .city("Los Angeles")
                    .country("USA")
                    .timezone(-7)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Sheremetyevo International Airport")
                    .longitude(37.618423)
                    .latitude(55.751244)
                    .city("Moscow")
                    .country("Russia")
                    .timezone(3)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Cairo International Airport")
                    .longitude(31.233334)
                    .latitude(30.033333)
                    .city("Cairo")
                    .country("Egypt")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Kraków John Paul II International Airport")
                    .longitude(19.944544)
                    .latitude(50.049683)
                    .city("Cracow")
                    .country("Poland")
                    .timezone(2)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Indira Gandhi International Airport")
                    .longitude(77.216721)
                    .latitude(28.644800)
                    .city("Delhi")
                    .country("India")
                    .timezone(5)
                    .build());

            airportRepository.save(Airport.builder()
                    .name("Boryspil International Airport")
                    .longitude(30.517023)
                    .latitude(50.431759)
                    .city("Kiev")
                    .country("Ukraine")
                    .timezone(3)
                    .build());
        }
    }
}
