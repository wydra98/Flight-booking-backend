package pl.edu.pk.siwz.backend.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;

@Repository
interface SqlAirlinerepository extends AirlineRepository, JpaRepository<Airline, Long> {

    @Override
    @Query(value = "SELECT COUNT (a.airline_id) FROM airlines a", nativeQuery = true)
    int amountOfRows();

    @Override
    @Query(value = "SELECT COUNT (a.airport_id) FROM airports a WHERE a.name=:name AND a.country=:country",
            nativeQuery = true)
    int checkIfAirlineExists(@Param("name") String name, @Param("country") String country);

}
