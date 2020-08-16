package flight_booking.backend.loaders;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Airport.AirportRepository;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Component
public class AirportLoader implements CommandLineRunner {

    AirportRepository airportRepository;

    AirportLoader(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (airportRepository.amountOfRows() == 0) {
            String next;
            File file = new File("airports.dat.txt");
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {

                while (((next = br.readLine()) != null)) {
                    Airport airport = createAirportFromString(next);
                    if (airport != null) {
                        airportRepository.save(airport);
                    }
                }
            }
        }
    }

    @Transactional
    Airport createAirportFromString(String str) {
        String[] arr = str.split(";");

        Airport airport = Airport.builder()
                .name(arr[0])
                .longitude(Double.parseDouble(arr[1]))
                .latitude(Double.parseDouble(arr[2]))
                .city(arr[3])
                .country(arr[4])
                .timezone(Integer.parseInt(arr[5]))
                .build();

        return airport;
    }
}
