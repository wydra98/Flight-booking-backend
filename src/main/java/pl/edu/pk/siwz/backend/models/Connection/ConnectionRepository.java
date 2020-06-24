package pl.edu.pk.siwz.backend.models.Connection;

import pl.edu.pk.siwz.backend.models.Connection.Connection;

public interface ConnectionRepository {
    Connection save(Connection entity);

    int amountOfRows();
}
