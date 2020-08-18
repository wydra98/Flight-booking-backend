package flight_booking.backend.loaders;

import flight_booking.backend.models.Passengers.Passenger;
import flight_booking.backend.models.Passengers.PassengerRepository;
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
    public void run(String... args) throws Exception {
        if (passengerRepository.amountOfRows() == 0) {

            Passenger passenger1 = Passenger.builder()
                    .firstName("Adrian")
                    .surname("Wydra")
                    .dateOfBirth(LocalDate.parse("1998-02-27"))
                    .phoneNumber("513071016")
                    .email("wydra.adrian98@gmail.com")
                    .build();
            passengerRepository.save(passenger1);

            Passenger passenger2 = Passenger.builder()
                    .firstName("Henio")
                    .surname("Stolarz")
                    .dateOfBirth(LocalDate.parse("1956-02-27"))
                    .phoneNumber("482471045")
                    .email("henio.stolarz56@gmail.com")
                    .build();
            passengerRepository.save(passenger2);

            Passenger passenger3 = Passenger.builder()
                    .firstName("Justyna")
                    .surname("Kowalczyk")
                    .dateOfBirth(LocalDate.parse("1983-12-07"))
                    .phoneNumber("123456789")
                    .email("justyna.kowalczyk98@gmail.com")
                    .build();
            passengerRepository.save(passenger3);


        }
    }

}
