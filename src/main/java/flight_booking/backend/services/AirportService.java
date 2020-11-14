package flight_booking.backend.services;

import flight_booking.backend.repository.AirportRepository;
import org.springframework.stereotype.Service;
import flight_booking.backend.controllers.airport.AirportDto;
import flight_booking.backend.models.Airport;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AirportService {

    private final AirportRepository repository;

    public AirportService(AirportRepository repository) {
        this.repository = repository;
    }

    public List<Airport> findAll() {
        return repository.findAll();
    }

    public Airport save(Airport airport) {
        return repository.save(airport);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Optional<Airport> findById(Long id) {
        return repository.findById(id);
    }

    public void validateNewAirport(AirportDto airportDto) {
        if (checkIfAirportExists(airportDto)) {
            throw new IllegalStateException("Takie lotnisko istnieje już w bazie!");
        }
    }

    public void validateId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Takie lotnisko nie istnieje w bazie!");
        }
    }

    public boolean checkIfAirportExists(AirportDto airportDto) {
        return repository.checkIfAirportExistsThroughName(airportDto.getName().toUpperCase(), airportDto.getCity().toUpperCase()) > 0 ||
                repository.checkIfAirportExistsThroughCoordinates(airportDto.getLongitude(), airportDto.getLatitude()) > 0;
    }

    public Airport addNewAirport(AirportDto airportDto) {

        Airport airport = Airport.builder()
                .name(airportDto.getName())
                .city(airportDto.getCity())
                .country(airportDto.getCountry())
                .longitude(airportDto.getLongitude())
                .latitude(airportDto.getLatitude())
                .timezone(airportDto.getTimezone())
                .build();

        repository.save(airport);
        return airport;
    }

    public void deleteAirport(Airport airport) {
        repository.deleteById(airport.getId());
    }
}
