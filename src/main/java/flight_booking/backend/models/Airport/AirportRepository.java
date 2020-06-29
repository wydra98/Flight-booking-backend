package flight_booking.backend.models.Airport;

import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AirportRepository {
    List<Airport> findAll();

    Airport save(Airport entity);

    int amountOfRows();

    Optional<Airport> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

    int checkIfAirportExistsThroughName(@Param("name") String name, @Param("city") String city);

    int checkIfAirportExistsThroughCoordinates(@Param("longitude") double longitude, @Param("latitude") double latitude);
}
