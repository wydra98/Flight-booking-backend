package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.models.Trip;
import flight_booking.backend.service.PassengerService;
import flight_booking.backend.service.TripService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;
    private final TripMapper tripMapper;
    private final PassengerService passengerService;

    TripController(TripService tripService, PassengerService passengerService) {
        this.tripService = tripService;
        this.passengerService = passengerService;
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
    @GetMapping("/findTrips")
    ResponseEntity<List<TripDto>> findTrips(@RequestParam Long srcAirportId,
                                            @RequestParam Long dstAirportId,
                                            @RequestParam String minDepartureDate,
                                            @RequestParam String maxDepartureDate,
                                            @RequestParam int maxChange,
                                            @RequestParam int maxTimeBreak) {

        //@TODO check if srcAirportId is correct
        //@TODO check if dstAirportId is correct
        //@TODO how to check if arrivalDate is correct?? :O:O:O:O:O:O:O:O:O

        LocalDate minDepartureDateParse = LocalDate.parse(minDepartureDate);
        LocalDate maxDepartureDateParse = LocalDate.parse(maxDepartureDate);

        List<Trip> trips = tripService.findAllAvailableTrips(srcAirportId, dstAirportId, minDepartureDateParse,
                maxDepartureDateParse, maxChange, maxTimeBreak);
       // System.out.println(trips.size());

        ArrayList<TripDto> tripsDtos = new ArrayList<>();
        for (Trip trip : trips) {
            tripsDtos.add(tripMapper.map(trip));
        }

        return ResponseEntity.ok(tripsDtos);
    }



    @ApiOperation(value = "Create new trip for user")
    @GetMapping("/createTrip")
    ResponseEntity<Trip> createChosenTrip(@RequestParam TripDto tripDto,
                                          @RequestParam PassengerDto passengerDto) {

        Passenger passenger;
        if (passengerService.checkIfPassengerExists(passengerDto.getPesel())) {
            passenger = passengerService.findPassenger(passengerDto.getPesel());
        }
        else{
            passenger = passengerService.addNewPassenger(passengerDto);
        }

        Trip trip = tripService.addNewTrip(passenger,tripDto);

        return ResponseEntity.created(URI.create("/" + trip.getCode())).body(trip);
    }

    @ApiOperation(value = "Get user trip from code")
    @GetMapping("/findOneTrip")
    ResponseEntity<TripDto> createChosenTrip(@RequestParam String code) {

        Trip trip = tripService.findTripByCode(code);

        TripDto tripDto = tripMapper.map(trip);

        return ResponseEntity.ok(tripDto);
    }
}
