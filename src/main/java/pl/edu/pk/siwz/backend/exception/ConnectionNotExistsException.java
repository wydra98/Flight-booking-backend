package pl.edu.pk.siwz.backend.exception;

public class ConnectionNotExistsException extends RuntimeException {
        public ConnectionNotExistsException(String errorMessage) {
            super(errorMessage);
        }
    }

