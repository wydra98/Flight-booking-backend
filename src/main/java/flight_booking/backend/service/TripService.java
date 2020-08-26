package flight_booking.backend.service;


import flight_booking.backend.models.Airports.AirportRepository;
import flight_booking.backend.models.Trips.Trip;
import flight_booking.backend.models.Passengers.Passenger;
import flight_booking.backend.controllers.TripController.TripDto;

import flight_booking.backend.models.Trips.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TicketService ticketService;
    private final AirportRepository airportRepository;

    TripService(TripRepository tripRepository,
                TicketService ticketService,
                AirportRepository airportRepository) {
        this.tripRepository = tripRepository;
        this.ticketService = ticketService;
        this.airportRepository = airportRepository;
    }

//    public List<Trip> findAllTripsFromUserId(Long id) {
//        List<Trip> trips = tripRepository.findAllTripFromUserId(id);
//
//        return trips;
//    }

    public List<Trip> findAllAvailableTrips(Long srcAirportId, Long dstAirportId,
                                            LocalDate departureDate, LocalDate arrivalDate,
                                            int maxChange, int maxTimeBreak) {

        return ticketService.findAllTrips(srcAirportId, dstAirportId,
                departureDate, arrivalDate, maxChange, maxTimeBreak);
    }

    public Trip addNewTrip(Passenger passenger, TripDto tripDto){

        Trip trip = null;
        return trip;
    }
}
