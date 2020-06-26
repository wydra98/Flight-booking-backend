package pl.edu.pk.siwz.backend.models.Airline;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.pk.siwz.backend.models.Airline.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineRepository {
    List<Airline> findAll();

    Airline save(Airline entity);

    int amountOfRows();

    Optional<Airline> findById(Long id);

    boolean existsById(Long id);

    void deleteById(Long id);

    int checkIfAirlineExists(@Param("name") String name, @Param("country") String country);
}

