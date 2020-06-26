package pl.edu.pk.siwz.backend.adapter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.models.Connection.ConnectionRepository;

import javax.transaction.Transactional;


public interface SqlConnectionRepository extends ConnectionRepository, JpaRepository<Connection, Long> {

    @Override
    @Query(value = "SELECT COUNT (c.connection_id) FROM connections c", nativeQuery = true)
    int amountOfRows();

    @Override
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM connections c WHERE c.airline_id=:id", nativeQuery = true)
    void deleteAllConnectionWithAirlineId(@Param("id") Long id);

    @Override
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM connections c WHERE c.airport_src_id =:id OR airport_dst_id=:id", nativeQuery = true)
    void deleteAllConnectionWithAirportId(@Param("id") Long id);
}
