package flight_booking.backend.controllers.PassengerController;

import flight_booking.backend.controllers.AirlineController.AirlineDto;
import flight_booking.backend.exception.EntityAlreadyExistsException;
import flight_booking.backend.exception.EntityNotExistsException;
import flight_booking.backend.models.Passenger.Passenger;
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


    @ApiOperation(value = "Add new passenger")
    @PostMapping
    ResponseEntity<Passenger> addNewPassenger(@RequestBody PassengerDto passengerDto) {

//        if (passengerService.checkIfPassengerExists(passengerDto)) {
//            throw new EntityAlreadyExistsException("Passenger with these data already exist in datebase!");
//        }

        Passenger passenger = passengerService.addNewPassenger(passengerDto);
        return ResponseEntity.created(URI.create("/" + passenger.getId())).body(passenger);

    }
//
//    //TODO add validators for examples like "if airlineId exists"
//    @ApiOperation(value = "Update flight")
//    @Transactional
//    @PutMapping
//    ResponseEntity<Void> updateFlight(@RequestParam Long flightId,
//                                      @RequestParam Long airlineId,
//                                      @RequestParam int numberSeats,
//                                      @RequestParam double price,
//                                      @RequestParam Long srcAirportId,
//                                      @RequestParam Long dstAirportId,
//                                      @RequestParam String departureDate,
//                                      @RequestParam String departureTime,
//                                      @RequestParam String arrivalDate,
//                                      @RequestParam String arrivalTime) {
//
//        if (!flightService.existsById(flightId)) {
//            throw new FlightNotExistsException("Flight with that id not exist!");
//        }
//
//        if (!connectionService.existsById(flightId)) {
//            throw new ConnectionNotExistsException("Connection with that id not exist!");
//        }
//
//        Optional<Flight> flightOptional = flightService.findById(flightId);
//        Connection connection = flightService.findConnection(flightId);
//        Optional<Airline> airline = airlineService.findById(airlineId);
//        Optional<Airport> srcAirport = airportService.findById(srcAirportId);
//        Optional<Airport> dstAirport = airportService.findById(dstAirportId);
//
//        connection.updateForm(
//                srcAirport.get(),
//                dstAirport.get(),
//                arrivalDate,
//                departureDate,
//                arrivalTime,
//                departureTime
//        );
//
//        flightOptional.get().updateForm(
//                airline.get(),
//                numberSeats,
//                price
//        );
//
//        if (flightOptional.isPresent()) {
//            flightService.save(flightOptional.get());
//            connectionService.save(connection);
//        }
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @ApiOperation(value = "Delete flight")
//    @Transactional
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {
//
//        if (!flightService.existsById(id)) {
//            throw new EntityNotExistsException("Flight with that id not exist!");
//        }
//
//        flightService.deleteConnection(id);
//        return ResponseEntity.ok(id);
//    }
//
//
//    @ExceptionHandler(EntityNotExistsException.class)
//    ResponseEntity<?> handleConnectionNotExistsException(EntityNotExistsException e) {
//        return ResponseEntity.notFound().build();
//    }
}