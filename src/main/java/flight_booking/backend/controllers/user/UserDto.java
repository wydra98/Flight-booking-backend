package flight_booking.backend.controllers.user;

import flight_booking.backend.controllers.trip.TripDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String role;
    private Set<TripDto> arraysTrip;
}
