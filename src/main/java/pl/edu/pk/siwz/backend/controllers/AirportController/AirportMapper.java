package pl.edu.pk.siwz.backend.controllers.AirportController;

import pl.edu.pk.siwz.backend.models.Airport.Airport;

public class AirportMapper {

    public AirportDto map(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .city(airport.getCity())
                .country(airport.getCountry())
                .timezone(airport.getTimezone())
                .build();
    }
}
