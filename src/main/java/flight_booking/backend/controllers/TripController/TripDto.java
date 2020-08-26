package flight_booking.backend.controllers.TripController;

import flight_booking.backend.controllers.PassengerController.PassengerDto;
import flight_booking.backend.controllers.TicketController.TicketDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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