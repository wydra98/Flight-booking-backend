package flight_booking.backend.models.Connection;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConnectionRepository {
    List<Connection> findAll();

    Connection save(Connection entity);

    int amountOfRows();

    void deleteAllConnectionWithAirlineId(@Param("id") Long id);

    void deleteAllConnectionWithAirportId(@Param("id") Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

    Optional<Connection> findById(Long id);

    List<Connection> findAllConnectionWithTheSameSrcAirport(@Param("srcAirportId") Long srcAirport);
}
