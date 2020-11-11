package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.airport.AirportDto;
import flight_booking.backend.controllers.airport.AirportMapper;
import flight_booking.backend.controllers.ticket.TicketDto;
import flight_booking.backend.controllers.ticket.TicketMapper;
import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Ticket;
import flight_booking.backend.models.Trip;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class TripMapper {

    public TripDto map(Trip trip, Optional<AirportDto> firstAirport, Optional<AirportDto> secondAirport, Optional<AirportDto> thirdAirport, Optional<AirportDto> fourthAirport) {

        TicketMapper ticketMapper = new TicketMapper();
        boolean bestOffer = true;

        ArrayList<TicketDto> ticketDtos = new ArrayList<>();
        for (Ticket ticket : trip.getTickets()) {
            ticketDtos.add(ticketMapper.map(ticket));
        }

        bestOffer = checkIfBestOffer(ticketDtos, firstAirport, secondAirport, thirdAirport, fourthAirport);

        TripDto tripDto = null;

        if (trip.getPurchaseDate() == null || trip.getPurchaseTime() == null) {
            tripDto = TripDto.builder()
                    .arraysTicket(ticketDtos)
                    .departureDate(trip.getDepartureDate().toString())
                    .departureTime(trip.getDepartureTime().toString())
                    .arrivalDate(trip.getArrivalDate().toString())
                    .arrivalTime(trip.getArrivalTime().toString())
                    .totalPrice(trip.getPrice())
                    .normalOffer(bestOffer)
                    .build();
        } else {
            tripDto = TripDto.builder()
                    .arraysTicket(ticketDtos)
                    .departureDate(trip.getDepartureDate().toString())
                    .departureTime(trip.getDepartureTime().toString())
                    .arrivalDate(trip.getArrivalDate().toString())
                    .arrivalTime(trip.getArrivalTime().toString())
                    .purchaseDate(trip.getPurchaseDate().toString())
                    .purchaseTime(trip.getPurchaseTime().toString())
                    .totalPrice(trip.getPrice())
                    .normalOffer(bestOffer)
                    .build();
        }

        return tripDto;
    }

    private boolean checkIfBestOffer(ArrayList<TicketDto> ticketsDto, Optional<AirportDto> firstAirport, Optional<AirportDto> secondAirport,
                                     Optional<AirportDto> thirdAirport, Optional<AirportDto> fourthAirport) {

        if (ticketsDto.size() == 1) {
            return true;
        } else {
            if (firstAirport.isPresent()) {
                if (ticketsDto.get(0).getFlightDto().getDstAirport().equals(firstAirport.get())) {
                    return false;
                }

                if (ticketsDto.get(ticketsDto.size() - 1).getFlightDto().getSrcAirport().equals(firstAirport.get())) {
                    return false;
                }
            }

            if (secondAirport.isPresent()) {
                if (ticketsDto.get(0).getFlightDto().getDstAirport().equals(secondAirport.get())) {
                    return false;
                }

                if (ticketsDto.get(ticketsDto.size() - 1).getFlightDto().getSrcAirport().equals(secondAirport.get())) {
                    return false;
                }
            }

            if (thirdAirport.isPresent()) {
                if (ticketsDto.get(0).getFlightDto().getDstAirport().equals(thirdAirport.get())) {
                    return false;
                }

                if (ticketsDto.get(ticketsDto.size() - 1).getFlightDto().getSrcAirport().equals(thirdAirport.get())) {
                    return false;
                }
            }

            if (fourthAirport.isPresent()) {
                if (ticketsDto.get(0).getFlightDto().getDstAirport().equals(fourthAirport.get())) {
                    return false;
                }

                if (ticketsDto.get(ticketsDto.size() - 1).getFlightDto().getSrcAirport().equals(fourthAirport.get())) {
                    return false;
                }
            }
        }
        return true;
    }
}
