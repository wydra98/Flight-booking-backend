package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;
import pl.edu.pk.siwz.backend.exception.AirlineAlreadyExistsException;
import pl.edu.pk.siwz.backend.exception.AirportAlreadyExistsException;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;

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
