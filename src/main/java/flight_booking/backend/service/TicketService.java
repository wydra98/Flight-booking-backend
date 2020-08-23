package flight_booking.backend.service;

import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Tickets.Ticket;
import flight_booking.backend.models.Tickets.TicketRepository;
import flight_booking.backend.models.Trips.Trip;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
            double totalPrice = 0;
            boolean flag = false;
            LocalDateTime depDT = null;
            LocalDateTime arrDT = null;
            List<Ticket> allTickets = new ArrayList<>();
            Trip trip = Trip.builder()
                    .id(null)
                    .tickets(null)
                    .departureDate(null)
                    .departureTime(null)
                    .arrivalDate(null)
                    .arrivalTime(null)
                    .price(0)
                    .build();

            for (Flight flight : flights) {
                Ticket ticket = Ticket.builder()
                        .id(null)
                        .passenger(null)
                        .flight(flight)
                        .trip(trip)
                        .purchaseDate(null)
                        .purchaseTime(null)
                        .seatNumber(generateSeatNumber(flight.getNumberSeats()))
                        .price(flight.getPrice())
                        .build();

                LocalDateTime actualDepDT = LocalDateTime.of(flight.getTimes().getDepartureDate(), flight.getTimes().getDepartureTime());
                LocalDateTime actualArrDT = LocalDateTime.of(flight.getTimes().getArrivalDate(), flight.getTimes().getArrivalTime());
                if (!flag) {
                    depDT = actualDepDT;
                    arrDT = actualArrDT;
                }
                else{
                    if(actualDepDT.isBefore(depDT)){
                        depDT = actualDepDT;
                    }
                    if(actualArrDT.isAfter(arrDT)){
                        arrDT = actualArrDT;
                    }
                }
                allTickets.add(ticket);
                totalPrice += flight.getPrice();
                flag = true;
            }

            trip.setDepartureDate(depDT.toLocalDate());
            trip.setDepartureTime(depDT.toLocalTime());
            trip.setArrivalDate(arrDT.toLocalDate());
            trip.setArrivalTime(arrDT.toLocalTime());
            trip.setTickets(allTickets);
            trip.setPrice(totalPrice);
            allTrips.add(trip);

        }
        return allTrips;
    }

    private int generateSeatNumber(int seatNumbers){

        Random random = new Random();
        return random.nextInt(seatNumbers) + 1;
    }
}
