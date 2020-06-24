package pl.edu.pk.siwz.backend.models.Airline;

import pl.edu.pk.siwz.backend.models.Airline.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository {
    List<Airline> findAll();

    Optional<Airline> findById(Long id);

    Airline save(Airline entity);

    int amountOfRows();

    Airline findAirlineByCode(String code);

    boolean existsByCode(String code);

    void deleteByCode(String code);

}
