package flight_booking.backend.services;


import flight_booking.backend.controllers.flight.FlightDto;
import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.controllers.ticket.TicketDto;
import flight_booking.backend.models.*;
import flight_booking.backend.controllers.trip.TripDto;

import flight_booking.backend.repository.TripRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.pl.PESELValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.*;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TicketService ticketService;
    private final FlightService flightService;
    private final UserService userService;
    private final SeatService seatService;
    private final AirportService airportService;

    TripService(TripRepository tripRepository,
                TicketService ticketService,
                FlightService flightService,
                UserService userService,
                SeatService seatService,
                AirportService airportService) {
        this.tripRepository = tripRepository;
        this.ticketService = ticketService;
        this.flightService = flightService;
        this.userService = userService;
        this.seatService = seatService;
        this.airportService = airportService;
    }

    public List<Trip> findAllAvailableTrips(Long srcAirportId, Long dstAirportId,
                                            LocalDate departureDate, int passengerNumber,
                                            int maxChanges, int maxTimeBetweenChanges) {

        return ticketService.findAllTrips(srcAirportId, dstAirportId, departureDate, passengerNumber, maxChanges, maxTimeBetweenChanges);
    }

    public Optional<Trip> findById(Long id) {
        return tripRepository.findById(id);
    }

    public boolean existsById(Long id) {

        return tripRepository.existsById(id);
    }

    public Set<Trip> findTripsByTickets(List<Ticket> tickets) {

        Set<Trip> trips = new HashSet<>();
        for (Ticket ticket : tickets) {
            Trip trip = ticket.getTrip();
            trips.add(trip);
        }
        return trips;
    }

    public void validateUsersId(Long id) {
        if (!userService.existsById(id)) {
            throw new NoSuchElementException("Taki użytkownik nie istnieje w bazie!");
        }
    }

    public List<Object> validateFindTrip(Long srcAirportId, Long dstAirportId,
                                         String departureDate, String arrivalDate,
                                         int passengerNumber, boolean twoTrip, int maxChanges,
                                         int maxTimeBetweenChanges) {

        List<Object> dates = new ArrayList<>();

        if (!airportService.existsById(srcAirportId) || !airportService.existsById(dstAirportId)) {
            throw new NoSuchElementException("Takie lotnisko nie istnieje w bazie.");
        }


        if (srcAirportId.equals(dstAirportId)) {
            throw new IllegalStateException("Lotniska muszą się różnić.");
        }

        if (passengerNumber < 0 || passengerNumber > 10) {
            throw new IllegalStateException("Nieprawidłowa liczba pasażerów.");
        }

        if (maxChanges < 0 || maxChanges > 4) {
            throw new IllegalStateException("Nieprawidłowa maksymalna liczba przesiadek.");
        }

        if (maxTimeBetweenChanges < 0 || maxTimeBetweenChanges > 12) {
            throw new IllegalStateException("Nieprawidłowa maksymalna godzina.");
        }

        LocalDate departureDateParse = LocalDate.parse(departureDate);
        LocalDate arrivalDateParse = null;

        if (!arrivalDate.equals("null")) {
            arrivalDateParse = LocalDate.parse(arrivalDate);

            if (arrivalDateParse.isBefore(departureDateParse)) {
                throw new IllegalStateException("Nieprawidłowy zakres dat.");
            }
        }

        if (!twoTrip && !arrivalDate.equals("null")) {
            throw new IllegalStateException("Nie można wybrać powrotnej daty i podróży w jedną stronę jednocześnie.");
        }

        dates.add(departureDateParse);
        dates.add(arrivalDateParse);

        return dates;
    }

    public void validateTripId(Long id) {
        if (!existsById(id)) {
            throw new NoSuchElementException("Taka podróż nie istnieje w bazie!");
        }
    }

    public void validateNewTrip(PassengerDto passengerDto, Long userId) {

        if (passengerDto.getDateOfBirth().length() == 0 || passengerDto.getEmail().length() == 0 ||
                passengerDto.getFirstName().length() == 0 || passengerDto.getPesel().length() == 0 ||
                passengerDto.getPhoneNumber().length() == 0 || passengerDto.getSurname().length() == 0) {
            throw new IllegalStateException("Puste pola są niedozwolone.");
        }

        Pattern pattern1 = Pattern.compile("^[\\p{L} .'-]+$");
        if (!pattern1.matcher(passengerDto.getFirstName()).matches() ||
                !pattern1.matcher(passengerDto.getSurname()).matches()) {
            throw new IllegalStateException("Imię lub nazwisko pasażera nieprawidłowe.");
        }

        if (passengerDto.getPhoneNumber().length() != 9 ||
                passengerDto.getFirstName().length() < 2 ||
                passengerDto.getSurname().length() < 2) {
            throw new IllegalStateException("Długość pola nieprawidłowa.");
        }

        if (Period.between(LocalDate.parse(passengerDto.getDateOfBirth()), LocalDate.now()).getYears() < 2) {
            throw new IllegalStateException("Nieprawidłowy wiek pasażera.");
        }

        PESELValidator peselValidator = new PESELValidator();
        peselValidator.initialize(null);

        if (!peselValidator.isValid(passengerDto.getPesel(), null)) {
            throw new IllegalStateException("Nieprawidłowy pesel pasażera.");
        }

        if (!EmailValidator.getInstance().isValid(passengerDto.getEmail())) {
            throw new IllegalStateException("Nieprawidłowy email pasażera.");
        }

        if (Period.between(LocalDate.parse(passengerDto.getDateOfBirth()), LocalDate.now()).getYears() < 2) {
            throw new IllegalStateException("Nieprawidłowy wiek pasażera.");
        }

        Pattern pattern2 = Pattern.compile("^[0-9]{9}$");
        if (!pattern2.matcher(passengerDto.getPhoneNumber()).matches()) {
            throw new IllegalStateException("Nieprawidłowy numer telefonu pasażera.");
        }

        if (Period.between(LocalDate.parse(passengerDto.getDateOfBirth()), LocalDate.now()).getYears() < 2) {
            throw new IllegalStateException("Rezerwować loty można tylko dla pasażerów powyżej 2 roku życia.");
        }

        if (!userService.existsById(userId)) {
            throw new NoSuchElementException("Taki użytkownik nie istnieje w bazie!");
        }
    }

    public Trip addNewTrip(List<Passenger> passengers, TripDto tripDto, Long userId) {
        boolean flag = true;
        Optional<User> user = userService.findById(userId);
        Trip trip = null;
        if (user.isPresent()) {
            trip = tripRepository.save(Trip.builder()
                    .user(user.get())
                    .tickets(new ArrayList<>())
                    .departureDate(LocalDate.parse(tripDto.getDepartureDate()))
                    .departureTime(LocalTime.parse(tripDto.getDepartureTime()))
                    .arrivalDate(LocalDate.parse(tripDto.getArrivalDate()))
                    .arrivalTime(LocalTime.parse(tripDto.getArrivalTime()))
                    .purchaseDate(LocalDate.now())
                    .purchaseTime(LocalTime.now())
                    .price(tripDto.getTotalPrice())
                    .build());
        }

        for (TicketDto ticketDto : tripDto.getArraysTicket()) {
            FlightDto flightDto = ticketDto.getFlightDto();
            Optional<Flight> flight = flightService.findById(flightDto.getId());

            if (flight.isPresent()) {

                for (Passenger passenger : passengers) {
                    flight.get().setAvailableSeats(flight.get().getAvailableSeats() - 1);

                    int numberSeat = 0;
                    List<Integer> seats = seatService.findAllBusySeat(flight.get());

                    do {
                        numberSeat = generateSeatNumber(flight.get().getNumberSeats());
                    }
                    while (checkIfNumberSeatIsCorrectAndFree(seats, numberSeat, flight.get()));


                    flight.get().addSeat(Seat.builder()
                            .seatNumber(numberSeat)
                            .flight(flight.get())
                            .build());
                    flightService.save(flight.get());

                    Period period = Period.between(passenger.getDateOfBirth(), LocalDate.now());
                    double price = 0;
                    if (period.getYears() < 18) {
                        price = flight.get().getPrice() * 0.8;
                    } else {
                        price = flight.get().getPrice();
                    }

                    Ticket ticket = ticketService.save(Ticket.builder()
                            .passenger(passenger)
                            .flight(flight.get())
                            .trip(trip)
                            .seatNumber(generateSeatNumber(flight.get().getNumberSeats()))
                            .price(price)
                            .build());

                    if (trip != null) {
                        trip.addTicket(ticket);
                        trip.setPassenger(passenger);
                    }
                }

            } else {
                flag = false;
                break;
            }
        }

        Trip actualTrip = null;
        if (flag) {
            if (trip != null) {
                actualTrip = tripRepository.save(trip);
            }

            if(user.isPresent()){
                user.get().addTrip(actualTrip);
                userService.save(user.get());
            }
        }
        return actualTrip;
    }

    private int generateSeatNumber(int seatNumbers) {

        Random random = new Random();
        return random.nextInt(seatNumbers) + 1;
    }

    private boolean checkIfNumberSeatIsCorrectAndFree(List<Integer> seatsNumber, int numberSeat, Flight flight) {

        boolean flag = true;

        if (numberSeat > flight.getNumberSeats() || numberSeat < 1|| seatsNumber.size() == 0) {
            flag = false;
        }

        if (flag) {
            for (Integer seatNumber : seatsNumber) {
                if (seatNumber == numberSeat) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }

    public void deleteTrips(Set<Trip> trips) {

        for (Trip trip : trips) {
            ticketService.deleteTickets(trip.getTickets());
            tripRepository.deleteById(trip.getId());
        }
    }

    public void deleteTripsWithTimeLimit(Trip trip) {
        LocalDateTime departureTime = LocalDateTime.of(trip.getDepartureDate(), trip.getDepartureTime());
        LocalDateTime currentTime = LocalDateTime.now();
        long hours = Duration.between(currentTime, departureTime).toHours();
        if (currentTime.isAfter(departureTime) || currentTime.isEqual(departureTime) || hours < 24) {
            throw new IllegalStateException("Użytkownik nie może anulować rezerwacji 24h przed odlotem.");
        }

        if (currentTime.isAfter(departureTime) || currentTime.isEqual(departureTime)) {
            throw new IllegalStateException("Podróż jest zarchiwizowana.");
        }

        if (hours < 24) {
            throw new IllegalStateException("Użytkownik nie może anulować rezerwacji 24h przed odlotem.");
        }

        ticketService.deleteTickets(trip.getTickets());
        tripRepository.deleteById(trip.getId());
    }
}
