package pl.edu.pk.siwz.backend.controllers.FlightController;

import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;

import java.util.ArrayList;

public class OneWayTripDto {
    private int id;
    private boolean directFlight;
    private ArrayList<TicketDto> tickets;
    private AirportDto source;
    private AirportDto destination;
    // @TODO: change dates from String to better type mb?
    private String departureDate;
    private String arrivalDate;
}
