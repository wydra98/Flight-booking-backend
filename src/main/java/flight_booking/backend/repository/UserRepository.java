package flight_booking.backend.repository;

import flight_booking.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT COUNT (u.user_id) FROM users u WHERE u.email=:email",
            nativeQuery = true)
    int checkIfMailExists(@Param("email") String email);

    @Query(value = "SELECT DISTINCT u FROM User u WHERE u.email=:email")
    User getUserByEmail(@Param("email") String email);

    @Query(value = "SELECT COUNT (u.user_id) FROM users u", nativeQuery = true)
    int amountOfRows();
}
