package flight_booking.backend.controllers.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class FlightRequest {
    private Long id;
    private Long airlineId;
    private int numberSeats;
    private double price;
    private Long srcAirportId;
    private Long dstAirportId;
    private String departureDate;
    private String departureTime;
    private String flightTime;
}
