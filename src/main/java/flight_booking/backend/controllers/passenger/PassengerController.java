package flight_booking.backend.controllers.passenger;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.services.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@ExceptionProcessing
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;
    private final TripService tripService;
    private final PassengerMapper passengerMapper;

    PassengerController(PassengerService passengerService,
                        TripService tripService
    ) {
        this.passengerService = passengerService;
        this.tripService = tripService;
        this.passengerMapper = new PassengerMapper();
    }

    @ApiOperation(value = "Get all passengers", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping
    ResponseEntity<List<PassengerDto>> getAllPassengers() {

        List<Passenger> passengers = passengerService.findAll();
        ArrayList<PassengerDto> passengerDtos = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerDtos.add(passengerMapper.map(passenger));
        }

        return ResponseEntity.ok(passengerDtos);
    }

    @ApiOperation(value = "Get all passengers from one trip", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/trip")
    ResponseEntity<List<PassengerDto>> getPassengersAssignedToTrip(@RequestParam Long id) {

        tripService.validateTripId(id);
        List<Passenger> passengers = tripService.findPassengersByTrip(id);
        ArrayList<PassengerDto> passengerDtos = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerDtos.add(passengerMapper.map(passenger));
        }

        return ResponseEntity.ok(passengerDtos);
    }


    @ApiOperation(value = "Add new passenger", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @PostMapping("/passengers/add")
    ResponseEntity<Passenger> addNewPassenger(@RequestBody PassengerDto passengerDto) {

        passengerService.validateIfExists(passengerDto.getPesel());
        Passenger passenger = passengerService.addNewPassenger(passengerDto);

        return ResponseEntity.created(URI.create("/" + passenger.getId())).body(passenger);
    }


    @ApiOperation(value = "Delete passenger", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletePassenger(@PathVariable Long id) {

        passengerService.validateIfNonExists(id);
        Optional<Passenger> passenger = passengerService.findById(id);

        if (passenger.isPresent()) {
            tripService.deleteTrips(passenger.get().getTrips());
            passengerService.deletePassenger(passenger.get());
        }

        return ResponseEntity.ok(id);
    }
}
