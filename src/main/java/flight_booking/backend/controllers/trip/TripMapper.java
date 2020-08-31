package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.ticket.TicketDto;
import flight_booking.backend.controllers.ticket.TicketMapper;
import flight_booking.backend.models.Ticket;
import flight_booking.backend.models.Trip;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TripMapper {

    public TripDto map(Trip trip) {

        TicketMapper ticketMapper = new TicketMapper();

        ArrayList<TicketDto> ticketDtos = new ArrayList<>();
        for(Ticket ticket: trip.getTickets()){
           // System.out.println("ticket");
            ticketDtos.add(ticketMapper.map(ticket));
        }

        return TripDto.builder()
                //.id(trip.getId())
                .arraysTicket(ticketDtos)
               // .passengerDto(passengerMapper.map(trip.getPassenger()))
                .departureDate(trip.getDepartureDate().toString())
                .departureTime(trip.getDepartureTime().toString())
                .arrivalDate(trip.getArrivalDate().toString())
                .arrivalTime(trip.getArrivalTime().toString())
                .purchaseDate(LocalDate.now().toString())
                .purchaseTime(LocalTime.now().toString())
                .totalPrice(trip.getPrice())
                .build();
    }
}
