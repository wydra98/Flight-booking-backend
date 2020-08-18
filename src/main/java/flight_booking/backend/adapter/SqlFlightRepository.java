package flight_booking.backend.adapter;

import flight_booking.backend.models.Connections.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Flights.FlightRepository;

import java.util.List;

@Repository
interface SqlFlightRepository extends FlightRepository, JpaRepository<Flight, Long> {

    @Override
    @Query(value = "SELECT f.id_connection FROM flights f where f.flight_id = :id", nativeQuery = true)
    Long findIdConnectionByFlight(@Param("id") Long id);

    @Override
    @Query(value = "SELECT COUNT (f.flight_id) FROM flights f", nativeQuery = true)
    int amountOfRows();


    @Override
    @Query("SELECT DISTINCT f FROM Flight f WHERE f.connection = :connection")
    List<Flight> findFlightsByConnection(@Param("connection") Connection connection);

}
