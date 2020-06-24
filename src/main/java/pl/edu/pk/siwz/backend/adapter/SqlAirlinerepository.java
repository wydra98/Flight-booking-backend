package pl.edu.pk.siwz.backend.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;

@Repository
interface SqlAirlinerepository extends AirlineRepository, JpaRepository<Airline, Long> {

    @Query(value = "SELECT COUNT (a.airline_id) FROM airlines a", nativeQuery = true)
    int amountOfRows();

    Airline findAirlineByCode(String code);

    boolean existsByCode(String code);

    void deleteByCode(String code);
}
