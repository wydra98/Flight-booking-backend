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
   // private Long id;
    private ArrayList<TicketDto> arraysTicket;
    //private PassengerDto passengerDto;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private String purchaseDate;
    private String purchaseTime;
    private double totalPrice;
}