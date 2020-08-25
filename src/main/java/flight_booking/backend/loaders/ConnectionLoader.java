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

            /** Z TOKIO DO BERLINA **/
            Optional<Airport> srcAirport35 = airportRepository.findById(9L);
            Optional<Airport> dstAirport35 = airportRepository.findById(5L);
            Connection connection35 = Connection.builder()
                    .srcAirport(srcAirport35.get())
                    .dstAirport(dstAirport35.get())
                    .build();
            connectionRepository.save(connection35);

            /** Z BERLINA DO TOKIO **/
            Optional<Airport> srcAirport36 = airportRepository.findById(5L);
            Optional<Airport> dstAirport36 = airportRepository.findById(9L);
            Connection connection36 = Connection.builder()
                    .srcAirport(srcAirport36.get())
                    .dstAirport(dstAirport36.get())
                    .build();
            connectionRepository.save(connection36);

            /** Z TOKIO DO RIO DE JANEIRO **/
            Optional<Airport> srcAirport37 = airportRepository.findById(9L);
            Optional<Airport> dstAirport37 = airportRepository.findById(10L);
            Connection connection37 = Connection.builder()
                    .srcAirport(srcAirport37.get())
                    .dstAirport(dstAirport37.get())
                    .build();
            connectionRepository.save(connection37);

            /** Z RIO DE JANEIRO DO TOKIO **/
            Optional<Airport> srcAirport38 = airportRepository.findById(10L);
            Optional<Airport> dstAirport38 = airportRepository.findById(9L);
            Connection connection38 = Connection.builder()
                    .srcAirport(srcAirport38.get())
                    .dstAirport(dstAirport38.get())
                    .build();
            connectionRepository.save(connection38);

            /** Z RIO DE JANEIRO DO BERLINA **/
            Optional<Airport> srcAirport39 = airportRepository.findById(10L);
            Optional<Airport> dstAirport39 = airportRepository.findById(5L);
            Connection connection39 = Connection.builder()
                    .srcAirport(srcAirport39.get())
                    .dstAirport(dstAirport39.get())
                    .build();
            connectionRepository.save(connection39);

            /** Z BERLINA DO RIO DE JANEIRO **/
            Optional<Airport> srcAirport40 = airportRepository.findById(5L);
            Optional<Airport> dstAirport40 = airportRepository.findById(10L);
            Connection connection40 = Connection.builder()
                    .srcAirport(srcAirport40.get())
                    .dstAirport(dstAirport40.get())
                    .build();
            connectionRepository.save(connection40);

            /** Z RIO DE JANEIRO DO LOS ANGELES **/
            Optional<Airport> srcAirport41 = airportRepository.findById(10L);
            Optional<Airport> dstAirport41 = airportRepository.findById(15L);
            Connection connection41 = Connection.builder()
                    .srcAirport(srcAirport41.get())
                    .dstAirport(dstAirport41.get())
                    .build();
            connectionRepository.save(connection41);

            /** Z LOS ANGELES DO RIO DE JANEIRO **/
            Optional<Airport> srcAirport42 = airportRepository.findById(15L);
            Optional<Airport> dstAirport42 = airportRepository.findById(10L);
            Connection connection42 = Connection.builder()
                    .srcAirport(srcAirport42.get())
                    .dstAirport(dstAirport42.get())
                    .build();
            connectionRepository.save(connection42);

            /** Z RIO DE JANEIRO DO OSLO **/
            Optional<Airport> srcAirport43 = airportRepository.findById(10L);
            Optional<Airport> dstAirport43 = airportRepository.findById(11L);
            Connection connection43 = Connection.builder()
                    .srcAirport(srcAirport43.get())
                    .dstAirport(dstAirport43.get())
                    .build();
            connectionRepository.save(connection43);

            /** Z OSLO DO RIO DE JANEIRO **/
            Optional<Airport> srcAirport44 = airportRepository.findById(11L);
            Optional<Airport> dstAirport44 = airportRepository.findById(10L);
            Connection connection44 = Connection.builder()
                    .srcAirport(srcAirport44.get())
                    .dstAirport(dstAirport44.get())
                    .build();
            connectionRepository.save(connection44);

            /** Z RIO DE JANEIRO DO BUENOS AIRES **/
            Optional<Airport> srcAirport45 = airportRepository.findById(10L);
            Optional<Airport> dstAirport45 = airportRepository.findById(12L);
            Connection connection45 = Connection.builder()
                    .srcAirport(srcAirport45.get())
                    .dstAirport(dstAirport45.get())
                    .build();
            connectionRepository.save(connection45);

            /** Z BUENOS AIRES DO RIO DE JANEIRO **/
            Optional<Airport> srcAirport46 = airportRepository.findById(12L);
            Optional<Airport> dstAirport46 = airportRepository.findById(10L);
            Connection connection46 = Connection.builder()
                    .srcAirport(srcAirport46.get())
                    .dstAirport(dstAirport46.get())
                    .build();
            connectionRepository.save(connection46);

            /** Z OSLO DO BUENOS AIRES **/
            Optional<Airport> srcAirport47 = airportRepository.findById(11L);
            Optional<Airport> dstAirport47 = airportRepository.findById(12L);
            Connection connection47 = Connection.builder()
                    .srcAirport(srcAirport47.get())
                    .dstAirport(dstAirport47.get())
                    .build();
            connectionRepository.save(connection47);

            /** Z BUENOS AIRES DO OSLO **/
            Optional<Airport> srcAirport48 = airportRepository.findById(12L);
            Optional<Airport> dstAirport48 = airportRepository.findById(11L);
            Connection connection48 = Connection.builder()
                    .srcAirport(srcAirport48.get())
                    .dstAirport(dstAirport48.get())
                    .build();
            connectionRepository.save(connection48);

            /** Z OSLO DO PARYŻA **/
            Optional<Airport> srcAirport49 = airportRepository.findById(11L);
            Optional<Airport> dstAirport49 = airportRepository.findById(13L);
            Connection connection49 = Connection.builder()
                    .srcAirport(srcAirport49.get())
                    .dstAirport(dstAirport49.get())
                    .build();
            connectionRepository.save(connection49);

            /** Z PARYŻA DO OSLO **/
            Optional<Airport> srcAirport50 = airportRepository.findById(13L);
            Optional<Airport> dstAirport50 = airportRepository.findById(11L);
            Connection connection50 = Connection.builder()
                    .srcAirport(srcAirport50.get())
                    .dstAirport(dstAirport50.get())
                    .build();
            connectionRepository.save(connection50);

            /** Z OSLO DO LONDYNU **/
            Optional<Airport> srcAirport51 = airportRepository.findById(11L);
            Optional<Airport> dstAirport51 = airportRepository.findById(14L);
            Connection connection51 = Connection.builder()
                    .srcAirport(srcAirport51.get())
                    .dstAirport(dstAirport51.get())
                    .build();
            connectionRepository.save(connection51);

            /** Z LONDYNU DO OSLO **/
            Optional<Airport> srcAirport52 = airportRepository.findById(14L);
            Optional<Airport> dstAirport52 = airportRepository.findById(11L);
            Connection connection52 = Connection.builder()
                    .srcAirport(srcAirport52.get())
                    .dstAirport(dstAirport52.get())
                    .build();
            connectionRepository.save(connection52);

            /** Z OSLO DO LOS ANGELES **/
            Optional<Airport> srcAirport53 = airportRepository.findById(11L);
            Optional<Airport> dstAirport53 = airportRepository.findById(15L);
            Connection connection53 = Connection.builder()
                    .srcAirport(srcAirport53.get())
                    .dstAirport(dstAirport53.get())
                    .build();
            connectionRepository.save(connection53);

            /** Z LOS ANGELES DO OSLO **/
            Optional<Airport> srcAirport54 = airportRepository.findById(15L);
            Optional<Airport> dstAirport54 = airportRepository.findById(11L);
            Connection connection54 = Connection.builder()
                    .srcAirport(srcAirport54.get())
                    .dstAirport(dstAirport54.get())
                    .build();
            connectionRepository.save(connection54);

            /** Z BUENOS AIRES DO PARYŻA **/
            Optional<Airport> srcAirport55 = airportRepository.findById(12L);
            Optional<Airport> dstAirport55 = airportRepository.findById(13L);
            Connection connection55 = Connection.builder()
                    .srcAirport(srcAirport55.get())
                    .dstAirport(dstAirport55.get())
                    .build();
            connectionRepository.save(connection55);

            /** Z PARYŻA DO BUENOS AIRES **/
            Optional<Airport> srcAirport56 = airportRepository.findById(13L);
            Optional<Airport> dstAirport56 = airportRepository.findById(12L);
            Connection connection56 = Connection.builder()
                    .srcAirport(srcAirport56.get())
                    .dstAirport(dstAirport56.get())
                    .build();
            connectionRepository.save(connection56);

            /** Z PARYŻA DO LONDYNU **/
            Optional<Airport> srcAirport57 = airportRepository.findById(13L);
            Optional<Airport> dstAirport57 = airportRepository.findById(14L);
            Connection connection57 = Connection.builder()
                    .srcAirport(srcAirport57.get())
                    .dstAirport(dstAirport57.get())
                    .build();
            connectionRepository.save(connection57);

            /** Z LONDYNU DO PARYŻA **/
            Optional<Airport> srcAirport58 = airportRepository.findById(14L);
            Optional<Airport> dstAirport58 = airportRepository.findById(13L);
            Connection connection58 = Connection.builder()
                    .srcAirport(srcAirport58.get())
                    .dstAirport(dstAirport58.get())
                    .build();
            connectionRepository.save(connection58);

            /** Z LONDYNU DO TORONTO **/
            Optional<Airport> srcAirport59 = airportRepository.findById(14L);
            Optional<Airport> dstAirport59 = airportRepository.findById(7L);
            Connection connection59 = Connection.builder()
                    .srcAirport(srcAirport59.get())
                    .dstAirport(dstAirport59.get())
                    .build();
            connectionRepository.save(connection59);

            /** Z TORONTO DO LONDYNU **/
            Optional<Airport> srcAirport60 = airportRepository.findById(7L);
            Optional<Airport> dstAirport60 = airportRepository.findById(14L);
            Connection connection60 = Connection.builder()
                    .srcAirport(srcAirport60.get())
                    .dstAirport(dstAirport60.get())
                    .build();
            connectionRepository.save(connection60);

            /** Z LONDYNU DO KAIRU **/
            Optional<Airport> srcAirport61 = airportRepository.findById(14L);
            Optional<Airport> dstAirport61 = airportRepository.findById(17L);
            Connection connection61 = Connection.builder()
                    .srcAirport(srcAirport61.get())
                    .dstAirport(dstAirport61.get())
                    .build();
            connectionRepository.save(connection61);

            /** Z KAIRU DO LONDYNU **/
            Optional<Airport> srcAirport62 = airportRepository.findById(17L);
            Optional<Airport> dstAirport62 = airportRepository.findById(14L);
            Connection connection62 = Connection.builder()
                    .srcAirport(srcAirport62.get())
                    .dstAirport(dstAirport62.get())
                    .build();
            connectionRepository.save(connection62);

            /** Z LONDYNU DO MOSKWY **/
            Optional<Airport> srcAirport63 = airportRepository.findById(14L);
            Optional<Airport> dstAirport63 = airportRepository.findById(16L);
            Connection connection63 = Connection.builder()
                    .srcAirport(srcAirport63.get())
                    .dstAirport(dstAirport63.get())
                    .build();
            connectionRepository.save(connection63);

            /** Z MOSKWY DO LONDYNU **/
            Optional<Airport> srcAirport64 = airportRepository.findById(16L);
            Optional<Airport> dstAirport64 = airportRepository.findById(14L);
            Connection connection64 = Connection.builder()
                    .srcAirport(srcAirport64.get())
                    .dstAirport(dstAirport64.get())
                    .build();
            connectionRepository.save(connection64);

            /** Z LONDYNU DO WARSZAWY **/
            Optional<Airport> srcAirport65 = airportRepository.findById(14L);
            Optional<Airport> dstAirport65 = airportRepository.findById(3L);
            Connection connection65 = Connection.builder()
                    .srcAirport(srcAirport65.get())
                    .dstAirport(dstAirport65.get())
                    .build();
            connectionRepository.save(connection65);

            /** Z WARSZAWY DO LONDYNU **/
            Optional<Airport> srcAirport66 = airportRepository.findById(3L);
            Optional<Airport> dstAirport66 = airportRepository.findById(14L);
            Connection connection66 = Connection.builder()
                    .srcAirport(srcAirport66.get())
                    .dstAirport(dstAirport66.get())
                    .build();
            connectionRepository.save(connection66);

            /** Z LONDYNU DO LOS ANGELES **/
            Optional<Airport> srcAirport67 = airportRepository.findById(14L);
            Optional<Airport> dstAirport67 = airportRepository.findById(15L);
            Connection connection67 = Connection.builder()
                    .srcAirport(srcAirport67.get())
                    .dstAirport(dstAirport67.get())
                    .build();
            connectionRepository.save(connection67);

            /** Z LOS ANGELES DO LONDYNU **/
            Optional<Airport> srcAirport68 = airportRepository.findById(15L);
            Optional<Airport> dstAirport68 = airportRepository.findById(14L);
            Connection connection68 = Connection.builder()
                    .srcAirport(srcAirport68.get())
                    .dstAirport(dstAirport68.get())
                    .build();
            connectionRepository.save(connection68);

            /** Z LOS ANGELES DO BERLINA **/
            Optional<Airport> srcAirport69 = airportRepository.findById(15L);
            Optional<Airport> dstAirport69 = airportRepository.findById(5L);
            Connection connection69 = Connection.builder()
                    .srcAirport(srcAirport69.get())
                    .dstAirport(dstAirport69.get())
                    .build();
            connectionRepository.save(connection69);

            /** Z BERLINA DO LOS ANGELES **/
            Optional<Airport> srcAirport70 = airportRepository.findById(5L);
            Optional<Airport> dstAirport70 = airportRepository.findById(15L);
            Connection connection70 = Connection.builder()
                    .srcAirport(srcAirport70.get())
                    .dstAirport(dstAirport70.get())
                    .build();
            connectionRepository.save(connection70);

            /** Z LOS ANGELES DO CHICAGO **/
            Optional<Airport> srcAirport71 = airportRepository.findById(15L);
            Optional<Airport> dstAirport71 = airportRepository.findById(2L);
            Connection connection71 = Connection.builder()
                    .srcAirport(srcAirport71.get())
                    .dstAirport(dstAirport71.get())
                    .build();
            connectionRepository.save(connection71);

            /** Z CHICAGO DO LOS ANGELES **/
            Optional<Airport> srcAirport72 = airportRepository.findById(2L);
            Optional<Airport> dstAirport72 = airportRepository.findById(15L);
            Connection connection72 = Connection.builder()
                    .srcAirport(srcAirport72.get())
                    .dstAirport(dstAirport72.get())
                    .build();
            connectionRepository.save(connection72);

            /** Z LOS ANGELES DO WARSZAWY **/
            Optional<Airport> srcAirport73 = airportRepository.findById(15L);
            Optional<Airport> dstAirport73 = airportRepository.findById(3L);
            Connection connection73 = Connection.builder()
                    .srcAirport(srcAirport73.get())
                    .dstAirport(dstAirport73.get())
                    .build();
            connectionRepository.save(connection73);

            /** Z WARSZAWY DO LOS ANGELES **/
            Optional<Airport> srcAirport74 = airportRepository.findById(3L);
            Optional<Airport> dstAirport74 = airportRepository.findById(15L);
            Connection connection74 = Connection.builder()
                    .srcAirport(srcAirport74.get())
                    .dstAirport(dstAirport74.get())
                    .build();
            connectionRepository.save(connection74);

            /** Z LOS ANGELES DO KIJOWA **/
            Optional<Airport> srcAirport75 = airportRepository.findById(15L);
            Optional<Airport> dstAirport75 = airportRepository.findById(20L);
            Connection connection75 = Connection.builder()
                    .srcAirport(srcAirport75.get())
                    .dstAirport(dstAirport75.get())
                    .build();
            connectionRepository.save(connection75);

            /** Z KIJOWA DO LOS ANGELES **/
            Optional<Airport> srcAirport76 = airportRepository.findById(20L);
            Optional<Airport> dstAirport76 = airportRepository.findById(15L);
            Connection connection76 = Connection.builder()
                    .srcAirport(srcAirport76.get())
                    .dstAirport(dstAirport76.get())
                    .build();
            connectionRepository.save(connection76);

            /** Z MOSKWY DO DELHI **/
            Optional<Airport> srcAirport77 = airportRepository.findById(16L);
            Optional<Airport> dstAirport77 = airportRepository.findById(19L);
            Connection connection77 = Connection.builder()
                    .srcAirport(srcAirport77.get())
                    .dstAirport(dstAirport77.get())
                    .build();
            connectionRepository.save(connection77);

            /** Z DELHI DO MOSKWY **/
            Optional<Airport> srcAirport78 = airportRepository.findById(19L);
            Optional<Airport> dstAirport78 = airportRepository.findById(16L);
            Connection connection78 = Connection.builder()
                    .srcAirport(srcAirport78.get())
                    .dstAirport(dstAirport78.get())
                    .build();
            connectionRepository.save(connection78);

            /** Z MOSKWY DO KRAKOWA **/
            Optional<Airport> srcAirport79 = airportRepository.findById(16L);
            Optional<Airport> dstAirport79 = airportRepository.findById(18L);
            Connection connection79 = Connection.builder()
                    .srcAirport(srcAirport79.get())
                    .dstAirport(dstAirport79.get())
                    .build();
            connectionRepository.save(connection79);

            /** Z KRAKOWA DO MOSKWY **/
            Optional<Airport> srcAirport80 = airportRepository.findById(18L);
            Optional<Airport> dstAirport80 = airportRepository.findById(16L);
            Connection connection80 = Connection.builder()
                    .srcAirport(srcAirport80.get())
                    .dstAirport(dstAirport80.get())
                    .build();
            connectionRepository.save(connection80);

            /** Z MOSKWY DO NOWEGO YORKU **/
            Optional<Airport> srcAirport81 = airportRepository.findById(16L);
            Optional<Airport> dstAirport81 = airportRepository.findById(1L);
            Connection connection81 = Connection.builder()
                    .srcAirport(srcAirport81.get())
                    .dstAirport(dstAirport81.get())
                    .build();
            connectionRepository.save(connection81);

            /** Z NOWEGO YORKU DO MOSKWY **/
            Optional<Airport> srcAirport82 = airportRepository.findById(1L);
            Optional<Airport> dstAirport82 = airportRepository.findById(16L);
            Connection connection82 = Connection.builder()
                    .srcAirport(srcAirport82.get())
                    .dstAirport(dstAirport82.get())
                    .build();
            connectionRepository.save(connection82);

            /** Z MOSKWY DO WARSZAWY **/
            Optional<Airport> srcAirport83 = airportRepository.findById(16L);
            Optional<Airport> dstAirport83 = airportRepository.findById(3L);
            Connection connection83 = Connection.builder()
                    .srcAirport(srcAirport83.get())
                    .dstAirport(dstAirport83.get())
                    .build();
            connectionRepository.save(connection83);

            /** Z WARSZAWY DO MOSKWY **/
            Optional<Airport> srcAirport84 = airportRepository.findById(3L);
            Optional<Airport> dstAirport84 = airportRepository.findById(16L);
            Connection connection84 = Connection.builder()
                    .srcAirport(srcAirport84.get())
                    .dstAirport(dstAirport84.get())
                    .build();
            connectionRepository.save(connection84);

            /** Z MOSKWY DO LOS ANGELES **/
            Optional<Airport> srcAirport85 = airportRepository.findById(16L);
            Optional<Airport> dstAirport85 = airportRepository.findById(15L);
            Connection connection85 = Connection.builder()
                    .srcAirport(srcAirport85.get())
                    .dstAirport(dstAirport85.get())
                    .build();
            connectionRepository.save(connection85);

            /** Z LOS ANGELES DO MOSKWY **/
            Optional<Airport> srcAirport86 = airportRepository.findById(15L);
            Optional<Airport> dstAirport86 = airportRepository.findById(16L);
            Connection connection86 = Connection.builder()
                    .srcAirport(srcAirport86.get())
                    .dstAirport(dstAirport86.get())
                    .build();
            connectionRepository.save(connection86);

            /** Z KAIRU DO DELHI **/
            Optional<Airport> srcAirport87 = airportRepository.findById(17L);
            Optional<Airport> dstAirport87 = airportRepository.findById(19L);
            Connection connection87 = Connection.builder()
                    .srcAirport(srcAirport87.get())
                    .dstAirport(dstAirport87.get())
                    .build();
            connectionRepository.save(connection87);

            /** Z DELHI DO KAIRU **/
            Optional<Airport> srcAirport88 = airportRepository.findById(19L);
            Optional<Airport> dstAirport88 = airportRepository.findById(17L);
            Connection connection88 = Connection.builder()
                    .srcAirport(srcAirport88.get())
                    .dstAirport(dstAirport88.get())
                    .build();
            connectionRepository.save(connection88);

            /** Z KAIRU DO KRAKOWA **/
            Optional<Airport> srcAirport89 = airportRepository.findById(17L);
            Optional<Airport> dstAirport89 = airportRepository.findById(18L);
            Connection connection89 = Connection.builder()
                    .srcAirport(srcAirport89.get())
                    .dstAirport(dstAirport89.get())
                    .build();
            connectionRepository.save(connection89);

            /** Z KRAKOWA DO KAIRU **/
            Optional<Airport> srcAirport90 = airportRepository.findById(18L);
            Optional<Airport> dstAirport90 = airportRepository.findById(17L);
            Connection connection90 = Connection.builder()
                    .srcAirport(srcAirport90.get())
                    .dstAirport(dstAirport90.get())
                    .build();
            connectionRepository.save(connection90);

            /** Z KRAKOWA DO DELHI **/
            Optional<Airport> srcAirport91 = airportRepository.findById(18L);
            Optional<Airport> dstAirport91 = airportRepository.findById(19L);
            Connection connection91 = Connection.builder()
                    .srcAirport(srcAirport91.get())
                    .dstAirport(dstAirport91.get())
                    .build();
            connectionRepository.save(connection91);

            /** Z DELHI DO KRAKOWA **/
            Optional<Airport> srcAirport92 = airportRepository.findById(19L);
            Optional<Airport> dstAirport92 = airportRepository.findById(18L);
            Connection connection92 = Connection.builder()
                    .srcAirport(srcAirport92.get())
                    .dstAirport(dstAirport92.get())
                    .build();
            connectionRepository.save(connection92);

            /** Z KRAKOWA DO KIJOWA **/
            Optional<Airport> srcAirport93 = airportRepository.findById(18L);
            Optional<Airport> dstAirport93 = airportRepository.findById(20L);
            Connection connection93 = Connection.builder()
                    .srcAirport(srcAirport93.get())
                    .dstAirport(dstAirport93.get())
                    .build();
            connectionRepository.save(connection93);

            /** Z KIJOWA DO KRAKOWA **/
            Optional<Airport> srcAirport94 = airportRepository.findById(20L);
            Optional<Airport> dstAirport94 = airportRepository.findById(18L);
            Connection connection94 = Connection.builder()
                    .srcAirport(srcAirport94.get())
                    .dstAirport(dstAirport94.get())
                    .build();
            connectionRepository.save(connection94);

            /** Z KRAKOWA DO NOWEGO YORKU **/
            Optional<Airport> srcAirport95 = airportRepository.findById(18L);
            Optional<Airport> dstAirport95 = airportRepository.findById(1L);
            Connection connection95 = Connection.builder()
                    .srcAirport(srcAirport95.get())
                    .dstAirport(dstAirport95.get())
                    .build();
            connectionRepository.save(connection95);

            /** Z NOWEGO YORKU DO KRAKOWA **/
            Optional<Airport> srcAirport96 = airportRepository.findById(1L);
            Optional<Airport> dstAirport96 = airportRepository.findById(18L);
            Connection connection96 = Connection.builder()
                    .srcAirport(srcAirport96.get())
                    .dstAirport(dstAirport96.get())
                    .build();
            connectionRepository.save(connection96);

            /** Z DELHI DO KIJOWA **/
            Optional<Airport> srcAirport97 = airportRepository.findById(19L);
            Optional<Airport> dstAirport97 = airportRepository.findById(20L);
            Connection connection97 = Connection.builder()
                    .srcAirport(srcAirport97.get())
                    .dstAirport(dstAirport97.get())
                    .build();
            connectionRepository.save(connection97);

            /** Z KIJOWA DO DELHI **/
            Optional<Airport> srcAirport98 = airportRepository.findById(20L);
            Optional<Airport> dstAirport98 = airportRepository.findById(19L);
            Connection connection98 = Connection.builder()
                    .srcAirport(srcAirport98.get())
                    .dstAirport(dstAirport98.get())
                    .build();
            connectionRepository.save(connection98);

            /** Z KIJOWA DO NOWEGO YORKU **/
            Optional<Airport> srcAirport99 = airportRepository.findById(20L);
            Optional<Airport> dstAirport99 = airportRepository.findById(1L);
            Connection connection99 = Connection.builder()
                    .srcAirport(srcAirport99.get())
                    .dstAirport(dstAirport99.get())
                    .build();
            connectionRepository.save(connection99);

            /** Z NOWEGO YORKU DO KIJOWA **/
            Optional<Airport> srcAirport100 = airportRepository.findById(1L);
            Optional<Airport> dstAirport100 = airportRepository.findById(20L);
            Connection connection100 = Connection.builder()
                    .srcAirport(srcAirport100.get())
                    .dstAirport(dstAirport100.get())
                    .build();
            connectionRepository.save(connection100);



        }
    }

}

