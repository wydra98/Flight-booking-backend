package flight_booking.backend.controllers.ticket;

import flight_booking.backend.controllers.flight.FlightMapper;
import flight_booking.backend.models.Ticket;

import java.time.LocalDateTime;

public class TicketMapper {

    FlightMapper flightMapper = new FlightMapper();

    public TicketDto map(Ticket ticket) {

        LocalDateTime arrival = LocalDateTime.of(ticket.getFlight().getTimes().getDepartureDate(), ticket.getFlight().getTimes().getDepartureTime())
                .plusHours(ticket.getFlight().getTimes().getFlightTime().getHour())
                .plusMinutes(ticket.getFlight().getTimes().getFlightTime().getMinute())
                .plusSeconds(ticket.getFlight().getTimes().getFlightTime().getSecond());

        LocalDateTime timeDepartureGmt = LocalDateTime.of(ticket.getFlight().getTimes().getDepartureDate(), ticket.getFlight().getTimes().getDepartureTime());

        LocalDateTime timeArrivalGmt = LocalDateTime.of(ticket.getFlight().getTimes().getDepartureDate(),
                ticket.getFlight().getTimes().getDepartureTime())
                .plusHours(ticket.getFlight().getTimes().getFlightTime().getHour())
                .plusMinutes(ticket.getFlight().getTimes().getFlightTime().getMinute())
                .plusSeconds(ticket.getFlight().getTimes().getFlightTime().getSecond());

        timeDepartureGmt = timeDepartureGmt.plusHours(ticket.getFlight().getConnection().getSrcAirport().getTimezone());
        timeArrivalGmt = timeArrivalGmt.plusHours(ticket.getFlight().getConnection().getDstAirport().getTimezone());


        return TicketDto.builder()
                .flightDto(flightMapper.map(ticket.getFlight(), ticket.getFlight().getConnection()))
                .departureDate(ticket.getFlight().getTimes().getDepartureDate().toString())
                .departureTime(ticket.getFlight().getTimes().getDepartureTime().toString())
                .arrivalDate(arrival.toLocalDate().toString())
                .arrivalTime(arrival.toLocalTime().toString())
                .departureDateGMT(timeDepartureGmt.toLocalDate().toString())
                .departureTimeGMT(timeDepartureGmt.toLocalTime().toString())
                .arrivalDateGMT(timeArrivalGmt.toLocalDate().toString())
                .arrivalTimeGMT(timeArrivalGmt.toLocalTime().toString())
                .totalPrice(ticket.getPrice())
                .seatNumber(ticket.getSeatNumber())
                .build();
    }
}
