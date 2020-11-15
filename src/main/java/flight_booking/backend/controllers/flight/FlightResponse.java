package flight_booking.backend.controllers.flight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class FlightResponse {
    private Long id;
    private String airlineName;
    private int numberSeats;
    private double price;
    private String srcAirportName;
    private String dstAirportName;
    private String departureDate;
    private String departureTime;
    private String flightTime;
}
