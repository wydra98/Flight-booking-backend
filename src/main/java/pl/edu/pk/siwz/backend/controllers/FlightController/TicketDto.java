package pl.edu.pk.siwz.backend.controllers.FlightController;

public class TicketDto {
    private int id;
    private FlightDto flight;
    private PassengerDto passanger;
    // @TODO: change string to better date type?
    private String dateOfPurchase;
    // in dto string is probably ok since it must be string in frontend
    private String flightClass;
    private int seatNumber;
    private int maxLuggageWeight;
    // @TODO: change price to appropriate type
    private double price;
}
