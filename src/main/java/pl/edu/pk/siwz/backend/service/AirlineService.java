package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.exception.AirlineAlreadyExistsException;
import pl.edu.pk.siwz.backend.exception.AirportAlreadyExistsException;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;
import pl.edu.pk.siwz.backend.models.Airport.Airport;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class AirlineService {

    private final AirlineRepository repository;

    public AirlineService(AirlineRepository repository) {
        this.repository = repository;
    }

    public List<Airline> findAll() {
        return repository.findAll();
    }

    public Airline addNewAirline(AirlineDto airlineDto, String country) {

        Airline airline = Airline.builder()
                .name(airlineDto.getName())
                .country(country)
                .build();

        repository.save(airline);
        return airline;
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public Optional<Airline> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteAirline(Long id) {
        repository.deleteById(id);
    }

    public void checkIfIdExists(Long id) {
        if (repository.findById(id).isPresent()) {
            throw new AirlineAlreadyExistsException("Airline already exists, can't create airline with the same code.");
        }
    }
}
