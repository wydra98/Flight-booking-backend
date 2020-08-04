package flight_booking.backend.models.Trips;

import flight_booking.backend.models.Ticket.Ticket;

import java.util.Optional;

public interface TripRepository {

    int amountOfRows();

    Trip save(Trip entity);

    Optional<Trip> findById(Long id);
}
