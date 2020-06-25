package pl.edu.pk.siwz.backend.controllers.AirportController;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.exception.AirportAlreadyExistsException;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirportService;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/airports")
public class AirportController {

    private final AirportMapper mapper = new AirportMapper();

    @Autowired
    private AirportService airportService;

    @ApiOperation(value = "Get all airports")
    @GetMapping
    ResponseEntity<List<AirportDto>> getAllAirports() {
        List<Airport> airports = airportService.findAll();

        ArrayList<AirportDto> airportsDtos = new ArrayList<>();
        for (Airport airport : airports) {
            airportsDtos.add(mapper.map(airport));
        }
        return ResponseEntity.ok(airportsDtos);
    }

    @ApiOperation(value = "Add new airport")
    @PostMapping
    ResponseEntity<Airport> addNewAirline(@RequestBody AirportDto airportDto,
                                          @RequestParam double longitude,
                                          @RequestParam double latitude) {
        try {
            //  airportService.checkIfCodeExists(airportDto.getId());
            Airport airport = airportService.addNewAirport(airportDto, longitude, latitude);
            return ResponseEntity.created(URI.create("/" + airport.getId())).body(airport);
        } catch (AirportAlreadyExistsException e) {
            log.error("Airport already exist", e);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }


    @ApiOperation(value = "Delete airport")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteAirport(@PathVariable Long id) {

        if (!airportService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        airportService.deleteAirport(id);
        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Update airport")
    @Transactional
    @PutMapping
    ResponseEntity<Void> updateAirport(@RequestBody AirportDto airportDto,
                                       @RequestParam double longitude,
                                       @RequestParam double latitude) {

        if (!airportService.existsById(airportDto.getId())) {
            return ResponseEntity.notFound().build();
        }

        Optional<Airport> airportOptional = airportService.findById(airportDto.getId());

        if (airportOptional.isPresent()) {
            airportOptional.get().updateForm(airportDto, longitude, latitude);
            airportService.save(airportOptional.get());
        }

        return ResponseEntity.noContent().build();
    }
}
