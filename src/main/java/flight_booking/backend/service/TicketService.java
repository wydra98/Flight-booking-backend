package flight_booking.backend.service;

import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Ticket.TicketRepository;
import flight_booking.backend.models.Trips.Trip;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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

    public List<Trip> findAllTrips(Long srcAirport, Long dstAirport, LocalDate departureDate, LocalTime departureTime) {

        List<List<Flight>> flights = flightService.findFlights(srcAirport, dstAirport, departureDate, departureTime);
        List<Trip> trips = mapToTicket(flights);

        return trips;
    }

    public List<Trip> mapToTicket(List<List<Flight>> allFlights) {

        List<Trip> allTrips = new ArrayList<>();

        for (List<Flight> flights : allFlights) {
            Trip trip = new Trip();
            for (Flight flight : flights) {
                Ticket ticket = Ticket.builder()
                        .passenger(null)
                        .flight(flight)
                        .trip(trip)
                        .purchaseDate(LocalDate.parse("2020-07-29"))
                        .purchaseTime(LocalTime.parse("10:40:00"))
                        .seatNumber(23)
                        .price(34)
                        .build();
                trip.getTickets().add(ticket);
            }
            allTrips.add(trip);
        }
        return allTrips;
    }
}
