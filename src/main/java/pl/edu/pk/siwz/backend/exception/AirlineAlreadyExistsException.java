package pl.edu.pk.siwz.backend.exception;

public class AirlineAlreadyExistsException extends RuntimeException {
    public AirlineAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}

