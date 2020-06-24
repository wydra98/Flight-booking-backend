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
import java.time.LocalTime;


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

            Airline airline1 = airlineRepository.findAirlineByCode("AA");
            Airport srcAirport1 = airportRepository.findAirportByCode("AAA");
            Airport dstAirport1 = airportRepository.findAirportByCode("AAB");
            Connection connection1 = Connection.builder()
                    .srcAirport(srcAirport1)
                    .dstAirport(dstAirport1)
                    .airline(airline1)
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

            Airline airline2 = airlineRepository.findAirlineByCode("AA");
            Airport srcAirport2 = airportRepository.findAirportByCode("AAC");
            Airport dstAirport2 = airportRepository.findAirportByCode("AAD");
            Connection connection2 = Connection.builder()
                    .srcAirport(srcAirport2)
                    .dstAirport(dstAirport2)
                    .airline(airline2)
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

            Airline airline3 = airlineRepository.findAirlineByCode("AA");
            Airport srcAirport3 = airportRepository.findAirportByCode("AAD");
            Airport dstAirport3 = airportRepository.findAirportByCode("AAE");
            Connection connection3 = Connection.builder()
                    .srcAirport(srcAirport3)
                    .dstAirport(dstAirport3)
                    .airline(airline3)
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

            Airline airline4 = airlineRepository.findAirlineByCode("AA");
            Airport srcAirport4 = airportRepository.findAirportByCode("AAD");
            Airport dstAirport4 = airportRepository.findAirportByCode("AAC");
            Connection connection4 = Connection.builder()
                    .srcAirport(srcAirport4)
                    .dstAirport(dstAirport4)
                    .airline(airline4)
                    .times(Times.
                            builder()
                            .departureDate(LocalDate.parse("2020-03-25"))
                            .arrivalDate(LocalDate.parse("2020-07-29"))
                            .arrivalTime(LocalTime.parse("10:40:00"))
                            .departureTime(LocalTime.parse("10:40:00"))
                            .build())
                    .numberSeats(128)
                    .price(34.5)
                    .build();
            connectionRepository.save(connection4);

            Airline airline5 = airlineRepository.findAirlineByCode("AA");
            Airport srcAirport5 = airportRepository.findAirportByCode("AAB");
            Airport dstAirport5 = airportRepository.findAirportByCode("AAD");
            Connection connection5 = Connection.builder()
                    .srcAirport(srcAirport5)
                    .dstAirport(dstAirport5)
                    .airline(airline5)
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

