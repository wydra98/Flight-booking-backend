package flight_booking.backend.exception;

public class AirportNotExistsException extends RuntimeException {
        public AirportNotExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

