package flight_booking.backend.controllers.ticket;

import flight_booking.backend.controllers.flight.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TicketDto {
    private FlightDto flightDto;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private String departureDateGMT;
    private String departureTimeGMT;
    private String arrivalDateGMT;
    private String arrivalTimeGMT;
    private Integer seatNumber;
    private double totalPrice;
}
