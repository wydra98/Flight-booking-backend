package flight_booking.backend.service;


import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Airport.AirportRepository;
import flight_booking.backend.models.Ticket.Ticket;
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

    public List<Trip> findAllAvailableTrips(Long srcAirportId, Long dstAirportId, String departureDateString, String departureTimeString) {

        //Airport srcAirport = airportRepository.findById(srcAirportId).get();
        //Airport dstAirport = airportRepository.findById(dstAirportId).get();
        LocalDate departureDate = LocalDate.parse(departureDateString);
        LocalTime departureTime = LocalTime.parse(departureTimeString);

        List<List<Ticket>> listOfTicket = ticketService.findAllListOfTicket(srcAirportId, dstAirportId, departureDate, departureTime);
        List<Trip> trips = mapTicketToFlight(listOfTicket);
        return trips;
    }

    public List<Trip> mapTicketToFlight(List<List<Ticket>> listOfTicket) {

        List<Trip> trips = null;
        return trips;
    }
}
