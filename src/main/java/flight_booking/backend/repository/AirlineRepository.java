package flight_booking.backend.repository;

import flight_booking.backend.models.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    @Query(value = "SELECT COUNT (a.airline_id) FROM airlines a", nativeQuery = true)
    int amountOfRows();

    @Query(value = "SELECT COUNT (a.airline_id) FROM airlines a WHERE a.name=:name AND a.country=:country",
            nativeQuery = true)
    int checkIfAirlineExists(@Param("name") String name, @Param("country") String country);
}
