package flight_booking.backend.controllers.FlightController;

import flight_booking.backend.controllers.AirlineController.AirlineDto;
import flight_booking.backend.controllers.AirportController.AirportDto;
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
