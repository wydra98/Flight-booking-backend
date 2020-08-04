package flight_booking.backend.adapter;

import flight_booking.backend.models.Trips.Trip;
import flight_booking.backend.models.Trips.TripRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlTripRepository extends TripRepository, JpaRepository<Trip, Long> {

    @Override
    @Query(value = "SELECT COUNT (t.trip_id) FROM trips t", nativeQuery = true)
    int amountOfRows();
}