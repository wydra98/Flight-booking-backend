package pl.edu.pk.siwz.backend.models.Airport;

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
}
