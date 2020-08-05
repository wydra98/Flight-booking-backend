package flight_booking.backend.controllers.TripController;

import flight_booking.backend.controllers.TicketController.TicketDto;
import flight_booking.backend.controllers.TicketController.TicketMapper;
import flight_booking.backend.models.Ticket.Ticket;
import flight_booking.backend.models.Trips.Trip;
import flight_booking.backend.service.TicketService;
import flight_booking.backend.service.TripService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation(value = "Get all user's trips")
    @GetMapping("/{id}")
    ResponseEntity<List<TripDto>> getAllUsersTrips(@PathVariable Long id) {

        List<Trip> trips = tripService.findAllTripsFromUserId(id);
        System.out.println(trips.size());

        ArrayList<TripDto> tripsDtos = new ArrayList<>();
        for (Trip trip : trips) {
            tripsDtos.add(tripMapper.map(trip));
        }
        return ResponseEntity.ok(tripsDtos);
    }
}
