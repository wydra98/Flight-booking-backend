package pl.edu.pk.siwz.backend.controllers.AirlineController;

import pl.edu.pk.siwz.backend.models.Airline.Airline;

public class AirlineMapper {

    public AirlineDto map(Airline airline) {
        return AirlineDto.builder()
                .id(airline.getId())
                .name(airline.getName())
                .build();
    }
}
