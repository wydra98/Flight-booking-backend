package flight_booking.backend.adapter;

import flight_booking.backend.models.Tickets.Ticket;
import flight_booking.backend.models.Tickets.TicketRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlTicketRepository extends TicketRepository, JpaRepository<Ticket, Long> {

    @Override
    @Query("SELECT DISTINCT t FROM Ticket t WHERE t.id = :id")
    List<Ticket> findAllTicketFromUserId(@Param("id") Long id);

    @Override
    @Query(value = "SELECT COUNT (a.ticket_id) FROM tickets a", nativeQuery = true)
    int amountOfRows();

}
