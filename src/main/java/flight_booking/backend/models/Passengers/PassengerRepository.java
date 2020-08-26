package flight_booking.backend.models.Passengers;


import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PassengerRepository {

    List<Passenger> findAll();

    Passenger save(Passenger entity);

    int amountOfRows();

    int checkIfPassengerExistsThroughPesel(String pesel);

    Passenger findByPesel(@Param("pesel") String pesel);

    boolean existsById(Long Id);

    void deleteById(Long Id);

    Optional<Passenger> findById(Long id);

}
