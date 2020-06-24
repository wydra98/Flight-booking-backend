package pl.edu.pk.siwz.backend.controllers.ConnectionController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportMapper;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirportService;
import pl.edu.pk.siwz.backend.service.ConnectionService;

import java.net.URI;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @PostMapping("/connections")
    ResponseEntity<A> addNewConnection(@RequestBody Connection toUpdate){
        //Connection result = repository.save(toUpdate);
        //return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
        connectionService.save(toUpdate);
        //serwer zrealizował zadanie i nie potrzebuje zwracać żadnej odpowiedzi
        return ResponseEntity.noContent().build();
    }
}
