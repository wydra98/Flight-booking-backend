package flight_booking.backend.repository;

import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Seat;
import flight_booking.backend.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    @Query(value = "SELECT DISTINCT s FROM Seat s WHERE s.flight=:flight")
    List<Seat> findAllBusySeat(@Param("flight") Flight flight);
}
