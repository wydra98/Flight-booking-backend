package pl.edu.pk.siwz.backend.controllers.AirlineController;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
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
    @ApiOperation(value="Get all airlines",notes = "provide information about all airlines")
    @GetMapping
    ResponseEntity<List<AirlineDto>> getAllAirlines() {
        List<Airline> airlines = airlineService.findAll();

        ArrayList<AirlineDto> airlineDtos = new ArrayList<>();
        for (Airline airline : airlines) {
            airlineDtos.add(mapper.map(airline));
        }

        return ResponseEntity.ok(airlineDtos);
    }

      @ApiOperation(value="Add new airline",notes = "provide information about all airlines")
      @PostMapping
      ResponseEntity<Airline> addNewAirline(@RequestBody AirlineDto airlineDto) {
          Airline airline = airlineService.addNewAirline(airlineDto);
          return ResponseEntity.created(URI.create("/"+airline.getId())).body(airline);
      }
//        List<Airline> airlines = airlineService.findAll();
//
//        ArrayList<AirlineDto> airlineDtos = new ArrayList<>();
//        for (Airline airline : airlines) {
//            airlineDtos.add(mapper.map(airline));
//        }
//
//        return ResponseEntity.ok(airlineDtos);
//    }
}
