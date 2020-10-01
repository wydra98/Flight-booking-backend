package flight_booking.backend.service;

import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Seat;
import flight_booking.backend.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Integer> findAllBusySeat(Flight flight){
        List<Seat> seats = seatRepository.findAllBusySeat(flight);
        List<Integer> seatsNumber = new ArrayList<>();

        for (Seat seat: seats) {
            seatsNumber.add(seat.getSeatNumber());
        }

        return seatsNumber;
    }
}
