package flight_booking.backend.controllers.TripController;

import flight_booking.backend.controllers.FlightController.FlightDto;
import flight_booking.backend.controllers.TicketController.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TripDto {
    private Long id;
    private Array<TicketDto> arraysTicket;
    private String departureDate;
    private String departureTime;
    private String purchaseDate;
    private String purchaseTime;
    private double totalPrice;
}