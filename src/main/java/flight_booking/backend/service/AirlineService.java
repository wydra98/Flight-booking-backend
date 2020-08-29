package flight_booking.backend.service;

import flight_booking.backend.models.Airline;
import org.springframework.stereotype.Service;
import flight_booking.backend.controllers.AirlineController.AirlineDto;

import java.util.List;
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

    public boolean checkIfAirlineExists(AirlineDto airlineDto,String country) {
        if (repository.checkIfAirlineExists(airlineDto.getName(),country)>0) {
            return true;
        } else
            return false;
    }

    public void save(Airline airline) {
        repository.save(airline);
    }
}
