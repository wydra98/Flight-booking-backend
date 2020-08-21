package flight_booking.backend.loaders;

import flight_booking.backend.models.Airlines.Airline;
import flight_booking.backend.models.Airlines.AirlineRepository;
import flight_booking.backend.models.Connections.Connection;
import flight_booking.backend.models.Connections.ConnectionRepository;
import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Flights.FlightRepository;
import flight_booking.backend.models.Times;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
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
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight1);

            /*** Z TEGO SAMEGO DO TEGO SAMEGO ***/
            Optional<Airline> srcAirline2 = airlineRepository.findById(1L);
            Optional<Connection> connection2 = connectionRepository.findById(2L);
            Flight flight2 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(12)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("17:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight2);

            Flight flight16 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(13)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight16);

            Flight flight17 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(14)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-08-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight17);

            Flight flight18 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(15)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2021-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight18);


            Flight flight19 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(16)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight19);

            Flight flight20 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(17)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-24"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight20);

            Flight flight21 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(18)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-26"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight21);

            Flight flight22 = Flight.builder()
                    .connection(connection2.get())
                    .airline(srcAirline2.get())
                    .numberSeats(19)
                    .price(5)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight22);

            /**KONIEC*/

            Optional<Airline> srcAirline3 = airlineRepository.findById(2L);
            Optional<Connection> connection3 = connectionRepository.findById(3L);
            Flight flight3 = Flight.builder()
                    .connection(connection3.get())
                    .airline(srcAirline3.get())
                    .numberSeats(55)
                    .price(51)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight3);

            Optional<Airline> srcAirline4 = airlineRepository.findById(2L);
            Optional<Connection> connection4 = connectionRepository.findById(4L);
            Flight flight4 = Flight.builder()
                    .connection(connection4.get())
                    .airline(srcAirline4.get())
                    .numberSeats(118)
                    .price(67)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight4);

            Optional<Airline> srcAirline5 = airlineRepository.findById(1L);
            Optional<Connection> connection5 = connectionRepository.findById(5L);
            Flight flight5 = Flight.builder()
                    .connection(connection5.get())
                    .airline(srcAirline5.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight5);

            Optional<Airline> srcAirline6 = airlineRepository.findById(1L);
            Optional<Connection> connection6 = connectionRepository.findById(6L);
            Flight flight6 = Flight.builder()
                    .connection(connection6.get())
                    .airline(srcAirline6.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("18:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight6);

            Optional<Airline> srcAirline7 = airlineRepository.findById(1L);
            Optional<Connection> connection7 = connectionRepository.findById(7L);
            Flight flight7 = Flight.builder()
                    .connection(connection7.get())
                    .airline(srcAirline7.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight7);

            Optional<Airline> srcAirline8 = airlineRepository.findById(1L);
            Optional<Connection> connection8 = connectionRepository.findById(8L);
            Flight flight8 = Flight.builder()
                    .connection(connection8.get())
                    .airline(srcAirline8.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight8);

            Optional<Airline> srcAirline9 = airlineRepository.findById(1L);
            Optional<Connection> connection9 = connectionRepository.findById(9L);
            Flight flight9 = Flight.builder()
                    .connection(connection9.get())
                    .airline(srcAirline9.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight9);

            Optional<Airline> srcAirline10 = airlineRepository.findById(1L);
            Optional<Connection> connection10 = connectionRepository.findById(10L);
            Flight flight10 = Flight.builder()
                    .connection(connection10.get())
                    .airline(srcAirline10.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight10);

            Optional<Airline> srcAirline11 = airlineRepository.findById(1L);
            Optional<Connection> connection11 = connectionRepository.findById(11L);
            Flight flight11 = Flight.builder()
                    .connection(connection11.get())
                    .airline(srcAirline11.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight11);

            Optional<Airline> srcAirline12 = airlineRepository.findById(1L);
            Optional<Connection> connection12 = connectionRepository.findById(12L);
            Flight flight12 = Flight.builder()
                    .connection(connection12.get())
                    .airline(srcAirline12.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight12);

            Optional<Airline> srcAirline13 = airlineRepository.findById(1L);
            Optional<Connection> connection13 = connectionRepository.findById(13L);
            Flight flight13 = Flight.builder()
                    .connection(connection13.get())
                    .airline(srcAirline13.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight13);

            Optional<Airline> srcAirline14 = airlineRepository.findById(1L);
            Optional<Connection> connection14 = connectionRepository.findById(14L);
            Flight flight14 = Flight.builder()
                    .connection(connection14.get())
                    .airline(srcAirline14.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight14);

            Optional<Airline> srcAirline15 = airlineRepository.findById(1L);
            Optional<Connection> connection15 = connectionRepository.findById(15L);
            Flight flight15 = Flight.builder()
                    .connection(connection15.get())
                    .airline(srcAirline15.get())
                    .numberSeats(156)
                    .price(23)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("17:45:00"))
                            .build())
                    .build();
            flightRepository.save(flight15);
        }
    }

}