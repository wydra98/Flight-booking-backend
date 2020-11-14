package flight_booking.backend.repository;

import flight_booking.backend.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT COUNT (f.flight_id) FROM flights f", nativeQuery = true)
    int amountOfRows();

    @Query(value = "SELECT f.id_connection FROM flights f where f.flight_id = :id", nativeQuery = true)
    Long findIdConnectionByFlight(@Param("id") Long id);

    @Query(value = "SELECT f FROM Flight f WHERE f.airline=:airline")
    List<Flight> findFlightsByAirline(@Param("airline") Airline airline);

    @Query("SELECT DISTINCT f FROM Flight f WHERE f.connection = :connection")
    List<Flight> findFlightsByConnection(@Param("connection") Connection connection);
}
