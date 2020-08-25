package flight_booking.backend.controllers.TicketController;

import flight_booking.backend.controllers.FlightController.FlightMapper;
import flight_booking.backend.models.Tickets.Ticket;

import java.time.LocalDateTime;

public class TicketMapper {

    FlightMapper flightMapper = new FlightMapper();

    public TicketDto map(Ticket ticket) {

        LocalDateTime arrival = LocalDateTime.of(ticket.getFlight().getTimes().getDepartureDate(), ticket.getFlight().getTimes().getDepartureTime())
                .plusHours(ticket.getFlight().getTimes().getFlightTime().getHour())
                .plusMinutes(ticket.getFlight().getTimes().getFlightTime().getMinute())
                .plusSeconds(ticket.getFlight().getTimes().getFlightTime().getSecond());


        return TicketDto.builder()
                //.id(ticket.getId())
                .flightDto(flightMapper.map(ticket.getFlight(), ticket.getFlight().getConnection()))
                .departureDate(ticket.getFlight().getTimes().getDepartureDate().toString())
                .departureTime(ticket.getFlight().getTimes().getDepartureTime().toString())
                .arrivalDate(arrival.toLocalDate().toString())
                .arrivalTime(arrival.toLocalTime().toString())
                //.purchaseDate(ticket.getPurchaseDate().toString())
                //.purchaseTime(ticket.getPurchaseTime().toString())
                .totalPrice(ticket.getPrice())
                .build();
    }
}
