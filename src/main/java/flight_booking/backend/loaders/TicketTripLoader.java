package flight_booking.backend.loaders;

import flight_booking.backend.models.*;
import flight_booking.backend.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Component
public class TicketTripLoader implements CommandLineRunner {

    TicketRepository ticketRepository;
    PassengerRepository passengerRepository;
    FlightRepository flightRepository;
    TripRepository tripRepository;
    UserRepository userRepository;

    TicketTripLoader(TicketRepository ticketRepository,
                     PassengerRepository passengerRepository,
                     FlightRepository flightRepository,
                     TripRepository tripRepository,
                     UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (ticketRepository.amountOfRows() == 0 && tripRepository.amountOfRows() == 0) {

            // GET PASSENGERS
            Optional<Passenger> passenger1 = passengerRepository.findById(1L);
            Optional<Passenger> passenger2 = passengerRepository.findById(2L);
            Optional<Passenger> passenger3 = passengerRepository.findById(3L);
            Optional<User> user1 = userRepository.findById(2L);

            // TRIP FROM NEW YORK TO WARSAW WITH TICKETS BELONG TO PASSENGER 1
            if (passenger1.isPresent() && user1.isPresent()) {
                tripRepository.save(Trip.builder()
                        .arrivalDate(LocalDate.parse("2021-01-03"))
                        .arrivalTime(LocalTime.parse("16:30:00"))
                        .departureDate(LocalDate.parse("2021-01-02"))
                        .departureTime(LocalTime.parse("14:43:11"))
                        .purchaseDate(LocalDate.parse("2020-08-28"))
                        .purchaseTime(LocalTime.parse("09:03:56"))
                        .passenger(passenger1.get())
                        .user(user1.get())
                        .price(1345)
                        .build());
            }

            Optional<Trip> trip1 = tripRepository.findById(1L);
            List<Ticket> allTickets1 = new ArrayList<>();

            Optional<Flight> flight1 = flightRepository.findById(370L);
            if (passenger1.isPresent() && flight1.isPresent() && trip1.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger1.get())
                        .flight(flight1.get())
                        .trip(trip1.get())
                        .seatNumber(34)
                        .price(225)
                        .build());

                allTickets1.add(ticket);
            }

