package flight_booking.backend.controllers.AirlineController;

import flight_booking.backend.models.Airline;

public class AirlineMapper {

    public AirlineDto map(Airline airline) {
        return AirlineDto.builder()
                .id(airline.getId())
                .name(airline.getName())
                .build();
    }
}
