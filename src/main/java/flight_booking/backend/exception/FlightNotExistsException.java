package flight_booking.backend.exception;

public class FlightNotExistsException extends RuntimeException {
        public FlightNotExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

