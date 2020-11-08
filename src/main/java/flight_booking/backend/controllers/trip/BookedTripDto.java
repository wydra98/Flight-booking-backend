package flight_booking.backend.controllers.trip;

import flight_booking.backend.controllers.passenger.PassengerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor

public class BookedTripDto {
    private Long userId;
    private TripDto tripDto;
    private List<PassengerDto> passengersDto;
}
