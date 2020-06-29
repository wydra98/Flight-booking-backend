package flight_booking.backend.models.Flight;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository {

    List<Flight> findAll();

    Long findIdConnectionByFlight(@Param("id") Long id);

    int amountOfRows();

    Flight save(Flight entity);

}
