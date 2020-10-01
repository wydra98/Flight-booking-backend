package flight_booking.backend.service;

import flight_booking.backend.models.Airline;
import flight_booking.backend.repository.AirlineRepository;
import org.springframework.stereotype.Service;
import flight_booking.backend.controllers.airline.AirlineDto;

import java.util.List;
import java.util.NoSuchElementException;
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

    public Optional<Airline> findById(Long id) {
        return repository.findById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean checkIfAirlineExists(AirlineDto airlineDto, String country) {
        return repository.checkIfAirlineExists(airlineDto.getName(), country) > 0;
    }

    public void validateNewAirline(AirlineDto airlineDto, String country) {
        if (checkIfAirlineExists(airlineDto, country)) {
            throw new IllegalStateException("Airline with these data already exist ins datebase!");
        }
    }

    public void validateId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Airline with that id not exist!");
        }
    }

    public Airline addNewAirline(AirlineDto airlineDto, String country) {
        Airline airline = Airline.builder()
                .name(airlineDto.getName())
                .country(country)
                .build();

        repository.save(airline);
        return airline;
    }

    public void save(Airline airline) {
        repository.save(airline);
    }

    public void deleteAirline(Airline airline) {
        repository.deleteById(airline.getId());
    }
}
