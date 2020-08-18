package flight_booking.backend.models.Passengers;


import java.util.List;
import java.util.Optional;

public interface PassengerRepository {

    List<Passenger> findAll();

    Passenger save(Passenger entity);

    int amountOfRows();

    int checkIfPassengerExistsThroughEmail(String email);

    int checkIfPassengerExistsThroughPhoneNumber(String phoneNumber);

    boolean existsById(Long Id);

    void deleteById(Long Id);

    Optional<Passenger> findById(Long id);

}
