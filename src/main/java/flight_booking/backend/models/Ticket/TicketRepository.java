package flight_booking.backend.models.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    List<Ticket> findAllTicketFromUserId(Long id);

    Optional<Ticket> findById(Long id);

    int amountOfRows();

    Ticket save(Ticket entity);
}
