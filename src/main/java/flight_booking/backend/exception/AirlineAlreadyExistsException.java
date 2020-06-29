package flight_booking.backend.exception;

public class AirlineAlreadyExistsException extends RuntimeException {
    public AirlineAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}

