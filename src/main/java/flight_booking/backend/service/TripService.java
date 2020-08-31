package flight_booking.backend.service;


import flight_booking.backend.controllers.flight.FlightDto;
import flight_booking.backend.controllers.ticket.TicketDto;
import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Ticket;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.Passenger;
import flight_booking.backend.controllers.trip.TripDto;

import flight_booking.backend.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TicketService ticketService;
    private final FlightService flightService;

    TripService(TripRepository tripRepository,
                TicketService ticketService,
                FlightService flightService) {
        this.tripRepository = tripRepository;
        this.ticketService = ticketService;
        this.flightService = flightService;
    }

//    public List<Trip> findAllTripsFromUserId(Long id) {
//        List<Trip> trips = tripRepository.findAllTripFromUserId(id);
//
//        return trips;
//    }

    public List<Trip> findAllAvailableTrips(Long srcAirportId, Long dstAirportId,
                                            LocalDate departureDate, int passengerNumber) {

        return ticketService.findAllTrips(srcAirportId, dstAirportId, departureDate, passengerNumber);
    }

    public Trip addNewTrip(Passenger passenger, TripDto tripDto) {

        String uniqueID = UUID.randomUUID().toString();

        Trip trip = tripRepository.save(Trip.builder()
                .code(uniqueID)
                .tickets(null)
                .departureDate(LocalDate.parse(tripDto.getDepartureDate()))
                .departureTime(LocalTime.parse(tripDto.getDepartureTime()))
                .arrivalDate(LocalDate.parse(tripDto.getArrivalDate()))
                .arrivalTime(LocalTime.parse(tripDto.getArrivalTime()))
                .purchaseDate(LocalDate.now())
                .purchaseTime(LocalTime.now())
                .price(tripDto.getTotalPrice())
                .build());

        for (TicketDto ticketDto: tripDto.getArraysTicket()) {
            FlightDto flightDto = ticketDto.getFlightDto();
            Optional<Flight> flight = flightService.findById(flightDto.getId());

            Ticket ticket = ticketService.save(Ticket.builder()
                    .passenger(passenger)
                    .flight(flight.get())
                    .trip(trip)
                    .seatNumber(generateSeatNumber(flight.get().getNumberSeats()))
                    .price(flight.get().getPrice())
                    .build());


            trip.addTicket(ticket);
        }
        Trip actualTrip = tripRepository.save(trip);

        return actualTrip;
    }

    private int generateSeatNumber(int seatNumbers){

        Random random = new Random();
        return random.nextInt(seatNumbers) + 1;
    }

    public Trip findTripByCode(String code){
        Trip trip = tripRepository.findTripByCode(code);
        return trip;
    }
}
