package pl.edu.pk.siwz.backend.models.Connection;

import org.springframework.data.repository.query.Param;
import pl.edu.pk.siwz.backend.models.Connection.Connection;

public interface ConnectionRepository {
    Connection save(Connection entity);

    int amountOfRows();

    void deleteAllConnectionWithAirlineId(@Param("id") Long id);

    void deleteAllConnectionWithAirportId(@Param("id") Long id);
}
