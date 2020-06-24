package pl.edu.pk.siwz.backend.controllers.AirportController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.service.AirportService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportMapper mapper = new AirportMapper();

    @Autowired
    private AirportService airportService;

    @GetMapping
    ResponseEntity<List<AirportDto>> getAllAirports() {
        List<Airport> airports = airportService.findAll();

        ArrayList<AirportDto> airportsDtos = new ArrayList<>();
        for (Airport airport : airports) {
            airportsDtos.add(mapper.map(airport));
        }
        return ResponseEntity.ok(airportsDtos);
    }

//    @GetMapping("/{id}")
//    ResponseEntity<AirportDto> getAirport(@PathVariable Long id) {
//        Optional<Airport> airport = airportService.findById(id);
//        System.out.println(airport);
//        if (airport.isPresent())
//            return ResponseEntity.ok(mapper.map(airport.get()));
//        else
//            return ResponseEntity.notFound().build();
//    }


}
