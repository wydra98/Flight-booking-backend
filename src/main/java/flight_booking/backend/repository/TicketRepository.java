package flight_booking.backend.repository;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Ticket;
import flight_booking.backend.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query(value = "SELECT COUNT (a.ticket_id) FROM tickets a", nativeQuery = true)
    int amountOfRows();

    @Query(value = "SELECT t FROM Ticket t WHERE t.flight.id=:id")
    Ticket findTicketsByFlightsId(@Param("id") Long id);
}
