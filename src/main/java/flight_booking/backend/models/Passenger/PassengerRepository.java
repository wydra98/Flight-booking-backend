package flight_booking.backend.models.Passenger;


import java.util.List;

public interface PassengerRepository {

    List<Passenger> findAll();
}
