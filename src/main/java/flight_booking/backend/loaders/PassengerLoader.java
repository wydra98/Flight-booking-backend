package flight_booking.backend.loaders;

import flight_booking.backend.repository.PassengerRepository;
import flight_booking.backend.models.Passenger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class PassengerLoader implements CommandLineRunner {

    PassengerRepository passengerRepository;

    PassengerLoader(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (passengerRepository.amountOfRows() == 0) {

            Passenger passenger1 = Passenger.builder()
                    .firstName("Kacper")
                    .surname("Kuczyński")
                    .pesel("02220766333")
                    .dateOfBirth(LocalDate.parse("1992-08-27"))
                    .phoneNumber("512461514")
                    .email("kuczyński.kacper92@gmail.com")
                    .build();
            passengerRepository.save(passenger1);

            Passenger passenger2 = Passenger.builder()
                    .firstName("Jan")
                    .surname("Kowalski")
                    .pesel("75112655569")
                    .dateOfBirth(LocalDate.parse("1956-02-27"))
                    .phoneNumber("482471045")
                    .email("kowalski.jan56@gmail.com")
                    .build();
            passengerRepository.save(passenger2);

            Passenger passenger3 = Passenger.builder()
                    .firstName("Zofia")
                    .surname("Janicka")
                    .pesel("78112332469")
                    .dateOfBirth(LocalDate.parse("1983-12-07"))
                    .phoneNumber("787400178")
                    .email("zofia.janicka78@gmail.com")
                    .build();
            passengerRepository.save(passenger3);
        }
    }
}
