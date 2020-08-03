package flight_booking.backend.service;

import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;

    }

    public List<Ticket> findAllTicketFromUserId(Long id){
        List<Ticket> tickets = ticketRepository.findAllTicketFromUserId(id);

        return tickets;
    }


}
