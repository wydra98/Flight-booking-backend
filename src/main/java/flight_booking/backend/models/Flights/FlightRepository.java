package flight_booking.backend.models.Flights;

import flight_booking.backend.models.Connections.Connection;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FlightRepository {

    List<Flight> findAll();

    Long findIdConnectionByFlight(@Param("id") Long id);

    int amountOfRows();

    Flight save(Flight entity);

    boolean existsById(Long id);

    void deleteById(Long id);

    Optional<Flight> findById(Long id);

    List<Flight> findFlightsByConnection(Connection connection);
}
