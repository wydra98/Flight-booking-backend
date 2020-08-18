package flight_booking.backend.models.Trips;

import java.util.Optional;

public interface TripRepository {

 //   List<Trip> findAllTripFromUserId(Long id);

    int amountOfRows();

    Trip save(Trip entity);

    Optional<Trip> findById(Long id);
}
