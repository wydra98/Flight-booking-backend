package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;
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

    public Airport addNewAirport(AirportDto airportDto, double longitude, double latitude) {

        Airport airport = Airport.builder()
                .name(airportDto.getName())
                .city(airportDto.getCity())
                .country(airportDto.getCountry())
                .longitude(longitude)
                .latitude(latitude)
                .timezone(airportDto.getTimezone())
                .code(airportDto.getCode())
                .build();

        repository.save(airport);
        return airport;
    }
}
