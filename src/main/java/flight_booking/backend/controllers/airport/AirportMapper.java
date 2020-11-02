package flight_booking.backend.controllers.airport;

import flight_booking.backend.models.Airport;

public class AirportMapper {

    public static int DEFAULT_TIMEZONE = 2;

    public AirportDto map(Airport airport) {
        return AirportDto.builder()
                .id(airport.getId())
                .name(airport.getName())
                .city(airport.getCity())
                .country(airport.getCountry())
                .timezone(airport.getTimezone() + DEFAULT_TIMEZONE)
                .latitude(airport.getLatitude())
                .longitude(airport.getLongitude())
                .build();
    }
}
