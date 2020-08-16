package flight_booking.backend.loaders;

import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Connection.ConnectionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import flight_booking.backend.models.Airport.AirportRepository;
import flight_booking.backend.models.Times;


import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
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

            Optional<Airport> srcAirport1 = airportRepository.findById(2L);
            Optional<Airport> dstAirport1 = airportRepository.findById(3L);
            Connection connection1 = Connection.builder()
                    .srcAirport(srcAirport1.get())
                    .dstAirport(dstAirport1.get())
                    .build();
            connectionRepository.save(connection1);

            Optional<Airport> srcAirport2 = airportRepository.findById(1L);
            Optional<Airport> dstAirport2 = airportRepository.findById(4L);
            Connection connection2 = Connection.builder()
                    .srcAirport(srcAirport2.get())
                    .dstAirport(dstAirport2.get())
                    .build();
            connectionRepository.save(connection2);

            Optional<Airport> srcAirport3 = airportRepository.findById(3L);
            Optional<Airport> dstAirport3 = airportRepository.findById(4L);
            Connection connection3 = Connection.builder()
                    .srcAirport(srcAirport3.get())
                    .dstAirport(dstAirport3.get())
                    .build();
            connectionRepository.save(connection3);

            Optional<Airport> srcAirport4 = airportRepository.findById(1L);
            Optional<Airport> dstAirport4 = airportRepository.findById(3L);
            Connection connection4 = Connection.builder()
                    .srcAirport(srcAirport4.get())
                    .dstAirport(dstAirport4.get())
                    .build();
            connectionRepository.save(connection4);

            Optional<Airport> srcAirport5 = airportRepository.findById(2L);
            Optional<Airport> dstAirport5 = airportRepository.findById(3L);
            Connection connection5 = Connection.builder()
                    .srcAirport(srcAirport5.get())
                    .dstAirport(dstAirport5.get())
                    .build();
            connectionRepository.save(connection5);
        }
    }

}

