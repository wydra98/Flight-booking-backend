package pl.edu.pk.siwz.backend.loaders;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;

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
                .city(arr[1])
                .country(arr[2])
                .longitude(Double.parseDouble(arr[3]))
                .latitude(Double.parseDouble(arr[4]))
                .timezone(Integer.parseInt(arr[5]))
                .code(arr[6])
                .build();

        return airport;
    }
}
