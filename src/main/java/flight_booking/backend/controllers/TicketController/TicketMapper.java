package flight_booking.backend.controllers.TicketController;

import flight_booking.backend.models.Ticket.Ticket;

public class TicketMapper {

    public TicketDto map(Ticket ticket) {
        return TicketDto.builder()
                .id(ticket.getId())
                //@TODO check if work correct
                .flightDto(ticket.convertListOfFlightsToDto())
                .purchaseDate(ticket.getPurchaseDate().toString())
                .purchaseTime(ticket.getPurchaseTime().toString())
                .totalPrice(ticket.getPrice())
                .build();
    }
}
