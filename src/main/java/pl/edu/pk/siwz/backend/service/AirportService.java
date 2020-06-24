package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
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

    public List<Airport> findAll() { return repository.findAll(); }

    public Airline addNewAirline(AirlineDto airlineDto) {
        String country = repository.findCountryByCode(airlineDto.getCode());

        Airline airline = Airline.builder()
                .name(airlineDto.getName())
                .code(airlineDto.getCode())
                .country(country)
                .build();

        repository.save(airline);
        return airline;
    }
}
