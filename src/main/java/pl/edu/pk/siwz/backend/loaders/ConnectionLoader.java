package pl.edu.pk.siwz.backend.loaders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.models.Connection.ConnectionRepository;
import pl.edu.pk.siwz.backend.models.Times;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;


@Component
public class ConnectionLoader implements CommandLineRunner {

    ConnectionRepository connectionRepository;
    AirlineRepository airlineRepository;
    AirportRepository airportRepository;

    ConnectionLoader(ConnectionRepository connectionRepository,
                     AirlineRepository airlineRepository,
                     AirportRepository airportRepository) {
        this.connectionRepository = connectionRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (connectionRepository.amountOfRows() == 0) {

            Optional<Airline> airline1 = airlineRepository.findById(1L);
            Optional<Airport> srcAirport1 = airportRepository.findById(2L);
            Optional<Airport> dstAirport1 = airportRepository.findById(3L);
            Connection connection1 = Connection.builder()
                    .srcAirport(srcAirport1.get())
                    .dstAirport(dstAirport1.get())
                    .airline(airline1.get())
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-04-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("10:40:00"))
                            .build())
                    .numberSeats(128)
                    .price(34.5)
                    .build();
            connectionRepository.save(connection1);
            //System.out.println(connection1);

            Optional<Airline> airline2 = airlineRepository.findById(1L);
            Optional<Airport> srcAirport2 = airportRepository.findById(1L);
            Optional<Airport> dstAirport2 = airportRepository.findById(4L);
            Connection connection2 = Connection.builder()
                    .srcAirport(srcAirport2.get())
                    .dstAirport(dstAirport2.get())
                    .airline(airline2.get())
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-03-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("10:40:00"))
                            .build())
                    .numberSeats(128)
                    .price(34.5)
                    .build();
            connectionRepository.save(connection2);

            Optional<Airline> airline3 = airlineRepository.findById(1L);
            Optional<Airport> srcAirport3 = airportRepository.findById(3L);
            Optional<Airport> dstAirport3 = airportRepository.findById(4L);
            Connection connection3 = Connection.builder()
                    .srcAirport(srcAirport3.get())
                    .dstAirport(dstAirport3.get())
                    .airline(airline3.get())
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-02-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("10:40:00"))
                            .build())
                    .numberSeats(128)
                    .price(34.5)
                    .build();
            connectionRepository.save(connection3);

            //Optional<Airline> airline4 = airlineRepository.findById(2L);
            Optional<Airport> srcAirport4 = airportRepository.findById(1L);
            Optional<Airport> dstAirport4 = airportRepository.findById(3L);
            Connection connection4 = Connection.builder()
                    .srcAirport(srcAirport4.get())
                    .dstAirport(dstAirport4.get())
                    .times(Times.
                            builder()
                            .departureDate(LocalDateTime.parse("2020-03-25"))
                            .arrivalDate(LocalDateTime.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("10:40:00"))
                            .build())
                    .numberSeats(128)
                    .price(34.5)
                    .build();
            connectionRepository.save(connection4);

            Optional<Airline> airline5 = airlineRepository.findById(2L);
            Optional<Airport> srcAirport5 = airportRepository.findById(2L);
            Optional<Airport> dstAirport5 = airportRepository.findById(3L);
            Connection connection5 = Connection.builder()
                    .srcAirport(srcAirport5.get())
                    .dstAirport(dstAirport5.get())
                    .airline(airline5.get())
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-07-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("10:45:00"))
                            .build())
                    .numberSeats(128)
                    .price(34.5)
                    .build();
            connectionRepository.save(connection5);
        }
    }

}

