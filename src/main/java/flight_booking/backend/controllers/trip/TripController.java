package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.controllers.airport.AirportDto;
import flight_booking.backend.controllers.airport.AirportMapper;
import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.User;
import flight_booking.backend.services.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.time.LocalDate;
import java.util.*;

@RestController
@ExceptionProcessing
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;
    private final AirportService airportService;
    private final PassengerService passengerService;
    private final UserService userService;
    private final TripMapper tripMapper;
    private final AirportMapper airportMapper;


    TripController(TripService tripService, PassengerService passengerService,
                   UserService userService, AirportService airportService) {
        this.tripService = tripService;
        this.passengerService = passengerService;
        this.userService = userService;
        this.airportService = airportService;
        this.tripMapper = new TripMapper();
        this.airportMapper = new AirportMapper();
    }

    @ApiOperation(value = "Get all user's trips", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping
    ResponseEntity<Set<TripDto>> getAllUsersTrips(@PathVariable Long id) {

        tripService.validateUsersId(id);
        Optional<User> user = userService.findById(id);

        Set<TripDto> tripsDtos = new HashSet<>();
        if (user.isPresent()) {
            for (Trip trip : user.get().getTrips()) {
                tripsDtos.add(tripMapper.map(trip, Optional.empty() , Optional.empty()));
            }
        }

        return ResponseEntity.ok(tripsDtos);
    }

    @ApiOperation(value = "Find proper trips", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @GetMapping("/findTrips")
    ResponseEntity<List<List<TripDto>>> findTrips(@RequestParam Long srcAirportId,
                                                  @RequestParam Long dstAirportId,
                                                  @RequestParam String firstChangeId,
                                                  @RequestParam String secondChangeId,
                                                  @RequestParam String departureDate,
                                                  @RequestParam String arrivalDate,
                                                  @RequestParam int passengerNumber,
                                                  @RequestParam boolean twoTrip) {

        List<Object> dates = tripService.validateFindTrip(srcAirportId, dstAirportId, departureDate, arrivalDate, passengerNumber, twoTrip);

        LocalDate departureDateParse = LocalDate.parse(dates.get(0).toString());
        LocalDate arrivalDateParse = null;
        if(dates.get(1)!=null){
            arrivalDateParse = LocalDate.parse(dates.get(1).toString());
        }

        Optional<AirportDto> firstChangeAirportDto = Optional.empty();
        Optional<AirportDto> secondChangeAirportDto = Optional.empty();

        if(!firstChangeId.equals("null")){
            Optional<Airport> firstAirport = airportService.findById(Long.parseLong(firstChangeId));
            if(firstAirport.isPresent()){
                firstChangeAirportDto = Optional.of(airportMapper.map(firstAirport.get()));
            }
        }

        if(!secondChangeId.equals("null")){
            Optional<Airport> secondAirport = airportService.findById(Long.parseLong(secondChangeId));
            if(secondAirport.isPresent()){
                secondChangeAirportDto = Optional.of(airportMapper.map(secondAirport.get()));
            }
        }

        List<List<TripDto>> tripsFromTo = new ArrayList<>();
        List<Trip> tripsFrom;
        List<TripDto> tripsFromDto;
        List<Trip> tripsTo;
        List<TripDto> tripsToDto = new ArrayList<>();

        tripsFrom = tripService.findAllAvailableTrips(srcAirportId, dstAirportId, departureDateParse, passengerNumber);

        tripsFromDto = new ArrayList<>();
        for (Trip trip : tripsFrom) {
            tripsFromDto.add(tripMapper.map(trip, firstChangeAirportDto, secondChangeAirportDto));
        }
        tripsFromTo.add(tripsFromDto);

        if (twoTrip) {
            tripsTo = tripService.findAllAvailableTrips(dstAirportId, srcAirportId, arrivalDateParse, passengerNumber);

            tripsToDto = new ArrayList<>();
            for (Trip trip : tripsTo) {
                tripsToDto.add(tripMapper.map(trip, firstChangeAirportDto, secondChangeAirportDto));
            }
        }
        tripsFromTo.add(tripsToDto);

        tripsFromTo.get(0).sort(Comparator.comparing(TripDto::getTotalPrice));
        tripsFromTo.get(1).sort(Comparator.comparing(TripDto::getTotalPrice));
        tripsFromTo.get(0).sort(Comparator.comparing(TripDto::isNormalOffer));
        tripsFromTo.get(1).sort(Comparator.comparing(TripDto::isNormalOffer));


        return ResponseEntity.ok(tripsFromTo);
    }

    @ApiOperation(value = "Create new trip for user", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @PostMapping("/createTrip")
    ResponseEntity<Long> createChosenTrip(@RequestBody BookedTripDto bookedTripDto) {

        List<PassengerDto> passengersDto = bookedTripDto.getPassengersDto();
        TripDto tripDto = bookedTripDto.getTripDto();
        Long userId = bookedTripDto.getUserId();

        List<Passenger> passengers = new ArrayList<>();
        for (PassengerDto passengerDto : passengersDto) {

            tripService.validateNewTrip(passengerDto, userId);

            if (passengerService.checkIfPassengerExists(passengerDto.getPesel())) {
                passengers.add(passengerService.findPassenger(passengerDto.getPesel()));
            } else {
                passengers.add(passengerService.addNewPassenger(passengerDto));
            }
        }

        Trip trip = tripService.addNewTrip(passengers, tripDto, userId);
        return ResponseEntity.ok(trip.getId());
    }

    @ApiOperation(value = "Delete trip through user", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/deleteThroughUser/{id}")
    public ResponseEntity<Long> deleteTripThroughUser(@PathVariable Long id) {

        tripService.validateTripId(id);
        Optional<Trip> trip = tripService.findById(id);

        if (trip.isPresent()) {
            tripService.deleteTripsWithTimeLimit(trip.get());
        }

        return ResponseEntity.ok(id);
    }

    @ApiOperation(value = "Delete trip through admin", authorizations = {@Authorization(value = "authkey")})
    @CrossOrigin(origins = "*")
    @Transactional
    @DeleteMapping("/deleteThroughAdmin/{id}")
    public ResponseEntity<Long> deleteTripThroughAdmin(@PathVariable Long id) {

        tripService.validateTripId(id);
        Optional<Trip> trip = tripService.findById(id);
        Set<Trip> trips = new HashSet<>();

        if (trip.isPresent()) {
            trips.add(trip.get());
            tripService.deleteTrips(trips);
        }

        return ResponseEntity.ok(id);
    }
}
