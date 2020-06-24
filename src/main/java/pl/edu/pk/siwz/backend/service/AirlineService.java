package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;

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
                .code(airlineDto.getCode())
                .country(country)
                .build();

        repository.save(airline);
        return airline;
    }

}
