package flight_booking.backend.exception;

public class ConnectionNotExistsException extends RuntimeException {
        public ConnectionNotExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

