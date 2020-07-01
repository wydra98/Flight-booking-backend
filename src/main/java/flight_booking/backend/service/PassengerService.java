package flight_booking.backend.service;


import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Passenger.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }
}