            Optional<Flight> flight2 = flightRepository.findById(3592L);
            if (passenger1.isPresent() && flight2.isPresent() && trip1.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger1.get())
                        .flight(flight2.get())
                        .trip(trip1.get())
                        .seatNumber(56)
                        .price(560)
                        .build());

                allTickets1.add(ticket);
            }

            Optional<Flight> flight3 = flightRepository.findById(3958L);
            if (passenger1.isPresent() && flight3.isPresent() && trip1.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger1.get())
                        .flight(flight3.get())
                        .trip(trip1.get())
                        .seatNumber(64)
                        .price(560)
                        .build());

                allTickets1.add(ticket);
            }

            if (trip1.isPresent()) {
                trip1.get().setTickets(allTickets1);
                tripRepository.save(trip1.get());
            }


            // TRIP FROM PEKIN TO TORONTO WITH TICKETS BELONG TO PASSENGER 1
            if (passenger1.isPresent() && user1.isPresent()) {
                tripRepository.save(Trip.builder()
                        .arrivalDate(LocalDate.parse("2021-04-06"))
                        .arrivalTime(LocalTime.parse("03:00:00"))
                        .departureDate(LocalDate.parse("2021-04-05"))
                        .departureTime(LocalTime.parse("15:00:00"))
                        .purchaseDate(LocalDate.parse("2020-08-28"))
                        .purchaseTime(LocalTime.parse("09:44:06"))
                        .passenger(passenger1.get())
                        .user(user1.get())
                        .price(405)
                        .build());
            }


            Optional<Trip> trip2 = tripRepository.findById(2L);
            List<Ticket> allTickets2 = new ArrayList<>();

            Optional<Flight> flight4 = flightRepository.findById(8487L);
            if (passenger1.isPresent() && flight4.isPresent() && trip2.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger1.get())
                        .flight(flight4.get())
                        .trip(trip2.get())
                        .seatNumber(79)
                        .price(405)
                        .build());

                allTickets2.add(ticket);
            }

            if (trip2.isPresent()) {
                trip2.get().setTickets(allTickets2);
                tripRepository.save(trip2.get());
            }


            // TRIP FROM PARIS TO MOSCOW WITH TICKETS BELONG TO PASSENGER 2
            if (passenger2.isPresent() && user1.isPresent()) {
                tripRepository.save(Trip.builder()
                        .arrivalDate(LocalDate.parse("2021-03-17"))
                        .arrivalTime(LocalTime.parse("09:45:00"))
                        .departureDate(LocalDate.parse("2021-03-16"))
                        .departureTime(LocalTime.parse("07:00:00"))
                        .purchaseDate(LocalDate.parse("2020-08-28"))
                        .purchaseTime(LocalTime.parse("09:53:35"))
                        .passenger(passenger2.get())
                        .user(user1.get())
                        .price(320)
                        .build());
            }


            Optional<Trip> trip3 = tripRepository.findById(3L);
            List<Ticket> allTickets3 = new ArrayList<>();

            Optional<Flight> flight5 = flightRepository.findById(14820L);
            if (passenger2.isPresent() && flight5.isPresent() && trip3.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger2.get())
                        .flight(flight5.get())
                        .trip(trip3.get())
                        .seatNumber(8)
                        .price(100)
                        .build());

                allTickets3.add(ticket);
            }

            Optional<Flight> flight6 = flightRepository.findById(17011L);
            if (passenger2.isPresent() && flight6.isPresent() && trip3.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger2.get())
                        .flight(flight6.get())
                        .trip(trip3.get())
                        .seatNumber(42)
                        .price(220)
                        .build());

                allTickets3.add(ticket);
            }

            if (trip3.isPresent()) {
                trip3.get().setTickets(allTickets3);
                tripRepository.save(trip3.get());
            }


            // TRIP FROM OSLO TO LONDON WITH TICKETS BELONG TO PASSENGER 3
            if (passenger3.isPresent() && user1.isPresent()) {
                tripRepository.save(Trip.builder()
                        .arrivalDate(LocalDate.parse("2020-12-02"))
                        .arrivalTime(LocalTime.parse("13:45:00"))
                        .departureDate(LocalDate.parse("2020-12-02"))
                        .departureTime(LocalTime.parse("12:15:00"))
                        .purchaseDate(LocalDate.parse("2020-08-28"))
                        .purchaseTime(LocalTime.parse("10:14:42"))
                        .passenger(passenger3.get())
                        .user(user1.get())
                        .price(78)
                        .build());
            }


            Optional<Trip> trip4 = tripRepository.findById(4L);
            List<Ticket> allTickets4 = new ArrayList<>();

            Optional<Flight> flight7 = flightRepository.findById(13558L);
            if (passenger3.isPresent() && flight7.isPresent() && trip4.isPresent()) {
                Ticket ticket = ticketRepository.save(Ticket.builder()
                        .passenger(passenger3.get())
                        .flight(flight7.get())
                        .trip(trip4.get())
                        .seatNumber(65)
                        .price(150)
                        .build());

                allTickets4.add(ticket);
            }

            if (trip4.isPresent()) {
                trip4.get().setTickets(allTickets4);
                tripRepository.save(trip4.get());
            }

            Optional<User> user = userRepository.findById(2L);
            Set<Trip> allTrips = new HashSet<>();

            Optional<Trip> tripFind1 = tripRepository.findById(1L);
            Optional<Trip> tripFind2 = tripRepository.findById(2L);
            Optional<Trip> tripFind3 = tripRepository.findById(3L);

            tripFind1.ifPresent(allTrips::add);
            tripFind2.ifPresent(allTrips::add);
            tripFind3.ifPresent(allTrips::add);

            if (user.isPresent()) {
                user.get().setTrips(allTrips);
                userRepository.save(user.get());
            }
        }
    }
}






