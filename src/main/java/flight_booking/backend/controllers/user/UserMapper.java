package flight_booking.backend.controllers.user;

import flight_booking.backend.controllers.trip.TripDto;
import flight_booking.backend.controllers.trip.TripMapper;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.User;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UserMapper {

    public UserDto map(User user) {
        Set<TripDto> tripDtos = new HashSet<>();
        TripMapper tripMapper = new TripMapper();


        if (!user.getTrips().isEmpty()) {
            for (Trip trip : user.getTrips()) {
                tripDtos.add(tripMapper.map(trip, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
            }
        }

        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .role(user.getRole())
                .arraysTrip(tripDtos)
                .build();

        return userDto;
    }
}
