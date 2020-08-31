package flight_booking.backend.repository;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Connection;
import flight_booking.backend.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

    @Query(value = "SELECT COUNT (c.connection_id) FROM connections c", nativeQuery = true)
    int amountOfRows();

    @Query(value = "SELECT c FROM Connection c WHERE c.srcAirport=:airport OR c.dstAirport=:airport")
    List<Connection> findConnectionByAirport(@Param("airport") Airport airport);

//    @Override
//    @Query("SELECT t FROM Trip t WHERE t.passenger.id = :id")
//    List<Trip> findAllTripFromUserId(@Param("id") Long id);

//    @Override
//    @Modifying
//    @Transactional
//    @Query(value = "SELECT c FROM Connection c WHERE c.srcAirport =:srcAirport", nativeQuery = true)
//    List<Connection> findAllConnectionWithTheSameSrcAirport(@Param("srcAirport") Long srcAirport);

}
