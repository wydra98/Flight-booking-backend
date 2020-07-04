package flight_booking.backend.loaders;

import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Flight.FlightRepository;
import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Passenger.PassengerRepository;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Ticket.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Component
public class TicketLoader implements CommandLineRunner {

    TicketRepository ticketRepository;
    PassengerRepository passengerRepository;
    FlightRepository flightRepository;

    TicketLoader(TicketRepository ticketRepository,
                 PassengerRepository passengerRepository,
                 FlightRepository flightRepository) {
        this.ticketRepository = ticketRepository;
        this.passengerRepository = passengerRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (ticketRepository.amountOfRows() == 0) {

            Optional<Passenger> passenger1 = passengerRepository.findById(1L);
            Optional<Flight> flights1 = flightRepository.findById(1L);
            Optional<Flight> flights2 = flightRepository.findById(1L);
            List<Flight> flights = List.of(flights1.get(), flights2.get());
            Ticket ticket1 = Ticket.builder()
                    .passenger(passenger1.get())
                    .flights(flights)
                    .purchaseDate(LocalDate.parse("2020-07-29"))
                    .purchaseTime(LocalTime.parse("10:40:00"))
                    .seatNumber(23)
                    .price(34)
                    .build();
            System.out.println("Co tam co tam?");
        ticketRepository.save(ticket1);
        }
    }
}
