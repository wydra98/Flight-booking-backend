package flight_booking.backend.repository;

import flight_booking.backend.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

//    @Override
//    @Query("SELECT t FROM Trip t WHERE t.passenger.id = :id")
//    List<Trip> findAllTripFromUserId(@Param("id") Long id);

    @Override
    @Query(value = "SELECT COUNT (t.trip_id) FROM trips t", nativeQuery = true)
    int amountOfRows();

    @Override
    @Query(value = "SELECT DISTINCT t FROM Trip t WHERE t.code=:code")
    Trip findTripByCode(@Param("code") String code);


}