package flight_booking.backend.repository;

import flight_booking.backend.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends PassengerRepository, JpaRepository<Passenger,Long> {

    @Override
    @Query(value = "SELECT COUNT (p.passenger_id) FROM passengers p", nativeQuery = true)
    int amountOfRows();

    @Override
    @Query(value = "SELECT DISTINCT p FROM Passenger p WHERE p.pesel=:pesel")
    Passenger findByPesel(@Param("pesel") String pesel);


    @Override
    @Query(value = "SELECT COUNT (p.passenger_id) FROM passengers p WHERE p.phone_number=:pesel",
            nativeQuery = true)
    int checkIfPassengerExistsThroughPesel(@Param("pesel") String pesel);


}
