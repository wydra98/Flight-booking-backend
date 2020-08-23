package flight_booking.backend.controllers.TicketController;

import flight_booking.backend.controllers.FlightController.FlightDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TicketDto {
   // private Long id;
    private FlightDto flightDto;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
   // private String purchaseDate;
   // private String purchaseTime;
    private double totalPrice;
}