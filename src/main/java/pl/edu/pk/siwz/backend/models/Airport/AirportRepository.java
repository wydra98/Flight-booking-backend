package pl.edu.pk.siwz.backend.models.Airport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.pk.siwz.backend.models.Airport.Airport;

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
