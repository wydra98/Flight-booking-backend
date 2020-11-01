package flight_booking.backend.services;

import flight_booking.backend.controllers.passenger.PassengerDto;
import flight_booking.backend.models.Passenger;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PassengerServiceTest {
    @Test
    public void findById() {
        //given
        PassengerService passengerService = mock(PassengerService.class);
        Passenger passenger = Passenger.builder()
                .firstName("Kacper")
                .surname("Kuczyński")
                .pesel("02220766333")
                .dateOfBirth(LocalDate.parse("1992-08-27"))
                .phoneNumber("512461514")
                .email("kuczyński.kacper92@gmail.com")
                .build();
        //when
        when(passengerService.findById(anyLong())).thenReturn(Optional.of(passenger));
        //then
        Passenger passenger2 = passengerService.findById(anyLong()).get();
        assertEquals(passenger, passenger2);
    }


    @Test
    public void findAll() {
        //given
        PassengerService passengerService = mock(PassengerService.class);
        //when
        when(passengerService.findAll()).thenReturn(prepareMockData());
        //then
        assertThat(passengerService.findAll(), Matchers.hasSize(2));
    }

    private List<Passenger> prepareMockData() {
        List<Passenger> passengers = new ArrayList<>();
        passengers.add(Passenger.builder()
                .firstName("Kacper")
                .surname("Kuczyński")
                .pesel("02220766333")
                .dateOfBirth(LocalDate.parse("1992-08-27"))
                .phoneNumber("512461514")
                .email("kuczyński.kacper92@gmail.com")
                .build());
        passengers.add(Passenger.builder()
                .firstName("Jan")
                .surname("Kowalski")
                .pesel("75112655569")
                .dateOfBirth(LocalDate.parse("1956-02-27"))
                .phoneNumber("482471045")
                .email("kowalski.jan56@gmail.com")
                .build());
        return passengers;
    }


    @Test
    public void addNewPassenger() {
        //given
        PassengerService passengerService = mock(PassengerService.class);
        given(passengerService.addNewPassenger(Mockito.any(PassengerDto.class))).willReturn(Passenger.builder()
                .firstName("Jan")
                .surname("Kowalski")
                .pesel("75112655569")
                .dateOfBirth(LocalDate.parse("1956-02-27"))
                .phoneNumber("482471045")
                .email("kowalski.jan56@gmail.com")
                .build());

        //when
        Passenger passenger = passengerService.addNewPassenger(new PassengerDto());
        //then
        assertEquals(passenger.getFirstName(), "Jan");
        assertEquals(passenger.getSurname(), "Kowalski");
        assertEquals(passenger.getPesel(), "75112655569");
        assertEquals(passenger.getDateOfBirth(), LocalDate.parse("1956-02-27"));
        assertEquals(passenger.getPhoneNumber(), "482471045");
        assertEquals(passenger.getEmail(), "kowalski.jan56@gmail.com");
    }
}
