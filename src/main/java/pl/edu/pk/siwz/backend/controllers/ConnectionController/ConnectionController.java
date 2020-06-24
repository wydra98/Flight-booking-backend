package pl.edu.pk.siwz.backend.controllers.ConnectionController;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.models.Connection.Connection;
import pl.edu.pk.siwz.backend.service.ConnectionService;

import java.net.URI;


@RestController
@RequestMapping("/connections")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @ApiOperation(value = "Add new connection")
    @PostMapping
    ResponseEntity<Connection> addNewAirline(@RequestBody ConnectionDto connectionDto) {
        Connection connection = connectionService.addNewConnection(connectionDto);
        return ResponseEntity.created(URI.create("/" + connection.getId())).body(connection);
    }
}
