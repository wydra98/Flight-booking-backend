package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.User;
import flight_booking.backend.service.AirportService;
import flight_booking.backend.service.PassengerService;
import flight_booking.backend.service.TripService;
import flight_booking.backend.service.UserService;
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
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;
    private final PassengerService passengerService;
    private final AirportService airportService;
    private final TripMapper tripMapper;
    private final UserService userService;

    TripController(TripService tripService, PassengerService passengerService,
                   AirportService airportService, UserService userService) {
        this.tripService = tripService;
        this.passengerService = passengerService;
        this.airportService = airportService;
        this.userService = userService;
        this.tripMapper = new TripMapper();
    }

    @ApiOperation(value = "Get all user's trips", authorizations = {@Authorization(value = "authkey")})
    @GetMapping
    ResponseEntity<Set<TripDto>> getAllUsersTrips(@PathVariable Long id) {

        if (!userService.existsById(id)) {
            throw new NoSuchElementException("User with that id not exist!");
        }

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

        if (!airportService.existsById(srcAirportId) || !airportService.existsById(dstAirportId)) {
            throw new NoSuchElementException("Airport with that id not exist!");
        }

        if (srcAirportId.equals(dstAirportId)) {
            throw new IllegalStateException("Source and destination airport must be different.");
        }

        LocalDate departureDateParse = LocalDate.parse(departureDate);
        LocalDate arrivalDateParse = LocalDate.parse(arrivalDate);

        if (arrivalDateParse.isBefore(departureDateParse)) {
            throw new IllegalStateException("The date range is invalid.");
        }

        List<List<TripDto>> tripsFromTo = new ArrayList<>();
        List<Trip> tripsFrom;
        List<TripDto> tripsFromDto;
        List<Trip> tripsTo;
        List<TripDto> tripsToDto = new ArrayList<>();

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
    ResponseEntity<Trip> createChosenTrip(@RequestBody BookedTripDto bookedTripDto) {
        List<PassengerDto> passengersDto = bookedTripDto.getPassengersDto();
        TripDto tripDto = bookedTripDto.getTripDto();

        List<Passenger> passengers = new ArrayList<>();
        for (PassengerDto passengerDto : passengersDto) {

            if (passengerDto.getDateOfBirth().length() == 0 || passengerDto.getEmail().length() == 0 ||
                    passengerDto.getFirstName().length() == 0 || passengerDto.getPesel().length() == 0 ||
                    passengerDto.getPhoneNumber().length() == 0 || passengerDto.getSurname().length() == 0) {
                throw new IllegalStateException("The empty field is not allowed.");
            }

            Pattern pattern1 = Pattern.compile("^[\\p{L} .'-]+$");
            if (!pattern1.matcher(passengerDto.getFirstName()).matches() ||
                    !pattern1.matcher(passengerDto.getSurname()).matches()) {
                throw new IllegalStateException("The passenger first name or surname is invalid.");
            }

            if (passengerDto.getPhoneNumber().length() != 9 ||
                    passengerDto.getFirstName().length() < 2 ||
                    passengerDto.getSurname().length() < 2) {
                throw new IllegalStateException("The field's length is invalid.");
            }

            if (Period.between(LocalDate.parse(passengerDto.getDateOfBirth()), LocalDate.now()).getYears() < 2) {
                throw new IllegalStateException("The passenger age is invalid.");
            }

            PESELValidator peselValidator = new PESELValidator();
            peselValidator.initialize(null);

            if (!peselValidator.isValid(passengerDto.getPesel(), null)) {
                throw new IllegalStateException("The passenger pesel is invalid.");
            }

            if (!EmailValidator.getInstance().isValid(passengerDto.getEmail())) {
                throw new IllegalStateException("The passenger email is invalid.");
            }

            if (Period.between(LocalDate.parse(passengerDto.getDateOfBirth()), LocalDate.now()).getYears() < 2) {
                throw new IllegalStateException("The passenger age is invalid.");
            }

            Pattern pattern2 = Pattern.compile("^[0-9]{9}$");
            if (!pattern2.matcher(passengerDto.getPhoneNumber()).matches()) {
                throw new IllegalStateException("The passenger phone number is invalid.");
            }

            if (passengerService.checkIfPassengerExists(passengerDto.getPesel())) {
                passengers.add(passengerService.findPassenger(passengerDto.getPesel()));
            } else {
                passengers.add(passengerService.addNewPassenger(passengerDto));
            }
        }

        Trip trip = tripService.addNewTrip(passengers, tripDto);
        return ResponseEntity.created(URI.create("/" + trip.getCode())).body(trip);
    }


    @ApiOperation(value = "Delete trip through user", authorizations = {@Authorization(value = "authkey")})
    @Transactional
    @DeleteMapping("/deleteThroughUser/{id}")
    public ResponseEntity<Long> deleteTripThroughUser(@PathVariable Long id) {

        if (!tripService.existsById(id)) {
            throw new NoSuchElementException("Trip with that id not exist!");
        }

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

        if (!tripService.existsById(id)) {
            throw new NoSuchElementException("Trip with that id not exist!");
        }

        Optional<Trip> trip = tripService.findById(id);
        Set<Trip> trips = new HashSet<>();

        if (trip.isPresent()) {
            trips.add(trip.get());
            tripService.deleteTrips(trips);
        }

        return ResponseEntity.ok(id);
    }


    @ExceptionHandler(NoSuchElementException.class)
    ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(DateTimeParseException.class)
    ResponseEntity<String> handleDateTimeParseException(DateTimeParseException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
