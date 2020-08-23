package flight_booking.backend.loaders;

import flight_booking.backend.models.Airports.Airport;
import flight_booking.backend.models.Connections.Connection;
import flight_booking.backend.models.Connections.ConnectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import flight_booking.backend.models.Airports.AirportRepository;


import javax.transaction.Transactional;
import java.util.Optional;


@Component
public class ConnectionLoader implements CommandLineRunner {

    ConnectionRepository connectionRepository;
    AirportRepository airportRepository;

    ConnectionLoader(ConnectionRepository connectionRepository,
                     AirportRepository airportRepository) {
        this.connectionRepository = connectionRepository;
        this.airportRepository = airportRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (connectionRepository.amountOfRows() == 0) {

            /** Z NOWEGO YORKU DO CHICAGO **/
            Optional<Airport> srcAirport1 = airportRepository.findById(1L);
            Optional<Airport> dstAirport1 = airportRepository.findById(2L);
            Connection connection1 = Connection.builder()
                    .srcAirport(srcAirport1.get())
                    .dstAirport(dstAirport1.get())
                    .build();
            connectionRepository.save(connection1);

            /** Z CHICAGO DO NOWEGO YORKU **/
            Optional<Airport> srcAirport2 = airportRepository.findById(2L);
            Optional<Airport> dstAirport2 = airportRepository.findById(1L);
            Connection connection2 = Connection.builder()
                    .srcAirport(srcAirport2.get())
                    .dstAirport(dstAirport2.get())
                    .build();
            connectionRepository.save(connection2);

            /** Z NOWEGO YORKU DO WARSZAWY **/
            Optional<Airport> srcAirport3 = airportRepository.findById(1L);
            Optional<Airport> dstAirport3 = airportRepository.findById(3L);
            Connection connection3 = Connection.builder()
                    .srcAirport(srcAirport3.get())
                    .dstAirport(dstAirport3.get())
                    .build();
            connectionRepository.save(connection3);

            /** Z WARSZAWY DO NOWEGO YORKU **/
            Optional<Airport> srcAirport4 = airportRepository.findById(3L);
            Optional<Airport> dstAirport4 = airportRepository.findById(1L);
            Connection connection4 = Connection.builder()
                    .srcAirport(srcAirport4.get())
                    .dstAirport(dstAirport4.get())
                    .build();
            connectionRepository.save(connection4);

            /** Z NOWEGO YORKU DO PEKINU **/
            Optional<Airport> srcAirport5 = airportRepository.findById(1L);
            Optional<Airport> dstAirport5 = airportRepository.findById(4L);
            Connection connection5 = Connection.builder()
                    .srcAirport(srcAirport5.get())
                    .dstAirport(dstAirport5.get())
                    .build();
            connectionRepository.save(connection5);


            /** Z PEKINU DO NOWEGO YORKU **/
            Optional<Airport> srcAirport6 = airportRepository.findById(4L);
            Optional<Airport> dstAirport6 = airportRepository.findById(1L);
            Connection connection6 = Connection.builder()
                    .srcAirport(srcAirport6.get())
                    .dstAirport(dstAirport6.get())
                    .build();
            connectionRepository.save(connection6);

            /** Z PEKINU DO CHICAGO **/
            Optional<Airport> srcAirport7 = airportRepository.findById(4L);
            Optional<Airport> dstAirport7 = airportRepository.findById(2L);
            Connection connection7 = Connection.builder()
                    .srcAirport(srcAirport7.get())
                    .dstAirport(dstAirport7.get())
                    .build();
            connectionRepository.save(connection7);

            /** Z CHICAGO DO PEKINU **/
            Optional<Airport> srcAirport8 = airportRepository.findById(2L);
            Optional<Airport> dstAirport8 = airportRepository.findById(4L);
            Connection connection8 = Connection.builder()
                    .srcAirport(srcAirport8.get())
                    .dstAirport(dstAirport8.get())
                    .build();
            connectionRepository.save(connection8);

            /** Z PEKINU DO WARSZAWY **/
            Optional<Airport> srcAirport9 = airportRepository.findById(4L);
            Optional<Airport> dstAirport9 = airportRepository.findById(3L);
            Connection connection9 = Connection.builder()
                    .srcAirport(srcAirport9.get())
                    .dstAirport(dstAirport9.get())
                    .build();
            connectionRepository.save(connection9);

            /** Z WARSZAWY DO PEKINU **/
            Optional<Airport> srcAirport10 = airportRepository.findById(3L);
            Optional<Airport> dstAirport10 = airportRepository.findById(4L);
            Connection connection10 = Connection.builder()
                    .srcAirport(srcAirport10.get())
                    .dstAirport(dstAirport10.get())
                    .build();
            connectionRepository.save(connection10);

            /** Z CHICAGO DO BERLINU **/
            Optional<Airport> srcAirport11 = airportRepository.findById(2L);
            Optional<Airport> dstAirport11 = airportRepository.findById(5L);
            Connection connection11 = Connection.builder()
                    .srcAirport(srcAirport11.get())
                    .dstAirport(dstAirport11.get())
                    .build();
            connectionRepository.save(connection11);

            /** Z BERLINU DO CHICAGO **/
            Optional<Airport> srcAirport12 = airportRepository.findById(5L);
            Optional<Airport> dstAirport12 = airportRepository.findById(2L);
            Connection connection12 = Connection.builder()
                    .srcAirport(srcAirport12.get())
                    .dstAirport(dstAirport12.get())
                    .build();
            connectionRepository.save(connection12);

            /** Z WARSZAWY DO BERLINU **/
            Optional<Airport> srcAirport13 = airportRepository.findById(3L);
            Optional<Airport> dstAirport13 = airportRepository.findById(5L);
            Connection connection13 = Connection.builder()
                    .srcAirport(srcAirport13.get())
                    .dstAirport(dstAirport13.get())
                    .build();
            connectionRepository.save(connection13);

            /** Z BERLINU DO WARSZAWY **/
            Optional<Airport> srcAirport14 = airportRepository.findById(5L);
            Optional<Airport> dstAirport14 = airportRepository.findById(3L);
            Connection connection14 = Connection.builder()
                    .srcAirport(srcAirport14.get())
                    .dstAirport(dstAirport14.get())
                    .build();
            connectionRepository.save(connection14);

            /** Z WARSZAWY DO CHICAGO* */
            Optional<Airport> srcAirport15 = airportRepository.findById(3L);
            Optional<Airport> dstAirport15 = airportRepository.findById(2L);
            Connection connection15 = Connection.builder()
                    .srcAirport(srcAirport15.get())
                    .dstAirport(dstAirport15.get())
                    .build();
            connectionRepository.save(connection15);

            /** Z CHICAGO DO WARSZAWY **/
            Optional<Airport> srcAirport16 = airportRepository.findById(2L);
            Optional<Airport> dstAirport16 = airportRepository.findById(3L);
            Connection connection16 = Connection.builder()
                    .srcAirport(srcAirport16.get())
                    .dstAirport(dstAirport16.get())
                    .build();
            connectionRepository.save(connection16);

            /** Z SZANGHAJU DO NOWEGO YORKU **/
            Optional<Airport> srcAirport17 = airportRepository.findById(6L);
            Optional<Airport> dstAirport17 = airportRepository.findById(1L);
            Connection connection17 = Connection.builder()
                    .srcAirport(srcAirport17.get())
                    .dstAirport(dstAirport17.get())
                    .build();
            connectionRepository.save(connection17);

            /** Z NOWEGO YORKU DO SZANGHAJU **/
            Optional<Airport> srcAirport18 = airportRepository.findById(1L);
            Optional<Airport> dstAirport18 = airportRepository.findById(6L);
            Connection connection18 = Connection.builder()
                    .srcAirport(srcAirport18.get())
                    .dstAirport(dstAirport18.get())
                    .build();
            connectionRepository.save(connection18);

            /** Z SZANGHAJU DO PEKINU **/
            Optional<Airport> srcAirport19 = airportRepository.findById(6L);
            Optional<Airport> dstAirport19 = airportRepository.findById(4L);
            Connection connection19 = Connection.builder()
                    .srcAirport(srcAirport19.get())
                    .dstAirport(dstAirport19.get())
                    .build();
            connectionRepository.save(connection19);

            /** Z PEKINU DO SZANGHAJU **/
            Optional<Airport> srcAirport20 = airportRepository.findById(4L);
            Optional<Airport> dstAirport20 = airportRepository.findById(6L);
            Connection connection20 = Connection.builder()
                    .srcAirport(srcAirport20.get())
                    .dstAirport(dstAirport20.get())
                    .build();
            connectionRepository.save(connection20);

            /** Z SZANGHAJU DO TORONTO **/
            Optional<Airport> srcAirport21 = airportRepository.findById(6L);
            Optional<Airport> dstAirport21 = airportRepository.findById(7L);
            Connection connection21 = Connection.builder()
                    .srcAirport(srcAirport21.get())
                    .dstAirport(dstAirport21.get())
                    .build();
            connectionRepository.save(connection21);

            /** Z TORONTO DO SZANGHAJU **/
            Optional<Airport> srcAirport22 = airportRepository.findById(7L);
            Optional<Airport> dstAirport22 = airportRepository.findById(6L);
            Connection connection22 = Connection.builder()
                    .srcAirport(srcAirport22.get())
                    .dstAirport(dstAirport22.get())
                    .build();
            connectionRepository.save(connection22);

            /** Z SZANGHAJU DO SYDNEY **/
            Optional<Airport> srcAirport23 = airportRepository.findById(6L);
            Optional<Airport> dstAirport23 = airportRepository.findById(8L);
            Connection connection23 = Connection.builder()
                    .srcAirport(srcAirport23.get())
                    .dstAirport(dstAirport23.get())
                    .build();
            connectionRepository.save(connection23);

            /** Z SYDNEY DO SZANGHAJU **/
            Optional<Airport> srcAirport24 = airportRepository.findById(8L);
            Optional<Airport> dstAirport24 = airportRepository.findById(6L);
            Connection connection24 = Connection.builder()
                    .srcAirport(srcAirport24.get())
                    .dstAirport(dstAirport24.get())
                    .build();
            connectionRepository.save(connection24);

            /** Z TORONTO DO PEKINU **/
            Optional<Airport> srcAirport25 = airportRepository.findById(7L);
            Optional<Airport> dstAirport25 = airportRepository.findById(4L);
            Connection connection25 = Connection.builder()
                    .srcAirport(srcAirport25.get())
                    .dstAirport(dstAirport25.get())
                    .build();
            connectionRepository.save(connection25);

            /** Z PEKINU DO TORONTO **/
            Optional<Airport> srcAirport26 = airportRepository.findById(4L);
            Optional<Airport> dstAirport26 = airportRepository.findById(7L);
            Connection connection26 = Connection.builder()
                    .srcAirport(srcAirport26.get())
                    .dstAirport(dstAirport26.get())
                    .build();
            connectionRepository.save(connection26);

            /** Z TORONTO DO CHICAGO **/
            Optional<Airport> srcAirport27 = airportRepository.findById(7L);
            Optional<Airport> dstAirport27 = airportRepository.findById(2L);
            Connection connection27 = Connection.builder()
                    .srcAirport(srcAirport27.get())
                    .dstAirport(dstAirport27.get())
                    .build();
            connectionRepository.save(connection27);

            /** Z CHICAGO DO TORONTO **/
            Optional<Airport> srcAirport28 = airportRepository.findById(2L);
            Optional<Airport> dstAirport28 = airportRepository.findById(7L);
            Connection connection28 = Connection.builder()
                    .srcAirport(srcAirport28.get())
                    .dstAirport(dstAirport28.get())
                    .build();
            connectionRepository.save(connection28);

            /** Z TORONTO DO SYDNEY **/
            Optional<Airport> srcAirport29 = airportRepository.findById(7L);
            Optional<Airport> dstAirport29 = airportRepository.findById(8L);
            Connection connection29 = Connection.builder()
                    .srcAirport(srcAirport29.get())
                    .dstAirport(dstAirport29.get())
                    .build();
            connectionRepository.save(connection29);

            /** Z SYDNEY DO TORONTO **/
            Optional<Airport> srcAirport30 = airportRepository.findById(8L);
            Optional<Airport> dstAirport30 = airportRepository.findById(7L);
            Connection connection30 = Connection.builder()
                    .srcAirport(srcAirport30.get())
                    .dstAirport(dstAirport30.get())
                    .build();
            connectionRepository.save(connection30);

            /** Z SYDNEY DO BERLINA **/
            Optional<Airport> srcAirport31 = airportRepository.findById(8L);
            Optional<Airport> dstAirport31 = airportRepository.findById(5L);
            Connection connection31 = Connection.builder()
                    .srcAirport(srcAirport31.get())
                    .dstAirport(dstAirport31.get())
                    .build();
            connectionRepository.save(connection31);

            /** Z BERLINA DO SYDNEY **/
            Optional<Airport> srcAirport32 = airportRepository.findById(5L);
            Optional<Airport> dstAirport32 = airportRepository.findById(8L);
            Connection connection32 = Connection.builder()
                    .srcAirport(srcAirport32.get())
                    .dstAirport(dstAirport32.get())
                    .build();
            connectionRepository.save(connection32);

            /** Z SYDNEY DO TOKIO **/
            Optional<Airport> srcAirport33 = airportRepository.findById(8L);
            Optional<Airport> dstAirport33 = airportRepository.findById(9L);
            Connection connection33 = Connection.builder()
                    .srcAirport(srcAirport33.get())
                    .dstAirport(dstAirport33.get())
                    .build();
            connectionRepository.save(connection33);

            /** Z TOKIO DO SYDNEY **/
            Optional<Airport> srcAirport34 = airportRepository.findById(9L);
            Optional<Airport> dstAirport34 = airportRepository.findById(8L);
            Connection connection34 = Connection.builder()
                    .srcAirport(srcAirport34.get())
                    .dstAirport(dstAirport34.get())
                    .build();
            connectionRepository.save(connection34);

            /** Z RIO DE JANEIRO DO BERLINA **/
            Optional<Airport> srcAirport35 = airportRepository.findById(10L);
            Optional<Airport> dstAirport35 = airportRepository.findById(5L);
            Connection connection35 = Connection.builder()
                    .srcAirport(srcAirport35.get())
                    .dstAirport(dstAirport35.get())
                    .build();
            connectionRepository.save(connection35);

            /** Z BERLINA DO RIO DE JANEIRO **/
            Optional<Airport> srcAirport36 = airportRepository.findById(5L);
            Optional<Airport> dstAirport36 = airportRepository.findById(10L);
            Connection connection36 = Connection.builder()
                    .srcAirport(srcAirport36.get())
                    .dstAirport(dstAirport36.get())
                    .build();
            connectionRepository.save(connection36);

        }
    }

}

