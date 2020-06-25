package pl.edu.pk.siwz.backend.exception;

public class AirportAlreadyExistsException extends RuntimeException {
        public AirportAlreadyExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

