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

    public void validateNewAirport(AirportDto airportDto, double longitude, double latitude) {
        if (checkIfAirportExists(airportDto, longitude, latitude)) {
            throw new IllegalStateException("Takie lotnisko istnieje już w bazie!");
        }
    }

    public void validateId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Takie lotnisko nie istnieje w bazie!");
        }
    }

    public boolean checkIfAirportExists(AirportDto airportDto, double longitude, double latitude) {
        return repository.checkIfAirportExistsThroughName(airportDto.getName().toUpperCase(), airportDto.getCity().toUpperCase()) > 0 ||
                repository.checkIfAirportExistsThroughCoordinates(longitude, latitude) > 0;
    }

    public Airport addNewAirport(AirportDto airportDto, double longitude, double latitude) {

        Airport airport = Airport.builder()
                .name(airportDto.getName())
                .city(airportDto.getCity())
                .country(airportDto.getCountry())
                .longitude(longitude)
                .latitude(latitude)
                .timezone(airportDto.getTimezone())
                .build();

        repository.save(airport);
        return airport;
    }

    public void deleteAirport(Airport airport) {
        repository.deleteById(airport.getId());
    }
}
