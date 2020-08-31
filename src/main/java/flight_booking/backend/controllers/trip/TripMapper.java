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
            ticketDtos.add(ticketMapper.map(ticket));
        }

        TripDto tripDto = null;

        if(trip.getPurchaseDate() == null || trip.getPurchaseTime() == null){
            tripDto = TripDto.builder()
                    .arraysTicket(ticketDtos)
                    .departureDate(trip.getDepartureDate().toString())
                    .departureTime(trip.getDepartureTime().toString())
                    .arrivalDate(trip.getArrivalDate().toString())
                    .arrivalTime(trip.getArrivalTime().toString())
                    .totalPrice(trip.getPrice())
                    .build();
        }
        else{
            tripDto = TripDto.builder()
                    .arraysTicket(ticketDtos)
                    .departureDate(trip.getDepartureDate().toString())
                    .departureTime(trip.getDepartureTime().toString())
                    .arrivalDate(trip.getArrivalDate().toString())
                    .arrivalTime(trip.getArrivalTime().toString())
                    .purchaseDate(trip.getPurchaseDate().toString())
                    .purchaseTime(trip.getPurchaseTime().toString())
                    .totalPrice(trip.getPrice())
                    .build();
        }

        return tripDto;
    }
}