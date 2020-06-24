package pl.edu.pk.siwz.backend.controllers.AirportController;


import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirportService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportMapper mapper = new AirportMapper();

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
        Airport airport = airportService.addNewAirport(airportDto, longitude, latitude);
        return ResponseEntity.created(URI.create("/" + airport.getId())).body(airport);
    }




}
