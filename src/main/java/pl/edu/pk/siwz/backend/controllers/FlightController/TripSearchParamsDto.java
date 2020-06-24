package pl.edu.pk.siwz.backend.controllers.FlightController;

import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;

public class TripSearchParamsDto {
    private boolean oneWay;
    private AirportDto from;
    private AirportDto to;
    private String departureDate;
    private String arrivalDate;
    private int passengerNumber;
    private String tripClass;
}
