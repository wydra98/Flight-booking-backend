package pl.edu.pk.siwz.backend.controllers.AirlineController;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirlineService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airlines")
public class AirlineController {

    private AirlineMapper mapper = new AirlineMapper();

    @Autowired
    private AirlineService airlineService;

    // response entity ma status header body
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
        Airline airline = airlineService.addNewAirline(airlineDto, country);
        return ResponseEntity.created(URI.create("/" + airline.getId())).body(airline);
    }


    @ApiOperation(value = "Delete airline")
    @DeleteMapping("/delete/{code}")
    ResponseEntity<String> deleteAirline(@PathVariable String code) {
        airlineService.deleteAirline(code);
        return ResponseEntity.ok(code);
    }

    @ApiOperation(value = "Update airline")
    @PutMapping
    ResponseEntity<Void> updateAirline(@RequestBody AirlineDto airlineDto,
                                       @RequestParam String country) {

        if (!airlineService.existsByCode(airlineDto.getCode())) {
            return ResponseEntity.notFound().build();
        }

        Airline airline = airlineService.findAirlineByCode(airlineDto.getCode());
        airline.updateForm(airlineDto, country);

        return ResponseEntity.noContent().build();
    }
}

