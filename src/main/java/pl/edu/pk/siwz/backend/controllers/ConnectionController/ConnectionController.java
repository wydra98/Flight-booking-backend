package pl.edu.pk.siwz.backend.controllers.ConnectionController;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineMapper;
import pl.edu.pk.siwz.backend.exception.ConnectionNotExistsException;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.service.AirlineService;
import pl.edu.pk.siwz.backend.service.AirportService;
import pl.edu.pk.siwz.backend.service.ConnectionService;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.*;


@RestController
@RequestMapping("/connections")
public class ConnectionController {

    private ConnectionService connectionService;
    private AirportService airportService;
    private AirlineService  airlineService;
    private ConnectionMapper connectionMapper = new ConnectionMapper();

    ConnectionController(ConnectionService connectionService, AirportService airportService, AirlineService airlineService) {
        this.connectionService = connectionService;
        this.airportService = airportService;
        this.airlineService = airlineService;
    }

    @ApiOperation(value = "Get all connections")
    @GetMapping
    ResponseEntity<List<ConnectionDto>> getAllConnections() {
        List<Connection> connections = connectionService.findAll();

        ArrayList<ConnectionDto> connectionsDtos = new ArrayList<>();
        for (Connection connection : connections) {
            connectionsDtos.add(connectionMapper.map(connection));
        }
        return ResponseEntity.ok(connectionsDtos);
    }

    @ApiOperation(value = "Add new connection")
    @PostMapping
    ResponseEntity<Connection> addNewConnection(@RequestBody ConnectionDto connectionDto) {

        /*
         * linia lotnicza moze miec kilka samolotow i je wkorszystywac bez problemu, wiec moze byc
         * teoretycznie kilka takich samych polaczen z tego samego lotniska zrodlowego do tego samego lotniska
         * docelowe w tym samym czasie
         */

        Connection connection = connectionService.addNewConnection(connectionDto);
        return ResponseEntity.created(URI.create("/" + connection.getId())).body(connection);
    }

    @ApiOperation(value = "Update connection")
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateConnection(@RequestBody ConnectionDto connectionDto) {

        if (!connectionService.existsById(connectionDto.getId())) {
            throw new ConnectionNotExistsException("Connection with that id not exist!");
        }

        Optional<Connection> connectionOptional = connectionService.findById(connectionDto.getId());
        Optional<Airline> airline = airlineService.findById(connectionDto.getAirlineDto().getId());
        Optional<Airport> srcAirport = airportService.findById(connectionDto.getSrcAirportDto().getId());
        Optional<Airport> dstAirport  = airportService.findById(connectionDto.getDstAirportDto().getId());

        connectionOptional.get().updateForm(connectionDto.getId(),
                                            srcAirport.get(),
                                            dstAirport.get(),
                                            airline.get(),
                                            connectionDto.getNumberSeats(),
                                            connectionDto.getArrivalDate(),
                                            connectionDto.getArrivalTime(),
                                            connectionDto.getDepartureDate(),
                                            connectionDto.getDepartureTime(),
                                            connectionDto.getPrice());
        connectionService.save(connectionOptional.get());

        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Delete connection")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteConnection(@PathVariable Long id) {

        if (!connectionService.existsById(id)) {
            throw new ConnectionNotExistsException("Connection with that id not exist!");
        }

        connectionService.deleteConnection(id);
        return ResponseEntity.ok(id);
    }


    @ExceptionHandler(ConnectionNotExistsException.class)
    ResponseEntity<?> handleConnectionNotExistsException(ConnectionNotExistsException e) {
        return ResponseEntity.notFound().build();
    }
}
