package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.ExceptionProcessing;
import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.User;
import flight_booking.backend.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Pattern;

@RestController
@ExceptionProcessing
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;
    private final PassengerService passengerService;
    private final UserService userService;
    private final TripMapper tripMapper;


    TripController(TripService tripService, PassengerService passengerService,
                   UserService userService) {
        this.tripService = tripService;
        this.passengerService = passengerService;
        this.userService = userService;
        this.tripMapper = new TripMapper();
    }

    @ApiOperation(value = "Get all user's trips", authorizations = {@Authorization(value = "authkey")})
    @GetMapping
    ResponseEntity<Set<TripDto>> getAllUsersTrips(@PathVariable Long id) {

        tripService.validateUsersId(id);
        Optional<User> user = userService.findById(id);

        Set<TripDto> tripsDtos = new HashSet<>();
        if (user.isPresent()) {
            for (Trip trip : user.get().getTrips()) {
                tripsDtos.add(tripMapper.map(trip));
            }
        }

        return ResponseEntity.ok(tripsDtos);
    }

    @ApiOperation(value = "Find proper trips", authorizations = {@Authorization(value = "authkey")})
    @GetMapping("/findTrips")
    ResponseEntity<List<List<TripDto>>> findTrips(@RequestParam Long srcAirportId,
                                                  @RequestParam Long dstAirportId,
                                                  @RequestParam String departureDate,
                                                  @RequestParam String arrivalDate,
                                                  @RequestParam int passengerNumber,
                                                  @RequestParam boolean twoTrip) {

        List<LocalDate> dates = tripService.validateFindTrip(srcAirportId, dstAirportId, departureDate, arrivalDate, passengerNumber);

        List<List<TripDto>> tripsFromTo = new ArrayList<>();
        List<Trip> tripsFrom;
        List<TripDto> tripsFromDto;
        List<Trip> tripsTo;
        List<TripDto> tripsToDto = new ArrayList<>();

        LocalDate departureDateParse = dates.get(0);
        LocalDate arrivalDateParse = dates.get(1);
        tripsFrom = tripService.findAllAvailableTrips(srcAirportId, dstAirportId, departureDateParse, passengerNumber);

        tripsFromDto = new ArrayList<>();
        for (Trip trip : tripsFrom) {
            tripsFromDto.add(tripMapper.map(trip));
        }
        tripsFromTo.add(tripsFromDto);

        if (twoTrip) {
            tripsTo = tripService.findAllAvailableTrips(dstAirportId, srcAirportId, arrivalDateParse, passengerNumber);

            tripsToDto = new ArrayList<>();
            for (Trip trip : tripsTo) {
                tripsToDto.add(tripMapper.map(trip));
            }
        }
        tripsFromTo.add(tripsToDto);

        return ResponseEntity.ok(tripsFromTo);
    }

    @ApiOperation(value = "Create new trip for user", authorizations = {@Authorization(value = "authkey")})
    @PostMapping("/createTrip")
    ResponseEntity<Trip> createChosenTrip(@RequestBody BookedTripDto bookedTripDto,
                                          @RequestParam Long userId) {

        List<PassengerDto> passengersDto = bookedTripDto.getPassengersDto();
        TripDto tripDto = bookedTripDto.getTripDto();

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
        return ResponseEntity.created(URI.create("/" + trip.getCode())).body(trip);
    }

    @ApiOperation(value = "Delete trip through user", authorizations = {@Authorization(value = "authkey")})
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
