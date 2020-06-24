package pl.edu.pk.siwz.backend.service;

import org.springframework.stereotype.Service;
import pl.edu.pk.siwz.backend.models.Airport.AirportRepository;
import pl.edu.pk.siwz.backend.models.Connection.ConnectionRepository;

@Service
public class ConnectionService {

    private final ConnectionRepository repository;

    public ConnectionService(ConnectionRepository repository) {
        this.repository = repository;
    }

}
