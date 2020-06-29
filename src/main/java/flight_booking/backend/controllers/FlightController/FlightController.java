package flight_booking.backend.controllers.FlightController;
//
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/flights")
//public class FlightController {
//
//    @ApiOperation(value = "Return list of trips that match given params")
//    @GetMapping
//    List<TripDto> getTrips(
//            @RequestParam boolean oneWay,
//            @RequestParam String from,
//            @RequestParam String to,
//            @RequestParam String departureDate,
//            @RequestParam String arrivalDate,
//            @RequestParam int passengerNumber,
//            @RequestParam String tripClass
//    ) {
//
//        // @TODO: implement searching trips based on query params
//        List<TripDto> offers = new ArrayList<TripDto>();
//        offers.add(new TripDto());
//
//        return offers;
//    }
//
//    @ApiOperation(value = "Takes chosen trip and book")
//    @PostMapping
//    TripDto requestBooking(
//            @RequestParam int tripId,
//            @RequestBody TripDto tripDto) {
//        // @TODO: implement booking mechanism
//
//        return tripDto;
//    }
//
//    @PatchMapping("/{id}")
//    TripDto editBooking(@PathVariable int tripId, @RequestBody TripDto changedTrip) {
//        // @TODO: implement editing existing trip
//
//        return changedTrip;
//    }
//
//    @DeleteMapping("/{id}")
//    void editBooking(@PathVariable int tripId) {
//        // @TODO: implement deleting existing trip
//    }
//}

import flight_booking.backend.controllers.AirlineController.AirlineDto;
import flight_booking.backend.controllers.AirportController.AirportDto;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Flight.FlightRepository;
import flight_booking.backend.service.AirlineService;
import flight_booking.backend.service.AirportService;
import flight_booking.backend.service.ConnectionService;
import flight_booking.backend.service.FlightService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/connections")
public class FlightController {

    private final ConnectionService connectionService;
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    FlightController(ConnectionService connectionService, FlightService flightService) {
        this.connectionService = connectionService;
        this.flightService = flightService;
        this.flightMapper = new FlightMapper();
    }

    @ApiOperation(value = "Get all flights")
    @GetMapping
    ResponseEntity<List<FlightDto>> getAllFlights() {
        List<Flight> flights = flightService.findAll();

        ArrayList<FlightDto> flightDtos = new ArrayList<>();
        for (Flight flight : flights) {
            Connection connection = flightService.findConnection(flight.getId());
            System.out.println(connection);
            flightDtos.add(flightMapper.map(flight, connection));
        }
        return ResponseEntity.ok(flightDtos);
    }

    //TODO read about twice @Requestbody in arguments of one function
    @ApiOperation(value = "Add new flight")
    @PostMapping
    ResponseEntity<Flight> addNewConnection(@RequestParam Long airlineDtoId,
                                            @RequestParam int numberSeats,
                                            @RequestParam double price,
                                            @RequestParam Long srcAirportId,
                                            @RequestParam Long dstAirportId,
                                            @RequestParam String departureDate,
                                            @RequestParam String departureTime,
                                            @RequestParam String arrivalDate,
                                            @RequestParam String arrivalTime) {

        Connection connection = connectionService.addNewConnection(srcAirportId, dstAirportId, departureDate,
                departureTime, arrivalDate, arrivalTime);
        Flight flight = flightService.addNewFlight(airlineDtoId, numberSeats, price, connection);
        return ResponseEntity.created(URI.create("/" + flight.getId())).body(flight);

    }
}

//    @ApiOperation(value = "Update connection")
//    @Transactional
//    @PutMapping
//    ResponseEntity<Void> updateConnection(@RequestBody ConnectionDto connectionDto) {
//
//        if (!connectionService.existsById(connectionDto.getId())) {
//            throw new ConnectionNotExistsException("Connection with that id not exist!");
//        }
//
//        Optional<Connection> connectionOptional = connectionService.findById(connectionDto.getId());
//        Optional<Airline> airline = airlineService.findById(connectionDto.getAirlineDto().getId());
//        Optional<Airport> srcAirport = airportService.findById(connectionDto.getSrcAirportDto().getId());
//        Optional<Airport> dstAirport  = airportService.findById(connectionDto.getDstAirportDto().getId());
//
//        connectionOptional.get().updateForm(connectionDto.getId(),
//                srcAirport.get(),
//                dstAirport.get(),
//                airline.get(),
//                connectionDto.getNumberSeats(),
//                connectionDto.getArrivalDate(),
//                connectionDto.getArrivalTime(),
//                connectionDto.getDepartureDate(),
//                connectionDto.getDepartureTime(),
//                connectionDto.getPrice());
//        connectionService.save(connectionOptional.get());
//
//        return ResponseEntity.noContent().build();
//    }
//
//    @ApiOperation(value = "Delete connection")
//    @Transactional
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Long> deleteConnection(@PathVariable Long id) {
//
//        if (!connectionService.existsById(id)) {
//            throw new ConnectionNotExistsException("Connection with that id not exist!");
//        }
//
//        connectionService.deleteConnection(id);
//        return ResponseEntity.ok(id);
//    }
//
//
//    @ExceptionHandler(ConnectionNotExistsException.class)
//    ResponseEntity<?> handleConnectionNotExistsException(ConnectionNotExistsException e) {
//        return ResponseEntity.notFound().build();
//    }
//}