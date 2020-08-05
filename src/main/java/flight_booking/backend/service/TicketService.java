package flight_booking.backend.service;

import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final FlightService flightService;

    TicketService(TicketRepository ticketRepository,
                  FlightService flightService) {
        this.ticketRepository = ticketRepository;
        this.flightService = flightService;

    }

    public List<Ticket> findAllTicketFromUserId(Long id) {
        List<Ticket> tickets = ticketRepository.findAllTicketFromUserId(id);

        return tickets;
    }

    public List<List<Ticket>> findAllListOfTicket(Long srcAirport, Long dstAirport, LocalDate departureDate, LocalTime departureTime) {

        List<List<Flight>> flights = flightService.findFlights(srcAirport, dstAirport, departureDate, departureTime);
        List<List<Ticket>> tickets = mapToTicket(flights);

        return tickets;
    }

    public List<List<Ticket>> mapToTicket(List<List<Flight>> flights){

        List<List<Ticket>> tickets = null;
        return tickets;
    }


}
