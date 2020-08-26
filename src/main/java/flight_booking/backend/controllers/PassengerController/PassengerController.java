package flight_booking.backend.controllers.PassengerController;

import flight_booking.backend.exception.EntityAlreadyExistsException;
import flight_booking.backend.exception.EntityNotExistsException;
import flight_booking.backend.models.Passengers.Passenger;
import flight_booking.backend.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;

    PassengerController(PassengerService passengerService
    ) {
        this.passengerService = passengerService;
        this.passengerMapper = new PassengerMapper();
    }

    @ApiOperation(value = "Get all passengers")
    @GetMapping
    ResponseEntity<List<PassengerDto>> getAllPassengers() {
        List<Passenger> passengers = passengerService.findAll();

        ArrayList<PassengerDto> passengerDtos = new ArrayList<>();
        for (Passenger passenger : passengers) {
            passengerDtos.add(passengerMapper.map(passenger));
        }
        return ResponseEntity.ok(passengerDtos);
    }


//    @ApiOperation(value = "Add new passenger")
//    @PostMapping
//    ResponseEntity<Passenger> addNewPassenger(@RequestBody PassengerDto passengerDto) {
//
//        if (passengerService.checkIfPassengerExists(passengerDto.getEmail(), passengerDto.getPhoneNumber())) {
//            throw new EntityAlreadyExistsException("Passenger with these data already exist in datebase!");
//        }
//
//        Passenger passenger = passengerService.addNewPassenger(passengerDto);
//        return ResponseEntity.created(URI.create("/" + passenger.getId())).body(passenger);
//
//    }


//    //TODO Should i do do make update passenger??
//

    @ApiOperation(value = "Delete passenger")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deletePassenger(@PathVariable Long id) {

        if (!passengerService.existsById(id)) {
            throw new EntityNotExistsException("Passenger with that id not exist!");
        }

        passengerService.deleteConnection(id);
        return ResponseEntity.ok(id);
    }


    @ExceptionHandler(EntityNotExistsException.class)
    ResponseEntity<?> handleConnectionNotExistsException(EntityNotExistsException e) {
        return ResponseEntity.notFound().build();
    }
}