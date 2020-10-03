package flight_booking.backend.service;

import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public Passenger addNewPassenger(PassengerDto passengerDto) {
        Passenger passenger = Passenger.builder()
                .firstName(passengerDto.getFirstName())
                .surname(passengerDto.getSurname())
                .dateOfBirth(LocalDate.parse(passengerDto.getDateOfBirth()))
                .phoneNumber(passengerDto.getPhoneNumber())
                .pesel(passengerDto.getPesel())
                .email(passengerDto.getEmail())
                .build();
        passengerRepository.save(passenger);

        return passenger;
    }

    public boolean checkIfPassengerExists(String pesel) {
        return passengerRepository.checkIfPassengerExistsThroughPesel(pesel) > 0;
    }

    public Passenger findPassenger(String pesel) {
        return passengerRepository.findByPesel(pesel);
    }

    public void validateIfExists(String PESEL) {
        if (checkIfPassengerExists(PESEL)) {
            throw new IllegalStateException("Passenger with these data already exist in datebase!");
        }
    }

    public void validateIfNonExists(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Passenger with that id not exist!");
        }
    }

    public boolean existsById(Long id) {
        return passengerRepository.existsById(id);
    }

    public void deletePassenger(Passenger passenger) {
        passengerRepository.deleteById(passenger.getId());
    }

    public Optional<Passenger> findById(Long id) {
        return passengerRepository.findById(id);
    }
}
