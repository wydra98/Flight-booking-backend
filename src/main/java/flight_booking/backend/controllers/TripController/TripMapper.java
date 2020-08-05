package flight_booking.backend.controllers.TripController;

import flight_booking.backend.controllers.FlightController.FlightMapper;
import flight_booking.backend.controllers.PassengerController.PassengerMapper;
import flight_booking.backend.controllers.TicketController.TicketDto;
import flight_booking.backend.controllers.TicketController.TicketMapper;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Trips.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripMapper {

    public TripDto map(Trip trip) {



        TicketMapper ticketMapper = new TicketMapper();
        PassengerMapper passengerMapper = new PassengerMapper();

        ArrayList<TicketDto> ticketDtos = new ArrayList<>();
        for(Ticket ticket: trip.getTickets()){
            ticketDtos.add(ticketMapper.map(ticket));
        }

        return TripDto.builder()
                .id(trip.getId())
                .arraysTicket(ticketDtos)
                .passengerDto(passengerMapper.map(trip.getPassenger()))
                .departureDate(trip.getDepartureDate().toString())
                .departureTime(trip.getDepartureTime().toString())
                .purchaseDate(trip.getPurchaseDate().toString())
                .purchaseTime(trip.getPurchaseTime().toString())
                .totalPrice(trip.getPrice())
                .build();
    }
}
