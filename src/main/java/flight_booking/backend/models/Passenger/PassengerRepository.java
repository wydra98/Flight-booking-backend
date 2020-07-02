package flight_booking.backend.models.Passenger;


import java.util.List;

public interface PassengerRepository {

    List<Passenger> findAll();

    Passenger save(Passenger entity);

    int amountOfRows();
}
