package flight_booking.backend.services;

import flight_booking.backend.controllers.airport.AirportDto;
import flight_booking.backend.models.Airport;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AirportServiceTest {

    @Test
    public void findById() {
        //given
        AirportService airportService = mock(AirportService.class);
        Airport airport = Airport.builder()
                .name("John F. Kennedy International Airport")
                .longitude(-118.410042)
                .latitude(33.942791)
                .city("New York")
                .country("USA")
                .timezone(-4)
                .build();
        //when
        when(airportService.findById(anyLong())).thenReturn(Optional.of(airport));
        //then
        Airport airport2 = airportService.findById(anyLong()).get();
        assertEquals(airport, airport2);
    }


    @Test
    public void findAll() {
        //given
        AirportService airportService = mock(AirportService.class);
        //when
        when(airportService.findAll()).thenReturn(prepareMockData());
        //then
        assertThat(airportService.findAll(), Matchers.hasSize(2));
    }

    private List<Airport> prepareMockData() {
        List<Airport> airports = new ArrayList<>();
        airports.add(Airport.builder()
                .name("John F. Kennedy International Airport")
                .longitude(-118.410042)
                .latitude(33.942791)
                .city("New York")
                .country("USA")
                .timezone(-4)
                .build());

        airports.add(Airport.builder()
                .name("Chicago O'Hare International Airport")
                .longitude(-87.904724)
                .latitude(41.978611)
                .city("Chicago")
                .country("USA")
                .timezone(-5)
                .build());
        return airports;
    }


    @Test
    public void addNewAirport() {
        //jak cos to tutaj moze byc problem z longitude i latitude bo sa teraz w srodku Airporta a nie na zewnatrz
        //given
        AirportService airportService = mock(AirportService.class);
        given(airportService.addNewAirport(Mockito.any(AirportDto.class))).willReturn(Airport.builder()
                .name("John F. Kennedy International Airport")
                .longitude(-118.410042)
                .latitude(33.942791)
                .city("New York")
                .country("USA")
                .timezone(-4)
                .build());
        //when
        Airport airport = airportService.addNewAirport(new AirportDto());
        //then
        assertEquals(airport.getName(), "John F. Kennedy International Airport");
    }
}
