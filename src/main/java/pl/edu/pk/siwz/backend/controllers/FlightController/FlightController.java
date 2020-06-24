package pl.edu.pk.siwz.backend.controllers.FlightController;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @ApiOperation(value = "Return list of trips that match given params")
    @GetMapping
    List<TripDto> getTrips(
            @RequestParam boolean oneWay,
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam String departureDate,
            @RequestParam String arrivalDate,
            @RequestParam int passengerNumber,
            @RequestParam String tripClass
    ) {

        // @TODO: implement searching trips based on query params
        List<TripDto> offers = new ArrayList<TripDto>();
        offers.add(new TripDto());

        return offers;
    }

    @ApiOperation(value = "Takes chosen trip and book")
    @PostMapping
    TripDto requestBooking(
            @RequestParam int tripId,
            @RequestBody TripDto tripDto) {
        // @TODO: implement booking mechanism

        return tripDto;
    }

    @PatchMapping("/{id}")
    TripDto editBooking(@PathVariable int tripId, @RequestBody TripDto changedTrip) {
        // @TODO: implement editing existing trip

        return changedTrip;
    }

    @DeleteMapping("/{id}")
    void editBooking(@PathVariable int tripId) {
        // @TODO: implement deleting existing trip
    }
}
