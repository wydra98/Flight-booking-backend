package flight_booking.backend.loaders;

import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Flight.FlightRepository;
import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Passenger.PassengerRepository;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Trips.Trip;
import flight_booking.backend.models.Ticket.TicketRepository;
import flight_booking.backend.models.Trips.TripRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Component
public class TicketTripLoader implements CommandLineRunner {

    TicketRepository ticketRepository;
    PassengerRepository passengerRepository;
    FlightRepository flightRepository;
    TripRepository tripRepository;

    TicketTripLoader(TicketRepository ticketRepository,
                     PassengerRepository passengerRepository,
                     FlightRepository flightRepository,
                     TripRepository tripRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (ticketRepository.amountOfRows() == 0 && tripRepository.amountOfRows() == 0) {

            Optional<Passenger> passenger1 = passengerRepository.findById(1L);
            Optional<Passenger> passenger2 = passengerRepository.findById(2L);

            Trip trip1 = Trip.builder()
                    .passenger(passenger1.get())
                    .purchaseDate(LocalDate.parse("2020-06-26"))
                    .purchaseTime(LocalTime.parse("10:43:22"))
                    .departureDate(LocalDate.parse("2020-08-26"))
                    .departureTime(LocalTime.parse("14:43:11"))
                    .price(34)
                    .build();
            tripRepository.save(trip1);


            Trip trip2 = Trip.builder()
                    .passenger(passenger1.get())
                    .purchaseDate(LocalDate.parse("2011-06-26"))
                    .purchaseTime(LocalTime.parse("11:43:22"))
                    .departureDate(LocalDate.parse("1111-08-26"))
                    .departureTime(LocalTime.parse("14:42:11"))
                    .price(45)
                    .build();
            tripRepository.save(trip2);


            Trip trip3 = Trip.builder()
                    .passenger(passenger2.get())
                    .purchaseDate(LocalDate.parse("2022-06-26"))
                    .purchaseTime(LocalTime.parse("11:40:20"))
                    .departureDate(LocalDate.parse("2212-03-25"))
                    .departureTime(LocalTime.parse("12:23:22"))
                    .price(78)
                    .build();
            tripRepository.save(trip3);

            Optional<Flight> flights1 = flightRepository.findById(1L);
            Optional<Trip> tripFind1 = tripRepository.findById(1L);
            Ticket ticket1 = Ticket.builder()
                    .passenger(passenger1.get())
                    .flight(flights1.get())
                    .trip(tripFind1.get())
                    .purchaseDate(LocalDate.parse("2020-07-29"))
                    .purchaseTime(LocalTime.parse("10:40:00"))
                    .seatNumber(23)
                    .price(34)
                    .build();
            ticketRepository.save(ticket1);

            Optional<Flight> flights2 = flightRepository.findById(1L);
            Optional<Trip> tripFind2 = tripRepository.findById(1L);
            Ticket ticket2 = Ticket.builder()
                    .passenger(passenger1.get())
                    .flight(flights2.get())
                    .trip(tripFind2.get())
                    .purchaseDate(LocalDate.parse("2020-07-29"))
                    .purchaseTime(LocalTime.parse("10:40:00"))
                    .seatNumber(23)
                    .price(34)
                    .build();
            ticketRepository.save(ticket2);

            Optional<Flight> flights3 = flightRepository.findById(1L);
            Optional<Trip> tripFind3 = tripRepository.findById(1L);
            Ticket ticket3 = Ticket.builder()
                    .passenger(passenger1.get())
                    .flight(flights3.get())
                    .trip(tripFind3.get())
                    .purchaseDate(LocalDate.parse("2020-07-29"))
                    .purchaseTime(LocalTime.parse("10:40:00"))
                    .seatNumber(23)
                    .price(34)
                    .build();
            ticketRepository.save(ticket3);


            Optional<Flight> flights4 = flightRepository.findById(1L);
            Optional<Trip> tripFind4 = tripRepository.findById(1L);
            Ticket ticket4 = Ticket.builder()
                    .passenger(passenger1.get())
                    .flight(flights4.get())
                    .trip(tripFind4.get())
                    .purchaseDate(LocalDate.parse("2020-07-29"))
                    .purchaseTime(LocalTime.parse("10:40:00"))
                    .seatNumber(23)
                    .price(34)
                    .build();
            ticketRepository.save(ticket4);

            Optional<Flight> flights5 = flightRepository.findById(2L);
            Optional<Trip> tripFind5 = tripRepository.findById(2L);
            Ticket ticket5 = Ticket.builder()
                    .passenger(passenger1.get())
                    .flight(flights5.get())
                    .trip(tripFind5.get())
                    .purchaseDate(LocalDate.parse("2020-07-29"))
                    .purchaseTime(LocalTime.parse("10:40:00"))
                    .seatNumber(111)
                    .price(666)
                    .build();
            ticketRepository.save(ticket5);
        }
    }
}






