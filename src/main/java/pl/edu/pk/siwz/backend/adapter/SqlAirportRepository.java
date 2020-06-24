package pl.edu.pk.siwz.backend.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;

import java.util.Optional;

@Repository
public interface SqlAirportRepository extends AirportRepository, JpaRepository<Airport, Long> {

    @Query(value = "SELECT COUNT (a.airport_id) FROM airports a", nativeQuery = true)
    int amountOfRows();

    Airport findAirportByCode(String code);

    boolean existsByCode(String code);

    void deleteByCode(String code);
}
