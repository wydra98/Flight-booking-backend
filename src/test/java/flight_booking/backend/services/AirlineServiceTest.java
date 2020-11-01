package flight_booking.backend.services;

import flight_booking.backend.controllers.airline.AirlineDto;
import flight_booking.backend.models.Airline;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AirlineServiceTest {

    @Test
    public void findById() {
        //given
        AirlineService airlineService = mock(AirlineService.class);
        Airline airline = Airline.builder()
                .name("Lot")
                .country("Poland")
                .build();
        //when
        when(airlineService.findById(anyLong())).thenReturn(Optional.of(airline));
        //then
        Airline airline2 = airlineService.findById(anyLong()).get();
        assertEquals(airline, airline2);
    }


    @Test
    public void findAll() {
        //given
        AirlineService airlineService = mock(AirlineService.class);
        //when
        when(airlineService.findAll()).thenReturn(prepareMockData());
        //then
        assertThat(airlineService.findAll(), Matchers.hasSize(2));
    }

    private List<Airline> prepareMockData() {
        List<Airline> airlines = new ArrayList<>();
        airlines.add(Airline.builder()
                .name("Lot")
                .country("Poland")
                .build());
        airlines.add(Airline.builder()
                .name("Lufhansa")
                .country("Germany")
                .build());
        return airlines;
    }


    @Test
    public void addNewAirline() {
        //given
        AirlineService airlineService = mock(AirlineService.class);
        given(airlineService.addNewAirline(Mockito.any(AirlineDto.class), anyString())).willReturn(Airline.builder()
                .name("Lot")
                .country("Poland")
                .build());

        //when
        Airline airline = airlineService.addNewAirline(new AirlineDto(), "");
        //then
        assertEquals(airline.getCountry(), "Poland");
    }
}
