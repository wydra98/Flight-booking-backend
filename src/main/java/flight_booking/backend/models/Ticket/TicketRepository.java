package flight_booking.backend.models.Ticket;

import flight_booking.backend.models.Flight.Flight;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    List<Ticket> findAllTicketFromUserId(Long id);

    Optional<Ticket> findById(Long id);

    int amountOfRows();

    Ticket save(Ticket entity);
}
