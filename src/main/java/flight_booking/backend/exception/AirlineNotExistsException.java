package flight_booking.backend.exception;

public class AirlineNotExistsException extends RuntimeException {
    public AirlineNotExistsException(String errorMessage) {
        super(errorMessage);
    }
}

