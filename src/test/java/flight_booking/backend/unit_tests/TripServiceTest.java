package flight_booking.backend.unit_tests;

import flight_booking.backend.models.Passenger;
import flight_booking.backend.models.Trip;
import flight_booking.backend.models.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TripServiceTest {

    @Test
    public void findById() {
        //given
        Passenger passenger1 = Passenger.builder()
                .firstName("Kacper")
                .surname("Kuczyński")
                .pesel("02220766333")
                .dateOfBirth(LocalDate.parse("1992-08-27"))
                .phoneNumber("512461514")
                .email("kuczyński.kacper92@gmail.com")
                .build();

        User user1 = User.builder()
                .name("Adrian")
                .surname("Wydra")
                .email("adek868@interia.eu")
                .role("ROLE_USER")
                .build();


        TripService tripService = mock(TripService.class);
        Trip trip = Trip.builder()
                .code("2afe9b0d-052d-43a5-af9a-124137eebf30")
                .arrivalDate(LocalDate.parse("2021-01-03"))
                .arrivalTime(LocalTime.parse("16:30:00"))
                .departureDate(LocalDate.parse("2021-01-02"))
                .departureTime(LocalTime.parse("14:43:11"))
                .purchaseDate(LocalDate.parse("2020-08-28"))
                .purchaseTime(LocalTime.parse("09:03:56"))
                .passenger(passenger1)
                .user(user1)
                .price(1345)
                .build();
        //when
        when(tripService.findById(anyLong())).thenReturn(Optional.of(trip));
        //then
        Trip trip2 = tripService.findById(anyLong()).get();
        assertEquals(trip, trip2);
    }
}
