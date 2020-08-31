package flight_booking.backend.controllers.flight;

import flight_booking.backend.controllers.airline.AirlineDto;
import flight_booking.backend.controllers.airport.AirportDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private AirlineDto airline;
    private AirportDto srcAirport;
    private AirportDto dstAirport;
}
