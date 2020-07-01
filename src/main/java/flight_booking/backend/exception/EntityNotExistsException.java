package flight_booking.backend.exception;

public class EntityNotExistsException extends RuntimeException {
        public EntityNotExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

