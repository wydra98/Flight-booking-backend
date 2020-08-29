package flight_booking.backend.adapter;

import flight_booking.backend.models.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
interface SqlConnectionRepository extends ConnectionRepository, JpaRepository<Connection, Long> {

    @Override
    @Query(value = "SELECT COUNT (c.connection_id) FROM connections c", nativeQuery = true)
    int amountOfRows();

    @Override
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM connections c WHERE c.connection_id=:id", nativeQuery = true)
    void deleteAllConnectionWithAirlineId(@Param("id") Long id);

    @Override
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM connections c WHERE c.airport_src_id =:id OR airport_dst_id=:id", nativeQuery = true)
    void deleteAllConnectionWithAirportId(@Param("id") Long id);

//    @Override
//    @Query("SELECT t FROM Trip t WHERE t.passenger.id = :id")
//    List<Trip> findAllTripFromUserId(@Param("id") Long id);

//    @Override
//    @Modifying
//    @Transactional
//    @Query(value = "SELECT c FROM Connection c WHERE c.srcAirport =:srcAirport", nativeQuery = true)
//    List<Connection> findAllConnectionWithTheSameSrcAirport(@Param("srcAirport") Long srcAirport);

}
