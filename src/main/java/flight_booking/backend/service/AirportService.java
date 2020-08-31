package flight_booking.backend.service;

import org.springframework.stereotype.Service;
import flight_booking.backend.controllers.airport.AirportDto;
import flight_booking.backend.models.Airport;

import java.util.List;
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

    public void save(Airport airport) {
        repository.save(airport);
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

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Optional<Airport> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteAirport(Long id) {
        repository.deleteById(id);
    }

    public boolean checkIfAirportExists(AirportDto airportDto, double longitude, double latitude) {
        if (repository.checkIfAirportExistsThroughName(airportDto.getName().toUpperCase(), airportDto.getCity().toUpperCase()) > 0 ||
                repository.checkIfAirportExistsThroughCoordinates(longitude, latitude) > 0) {
            return true;
        } else
            return false;
    }



}
