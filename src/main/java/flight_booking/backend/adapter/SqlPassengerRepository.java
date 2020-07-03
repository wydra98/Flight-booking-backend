package flight_booking.backend.adapter;

import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Passenger.PassengerRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlPassengerRepository extends PassengerRepository, JpaRepository<Passenger,Long> {

    @Override
    @Query(value = "SELECT COUNT (p.passenger_id) FROM passengers p", nativeQuery = true)
    int amountOfRows();

    @Override
    @Query(value = "SELECT COUNT (p.passenger_id) FROM passengers p WHERE p.email=:email",
            nativeQuery = true)
    int checkIfPassengerExistsThroughEmail(@Param("email") String email);


    @Override
    @Query(value = "SELECT COUNT (p.passenger_id) FROM passengers p WHERE p.phone_number=:phoneNumber",
            nativeQuery = true)
    int checkIfPassengerExistsThroughPhoneNumber(@Param("phoneNumber") String phoneNumber);


}
