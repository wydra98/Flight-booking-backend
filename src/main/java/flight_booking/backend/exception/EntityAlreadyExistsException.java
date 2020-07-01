package flight_booking.backend.exception;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}

