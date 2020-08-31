package flight_booking.backend.repository;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import flight_booking.backend.models.Flight;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    @Query(value = "SELECT COUNT (f.flight_id) FROM flights f", nativeQuery = true)
    int amountOfRows();

    @Query("SELECT DISTINCT f FROM Flight f WHERE f.connection = :connection")
    Flight findFlightByConnection(@Param("connection") Connection connection);

    @Query(value = "SELECT f.id_connection FROM flights f where f.flight_id = :id", nativeQuery = true)
    Long findIdConnectionByFlight(@Param("id") Long id);

    @Query(value = "SELECT f FROM Flight f WHERE f.airline=:airline")
    List<Flight> findFlightsByAirline(@Param("airline") Airline airline);

}
