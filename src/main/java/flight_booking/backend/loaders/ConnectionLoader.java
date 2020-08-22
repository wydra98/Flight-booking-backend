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



//            Optional<Airport> srcAirport2 = airportRepository.findById(1L);
//            Optional<Airport> dstAirport2 = airportRepository.findById(4L);
//            Connection connection2 = Connection.builder()
//                    .srcAirport(srcAirport2.get())
//                    .dstAirport(dstAirport2.get())
//                    .build();
//            connectionRepository.save(connection2);
//
//            Optional<Airport> srcAirport3 = airportRepository.findById(2L);
//            Optional<Airport> dstAirport3 = airportRepository.findById(5L);
//            Connection connection3 = Connection.builder()
//                    .srcAirport(srcAirport3.get())
//                    .dstAirport(dstAirport3.get())
//                    .build();
//            connectionRepository.save(connection3);
//
//            Optional<Airport> srcAirport4 = airportRepository.findById(1L);
//            Optional<Airport> dstAirport4 = airportRepository.findById(3L);
//            Connection connection4 = Connection.builder()
//                    .srcAirport(srcAirport4.get())
//                    .dstAirport(dstAirport4.get())
//                    .build();
//            connectionRepository.save(connection4);
//
//            Optional<Airport> srcAirport5 = airportRepository.findById(1L);
//            Optional<Airport> dstAirport5 = airportRepository.findById(5L);
//            Connection connection5 = Connection.builder()
//                    .srcAirport(srcAirport5.get())
//                    .dstAirport(dstAirport5.get())
//                    .build();
//            connectionRepository.save(connection5);
//
//            Optional<Airport> srcAirport6 = airportRepository.findById(2L);
//            Optional<Airport> dstAirport6 = airportRepository.findById(4L);
//            Connection connection6 = Connection.builder()
//                    .srcAirport(srcAirport6.get())
//                    .dstAirport(dstAirport6.get())
//                    .build();
//            connectionRepository.save(connection6);
//
//            Optional<Airport> srcAirport7 = airportRepository.findById(3L);
//            Optional<Airport> dstAirport7 = airportRepository.findById(4L);
//            Connection connection7 = Connection.builder()
//                    .srcAirport(srcAirport7.get())
//                    .dstAirport(dstAirport7.get())
//                    .build();
//            connectionRepository.save(connection7);
//
//            Optional<Airport> srcAirport8 = airportRepository.findById(3L);
//            Optional<Airport> dstAirport8 = airportRepository.findById(8L);
//            Connection connection8 = Connection.builder()
//                    .srcAirport(srcAirport8.get())
//                    .dstAirport(dstAirport8.get())
//                    .build();
//            connectionRepository.save(connection8);
//
//            Optional<Airport> srcAirport9 = airportRepository.findById(3L);
//            Optional<Airport> dstAirport9 = airportRepository.findById(2L);
//            Connection connection9 = Connection.builder()
//                    .srcAirport(srcAirport9.get())
//                    .dstAirport(dstAirport9.get())
//                    .build();
//            connectionRepository.save(connection9);
//
//            Optional<Airport> srcAirport10 = airportRepository.findById(5L);
//            Optional<Airport> dstAirport10 = airportRepository.findById(6L);
//            Connection connection10 = Connection.builder()
//                    .srcAirport(srcAirport10.get())
//                    .dstAirport(dstAirport10.get())
//                    .build();
//            connectionRepository.save(connection10);
//
//            Optional<Airport> srcAirport11 = airportRepository.findById(5L);
//            Optional<Airport> dstAirport11 = airportRepository.findById(7L);
//            Connection connection11 = Connection.builder()
//                    .srcAirport(srcAirport11.get())
//                    .dstAirport(dstAirport11.get())
//                    .build();
//            connectionRepository.save(connection11);
//
//            Optional<Airport> srcAirport12 = airportRepository.findById(7L);
//            Optional<Airport> dstAirport12 = airportRepository.findById(4L);
//            Connection connection12 = Connection.builder()
//                    .srcAirport(srcAirport12.get())
//                    .dstAirport(dstAirport12.get())
//                    .build();
//            connectionRepository.save(connection12);
//
//            Optional<Airport> srcAirport13 = airportRepository.findById(7L);
//            Optional<Airport> dstAirport13 = airportRepository.findById(8L);
//            Connection connection13 = Connection.builder()
//                    .srcAirport(srcAirport13.get())
//                    .dstAirport(dstAirport13.get())
//                    .build();
//            connectionRepository.save(connection13);
//
//            Optional<Airport> srcAirport14 = airportRepository.findById(5L);
//            Optional<Airport> dstAirport14 = airportRepository.findById(8L);
//            Connection connection14 = Connection.builder()
//                    .srcAirport(srcAirport14.get())
//                    .dstAirport(dstAirport14.get())
//                    .build();
//            connectionRepository.save(connection14);
//
//            Optional<Airport> srcAirport15 = airportRepository.findById(5L);
//            Optional<Airport> dstAirport15 = airportRepository.findById(4L);
//            Connection connection15 = Connection.builder()
//                    .srcAirport(srcAirport15.get())
//                    .dstAirport(dstAirport15.get())
//                    .build();
//            connectionRepository.save(connection15);

        }
    }

}

