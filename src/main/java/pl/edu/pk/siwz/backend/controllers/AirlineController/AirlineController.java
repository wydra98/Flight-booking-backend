package pl.edu.pk.siwz.backend.controllers.AirlineController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;
import pl.edu.pk.siwz.backend.exception.AirportAlreadyExistsException;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirlineService;
import pl.edu.pk.siwz.backend.service.ConnectionService;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@RequestMapping("/airlines")
public class AirlineController {

    private final AirlineMapper mapper = new AirlineMapper();
    private final AirlineService airlineService;
    private final ConnectionService connectionService;


    public AirlineController(AirlineService airlineService, ConnectionService connectionService) {
        this.airlineService = airlineService;
        this.connectionService = connectionService;
    }

    @ApiOperation(value = "Get all airlines")
    @GetMapping
    ResponseEntity<List<AirlineDto>> getAllAirlines() {
        List<Airline> airlines = airlineService.findAll();

        ArrayList<AirlineDto> airlineDtos = new ArrayList<>();
        for (Airline airline : airlines) {
            airlineDtos.add(mapper.map(airline));
        }

        return ResponseEntity.ok(airlineDtos);
    }

    @ApiOperation(value = "Add new airline")
    @PostMapping
    ResponseEntity<Airline> addNewAirline(@RequestBody AirlineDto airlineDto,
                                          @RequestParam String country) {
        try {
            airlineService.checkIfIdExists(airlineDto.getId());
            Airline airline = airlineService.addNewAirline(airlineDto, country);
            return ResponseEntity.created(URI.create("/" + airline.getId())).body(airline);
        } catch (AirportAlreadyExistsException e) {
            log.error("Airport already exist", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @ApiOperation(value = "Delete airline")
    @Transactional
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> deleteAirline(@PathVariable Long id) {
        connectionService.deleteConnection(id);
        airlineService.deleteAirline(id);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airline")
    @PutMapping
    ResponseEntity<Void> updateAirline(@RequestBody AirlineDto airlineDto,
                                       @RequestParam String country) {

        if (!airlineService.existsById(airlineDto.getId())) {
            return ResponseEntity.notFound().build();
        }

        Optional<Airline> airline = airlineService.findById(airlineDto.getId());
        airline.get().updateForm(airlineDto, country);

        return ResponseEntity.noContent().build();
    }
}

