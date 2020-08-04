package flight_booking.backend.service;

import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Ticket.TicketRepository;
import flight_booking.backend.models.Trips.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripService {
    private final TripRepository tripRepository;

    TripService(TripRepository tripRepository){
        this.tripRepository = tripRepository;

    }
}
