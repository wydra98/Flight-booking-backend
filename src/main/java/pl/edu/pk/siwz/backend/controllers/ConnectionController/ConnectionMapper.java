package pl.edu.pk.siwz.backend.controllers.ConnectionController;

import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineMapper;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportMapper;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Connection.Connection;

public class ConnectionMapper {

    private final AirlineMapper airlineMapper = new AirlineMapper();
    private final AirportMapper airportMapper = new AirportMapper();

    public ConnectionDto map(Connection connection) {
        return ConnectionDto.builder()
                .id(connection.getId())
                .srcAirportDto(airportMapper.map(connection.getSrcAirport()))
                .dstAirportDto(airportMapper.map(connection.getDstAirport()))
                .airlineDto(airlineMapper.map(connection.getAirline()))
                .numberSeats(connection.getNumberSeats())
                .departureDate(connection.getTimes().getDepartureDate().toString())
                .arrivalDate(connection.getTimes().getArrivalDate().toString())
                .departureTime(connection.getTimes().getDepartureTime().toString())
                .arrivalTime(connection.getTimes().getArrivalTime().toString())
                .build();
    }
}
