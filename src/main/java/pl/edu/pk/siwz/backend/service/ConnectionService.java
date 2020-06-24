package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.controllers.ConnectionController.ConnectionDto;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airline.AirlineRepository;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.models.Connection.ConnectionRepository;
import pl.edu.pk.siwz.backend.models.Times;

import java.time.LocalDate;
import java.time.LocalTime;


@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final AirlineRepository airlineRepository;
    private final AirportRepository airportRepository;

    public ConnectionService(ConnectionRepository connectionRepository,
                             AirlineRepository airlineRepository,
                             AirportRepository airportRepository) {

        this.connectionRepository = connectionRepository;
        this.airlineRepository = airlineRepository;
        this.airportRepository = airportRepository;
    }

    public Connection addNewConnection(ConnectionDto connectionDto) {

        Airline airline1 = airlineRepository.findAirlineByCode(connectionDto.getAirlineCode());
        Airport srcAirport1 = airportRepository.findAirportByCode(connectionDto.getSrcAirportCode());
        Airport dstAirport1 = airportRepository.findAirportByCode(connectionDto.getDstAirportCode());

        Connection connection = Connection.builder()
                .srcAirport(srcAirport1)
                .dstAirport(dstAirport1)
                .airline(airline1)
                .times(Times.builder()
                        .departureDate(LocalDate.parse(connectionDto.getDepartureDate()))
                        .arrivalDate(LocalDate.parse(connectionDto.getArrivalDate()))
                        .arrivalTime(LocalTime.parse(connectionDto.getArrivalTime()))
                        .departureTime(LocalTime.parse(connectionDto.getDepartureTime()))
                        .build())
                .numberSeats(connectionDto.getNumberSeats())
                .price(connectionDto.getPrice())
                .build();
        connectionRepository.save(connection);
        return connection;
    }

}
