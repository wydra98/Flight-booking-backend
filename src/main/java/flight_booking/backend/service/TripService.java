package flight_booking.backend.service;


import flight_booking.backend.models.Airports.AirportRepository;
import flight_booking.backend.models.Trips.Trip;
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

    public List<Trip> findAllAvailableTrips(Long srcAirportId, Long dstAirportId, String departureDateString) {

        //Airport srcAirport = airportRepository.findById(srcAirportId).get();
        //Airport dstAirport = airportRepository.findById(dstAirportId).get();
        LocalDate departureDate = LocalDate.parse(departureDateString);

        List<Trip> listOfTrip = ticketService.findAllTrips(srcAirportId, dstAirportId, departureDate);
        List<Trip> trips = mapTicketToFlight(listOfTrip);
        return trips;
    }

    public List<Trip> mapTicketToFlight(List<Trip> listOfTrips) {


        return listOfTrips;
    }
}
