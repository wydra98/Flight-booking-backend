package flight_booking.backend.loaders;

import flight_booking.backend.models.Airline.Airline;
import flight_booking.backend.models.Airline.AirlineRepository;
import flight_booking.backend.models.Airport.AirportRepository;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Connection.ConnectionRepository;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Flight.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class FlightLoader implements CommandLineRunner {

    ConnectionRepository connectionRepository;
    AirlineRepository airlineRepository;
    FlightRepository flightRepository;

    FlightLoader(ConnectionRepository connectionRepository,
                 AirlineRepository airlineRepository,
                 FlightRepository flightRepository) {
        this.connectionRepository = connectionRepository;
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (flightRepository.amountOfRows() == 0) {

            Optional<Airline> srcAirline1 = airlineRepository.findById(2L);
            Optional<Connection> connection1 = connectionRepository.findById(1L);
            Flight flight1 = Flight.builder()
                    .connection(connection1.get())
                    .airline(srcAirline1.get())
                    .numberSeats(128)
                    .price(56)
                    .build();
            flightRepository.save(flight1);

            Optional<Airline> srcAirline2 = airlineRepository.findById(1L);
            Optional<Connection> connection2 = connectionRepository.findById(3L);
            Flight flight2 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(12)
                    .price(5)
                    .build();
            flightRepository.save(flight2);

            Optional<Airline> srcAirline3 = airlineRepository.findById(2L);
            Optional<Connection> connection3 = connectionRepository.findById(4L);
            Flight flight3 = Flight.builder()
                    .connection(connection3.get())
                    .airline(srcAirline3.get())
                    .numberSeats(55)
                    .price(51)
                    .build();
            flightRepository.save(flight3);

            Optional<Airline> srcAirline4 = airlineRepository.findById(2L);
            Optional<Connection> connection4 = connectionRepository.findById(1L);
            Flight flight4 = Flight.builder()
                    .connection(connection4.get())
                    .airline(srcAirline4.get())
                    .numberSeats(118)
                    .price(67)
                    .build();
            flightRepository.save(flight4);

            Optional<Airline> srcAirline5 = airlineRepository.findById(1L);
            Optional<Connection> connection5 = connectionRepository.findById(2L);
            Flight flight5 = Flight.builder()
                    .connection(connection5.get())
                    .airline(srcAirline5.get())
                    .numberSeats(156)
                    .price(23)
                    .build();
            flightRepository.save(flight5);
        }
    }

}