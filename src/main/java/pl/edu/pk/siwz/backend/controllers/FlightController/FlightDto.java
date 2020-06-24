package pl.edu.pk.siwz.backend.controllers.FlightController;

import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;

public class FlightDto {
    private int flightNumber;
    private AirlineDto airline;
    private AirportDto airport;
    private int capacity;
    // @TODO: change date to better types
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
}
