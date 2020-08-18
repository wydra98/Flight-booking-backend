package flight_booking.backend.controllers.TripController;

import flight_booking.backend.models.Trips.Trip;
import flight_booking.backend.service.TripService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;
    private final TripMapper tripMapper;

    TripController(TripService tripService) {
        this.tripService = tripService;
        this.tripMapper = new TripMapper();
    }

//    @ApiOperation(value = "Get all user's trips")
//    @GetMapping("/{id}")
//    ResponseEntity<List<TripDto>> getAllUsersTrips(@PathVariable Long id) {
//
//        List<Trip> trips = tripService.findAllTripsFromUserId(id);
//        System.out.println(trips.size());
//
//        ArrayList<TripDto> tripsDtos = new ArrayList<>();
//        for (Trip trip : trips) {
//            tripsDtos.add(tripMapper.map(trip));
//        }
//        return ResponseEntity.ok(tripsDtos);
//    }

    @ApiOperation(value = "Find proper trips")
    @GetMapping("/findTrips/{id}")
    ResponseEntity<List<TripDto>> findTrips(@RequestParam Long srcAirportId,
                                            @RequestParam Long dstAirportId,
                                            @RequestParam String departureDate,
                                            @RequestParam String departureTime) {

        //@TODO check if srcAirportId is correct
        //@TODO check if dstAirportId is correct
        //@TODO how to check if arrivalDate is correct?? :O:O:O:O:O:O:O:O:O

        List<Trip> trips = tripService.findAllAvailableTrips(srcAirportId, dstAirportId, departureDate, departureTime);
        System.out.println(trips.size());

        ArrayList<TripDto> tripsDtos = new ArrayList<>();
        for (Trip trip : trips) {
            tripsDtos.add(tripMapper.map(trip));
        }

        return ResponseEntity.ok(tripsDtos);
    }

//    @ApiOperation(value = "Find all connection")
//    @GetMapping("/findTestConnections/{id}")
//    ResponseEntity<List<TripDto>> findTrips(@RequestParam Long srcAirportId,
//                                            @RequestParam Long dstAirportId) {
//
//        //@TODO check if srcAirportId is correct
//        //@TODO check if dstAirportId is correct
//        //@TODO how to check if arrivalDate is correct?? :O:O:O:O:O:O:O:O:O
//
//        List<Connection> trips = tripService.findAllAvailableTrips(srcAirportId, dstAirportId);
//        System.out.println(trips.size());
//
//        ArrayList<TripDto> tripsDtos = new ArrayList<>();
//        for (Trip trip : trips) {
//            tripsDtos.add(tripMapper.map(trip));
//        }
//
//
//
//
//        return ResponseEntity.ok(tripsDtos);
//    }
}
