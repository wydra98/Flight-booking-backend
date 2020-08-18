package flight_booking.backend.controllers.AirlineController;

import flight_booking.backend.exception.EntityAlreadyExistsException;
import flight_booking.backend.exception.EntityNotExistsException;
import flight_booking.backend.models.Airlines.Airline;
import flight_booking.backend.service.AirlineService;
import flight_booking.backend.service.ConnectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
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

    //@TODO what is better request bddy or parametr?
    @ApiOperation(value = "Add new airline")
    @PostMapping
    ResponseEntity<Airline> addNewAirline(@RequestBody AirlineDto airlineDto,
                                          @RequestParam String country) {

        if (airlineService.checkIfAirlineExists(airlineDto, country)) {
            throw new EntityAlreadyExistsException("Airline with these data already exist ins datebase!");
        }

        Airline airline = airlineService.addNewAirline(airlineDto, country);
        return ResponseEntity.created(URI.create("/" + airline.getId())).body(airline);
    }

    @ApiOperation(value = "Delete airline")
    @Transactional
    @DeleteMapping("/delete/{id}")
    ResponseEntity<Long> deleteAirline(@PathVariable Long id) {

        if (!airlineService.existsById(id)) {
            throw new EntityNotExistsException("Airline with that id not exist!");
        }

        connectionService.deleteConnectionWithAirlineId(id);
        airlineService.deleteAirline(id);
        return ResponseEntity.ok(id);
    }

    //@TODO what is better request bddy or parametr?
    @ApiOperation(value = "Update airline")
    @PutMapping
    ResponseEntity<Void> updateAirline(@RequestBody AirlineDto airlineDto,
                                       @RequestParam String country) {

        if (!airlineService.existsById(airlineDto.getId())) {
            throw new EntityNotExistsException("Airline with that ID not exist!");
        }

        Optional<Airline> airlineOptional = airlineService.findById(airlineDto.getId());
        airlineOptional.get().updateForm(airlineDto, country);
        airlineService.save(airlineOptional.get());

        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    ResponseEntity<String> handleAirlineAlreadyExistsException(EntityAlreadyExistsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(EntityNotExistsException.class)
    ResponseEntity<?> handleAirlineNotExistsException(EntityNotExistsException e) {
        return ResponseEntity.notFound().build();
    }
}

