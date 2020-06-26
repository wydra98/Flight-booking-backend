package pl.edu.pk.siwz.backend.exception;

public class AirportNotExistsException extends RuntimeException {
        public AirportNotExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

