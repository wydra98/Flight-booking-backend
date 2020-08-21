package flight_booking.backend.service;

import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Tickets.Ticket;
import flight_booking.backend.models.Tickets.TicketRepository;
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

    public List<Trip> findAllTrips(Long srcAirport, Long dstAirport, LocalDate departureDate) {

        List<List<Flight>> flights = flightService.findFlights(srcAirport, dstAirport, departureDate);

        List<Trip> trips = mapToTicket(flights);
        return trips;
    }

    public List<Trip> mapToTicket(List<List<Flight>> allFlights) {

        List<Trip> allTrips = new ArrayList<>();

        for (List<Flight> flights : allFlights) {
            List<Ticket> allTickets = new ArrayList<>();
            Trip trip = Trip.builder()
                    .id(1L)
                    .tickets(null)
                    .departureDate(LocalDate.parse("2020-07-29"))
                    .departureTime(LocalTime.parse("10:40:00"))
                    .arrivalDate(LocalDate.parse("2020-07-29"))
                    .arrivalTime(LocalTime.parse("10:40:00"))
                    .price(5.6)
                    .build();

            for (Flight flight : flights) {
                //System.out.println("dupa");
                Ticket ticket = Ticket.builder()
                        .passenger(null)
                        .flight(flight)
                        .trip(trip)
                        .purchaseDate(LocalDate.parse("2020-07-29"))
                        .purchaseTime(LocalTime.parse("10:40:00"))
                        .seatNumber(23)
                        .price(34)
                        .build();
                //trip.addTicket(ticket);
                allTickets.add(ticket);
                //System.out.println(allTickets);

            }
            //System.out.println(allTickets);
            trip.setTickets(allTickets);
            allTrips.add(trip);
        }
        return allTrips;
    }
}
