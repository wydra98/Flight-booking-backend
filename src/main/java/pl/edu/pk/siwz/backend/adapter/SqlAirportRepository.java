package pl.edu.pk.siwz.backend.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;

import java.util.Optional;

@Repository
public interface SqlAirportRepository extends AirportRepository, JpaRepository<Airport, Long> {

    @Override
    @Query(value = "SELECT COUNT (a.airport_id) FROM airports a", nativeQuery = true)
    int amountOfRows();

    @Override
    @Query(value = "SELECT COUNT (a.airport_id) FROM airports a WHERE a.name=:name AND a.city=:city",
            nativeQuery = true)
    int checkIfAirportExistsThroughName(@Param("name") String name, @Param("city") String city);

    @Override
    @Query(value = "SELECT COUNT (a.airport_id) FROM airports a WHERE a.longitude=:longitude AND a.latitude=:latitude",
            nativeQuery = true)
    int checkIfAirportExistsThroughCoordinates(@Param("longitude") double longitude, @Param("latitude") double latitude);
}
