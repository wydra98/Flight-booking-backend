package flight_booking.backend.controllers.FlightController;


import flight_booking.backend.controllers.AirlineController.AirlineMapper;
import flight_booking.backend.controllers.AirportController.AirportMapper;
import flight_booking.backend.models.Connection;
import flight_booking.backend.models.Flight;

public class FlightMapper {
    AirlineMapper airlineMapper = new AirlineMapper();
    AirportMapper airportMapper = new AirportMapper();

    public FlightDto map(Flight flight, Connection connection) {
        return FlightDto.builder()
                .id(flight.getId())
                .airline(airlineMapper.map(flight.getAirline()))
                .srcAirport(airportMapper.map(connection.getSrcAirport()))
                .dstAirport(airportMapper.map(connection.getDstAirport()))
                .build();
    }
}
