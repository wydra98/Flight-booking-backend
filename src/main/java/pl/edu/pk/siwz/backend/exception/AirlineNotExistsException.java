package pl.edu.pk.siwz.backend.exception;

public class AirlineNotExistsException extends RuntimeException {
    public AirlineNotExistsException(String errorMessage) {
        super(errorMessage);
    }
}

