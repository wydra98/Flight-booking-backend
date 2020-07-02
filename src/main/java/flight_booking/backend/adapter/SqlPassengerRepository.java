package flight_booking.backend.adapter;

import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Passenger.PassengerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlPassengerRepository extends PassengerRepository, JpaRepository<Passenger,Long> {

    @Override
    @Query(value = "SELECT COUNT (p.passenger_id) FROM passengers p", nativeQuery = true)
    int amountOfRows();
}
