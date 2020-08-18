package flight_booking.backend.loaders;

import flight_booking.backend.models.Airlines.Airline;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import flight_booking.backend.models.Airlines.AirlineRepository;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Component
public class AirlineLoader implements CommandLineRunner {

    AirlineRepository airlineRepository;

    AirlineLoader(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (airlineRepository.amountOfRows() == 0) {
            String next;
            File file = new File("airlines.dat.txt");
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {

                while (((next = br.readLine()) != null)) {
                    Airline airline = createAirlineFromString(next);
                    if (airline != null) {
                        airlineRepository.save(airline);
                    }
                }
            }
        }
    }

    @Transactional
    Airline createAirlineFromString(String str) {
        String[] arr = str.split(";");

        Airline airline = Airline.builder()
                .name(arr[0])
                .country(arr[1])
                .build();

        return airline;
    }
}
