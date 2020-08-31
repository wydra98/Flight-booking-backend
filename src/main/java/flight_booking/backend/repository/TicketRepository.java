package flight_booking.backend.repository;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT DISTINCT t FROM Ticket t WHERE t.id = :id")
    List<Ticket> findAllTicketFromUserId(@Param("id") Long id);

    @Query(value = "SELECT COUNT (a.ticket_id) FROM tickets a", nativeQuery = true)
    int amountOfRows();

    @Query(value = "SELECT t FROM Ticket t WHERE t.flight=:flight")
    List<Ticket> findTicketsByFlights(@Param("flight") Flight flight);
}
