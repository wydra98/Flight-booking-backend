package flight_booking.backend.controllers.TripController;

import flight_booking.backend.controllers.TicketController.TicketDto;
import flight_booking.backend.models.Trips.Trip;

public class TripMapper {

    public TripDto map(Trip trip) {
        return TripDto.builder()
                .id(trip.getId())
                .flightDto(flightMapper.map(ticket.getFlight(), ticket.getFlight().getConnection()))
                .deparuteDate(trip.getPurchaseDate().toString())
                .departureTime(trip.getPurchaseTime().toString())
                .purchaseDate(trip.getPurchaseDate().toString())
                .purchaseTime(trip.getPurchaseTime().toString())
                .totalPrice(trip.getPrice())
                .build();
    }
}
