package flight_booking.backend.services;

import flight_booking.backend.models.Airport;
import flight_booking.backend.models.Connection;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConnectionServiceTest {


    @Test
    public void findById() {
        //given
        ConnectionService connectionService = mock(ConnectionService.class);
        Connection connection = Connection.builder()
                .srcAirport(
                        Airport.builder().name("Chicago O'Hare International Airport")
                                .longitude(-87.904724)
                                .latitude(41.978611)
                                .city("Chicago")
                                .country("USA")
                                .timezone(-5)
                                .build())
                .dstAirport(
                        Airport.builder().name("Chicago O'Hare International Airport")
                                .longitude(-87.904724)
                                .latitude(41.978611)
                                .city("Chicago")
                                .country("USA")
                                .timezone(-5)
                                .build())
                .build();
        //when
        when(connectionService.findById(anyLong())).thenReturn(Optional.of(connection));
        //then
        Connection connection2 = connectionService.findById(anyLong()).get();
        assertEquals(connection, connection2);
    }

    @Test
    public void addNewConnection() {
        //given
        ConnectionService connectionService = mock(ConnectionService.class);
        given(connectionService.addNewConnection(anyLong(), anyLong())).willReturn(Connection.builder()
                .srcAirport(
                        Airport.builder().name("John F. Kennedy International Airport")
                                .longitude(-118.410042)
                                .latitude(33.942791)
                                .city("New York")
                                .country("USA")
                                .timezone(-4)
                                .build())
                .dstAirport(
                        Airport.builder().name("Chicago O'Hare International Airport")
                                .longitude(-87.904724)
                                .latitude(41.978611)
                                .city("Chicago")
                                .country("USA")
                                .timezone(-5)
                                .build())
                .build());

        //when
        Connection connection = connectionService.addNewConnection(1L, 1L);
        //then
        assertEquals(connection.getSrcAirport().getName(), "John F. Kennedy International Airport");
        assertEquals(connection.getDstAirport().getName(), "Chicago O'Hare International Airport");
    }
}
