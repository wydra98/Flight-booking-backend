package flight_booking.backend.service;

import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Flight.FlightRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    FlightRepository flightRepository;
    ConnectionService connectionService;

    FlightService(FlightRepository flightRepository, ConnectionService connectionService) {
        this.flightRepository = flightRepository;
        this.connectionService = connectionService;
    }

    public Connection findConnection(Long flightId) {

        Long id_connection = flightRepository.findIdConnectionByFlight(flightId);
        return connectionService.findById(id_connection).get();
    }

    public List<Flight> findAll() {
        return flightRepository.findAll();
    }

    public void save(Flight flight) {
        flightRepository.save(flight);
    }

    public int amount() {
        return flightRepository.amountOfRows();
    }

}
