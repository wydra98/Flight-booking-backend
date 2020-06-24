package pl.edu.pk.siwz.backend.models.Airport;

import pl.edu.pk.siwz.backend.models.Airport.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportRepository {
    List<Airport> findAll();

    Airport save(Airport entity);

    int amountOfRows();

    Airport findAirportByCode(String code);

    boolean existsByCode(String code);

    void deleteByCode(String code);
}
