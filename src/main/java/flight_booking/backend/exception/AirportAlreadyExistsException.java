package flight_booking.backend.exception;

public class AirportAlreadyExistsException extends RuntimeException {
        public AirportAlreadyExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

