package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.ticket.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TripDto {
    private ArrayList<TicketDto> arraysTicket;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private String purchaseDate;
    private String purchaseTime;
    private double totalPrice;
}