package flight_booking.backend.loaders;

import flight_booking.backend.models.Airlines.Airline;
import flight_booking.backend.models.Airlines.AirlineRepository;
import flight_booking.backend.models.Connections.Connection;
import flight_booking.backend.models.Connections.ConnectionRepository;
import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Flights.FlightRepository;
import flight_booking.backend.models.Times;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Component
public class FlightLoader implements CommandLineRunner {

    ConnectionRepository connectionRepository;
    AirlineRepository airlineRepository;
    FlightRepository flightRepository;
    private static int MAX_DAYS_TO_LOAD = 365;

    FlightLoader(ConnectionRepository connectionRepository,
                 AirlineRepository airlineRepository,
                 FlightRepository flightRepository) {
        this.connectionRepository = connectionRepository;
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (flightRepository.amountOfRows() == 0) {

            Optional<Airline> srcAirline1 = airlineRepository.findById(1L);
            Optional<Airline> srcAirline2 = airlineRepository.findById(2L);

            /****************** Z NOWEGO YORKU DO CHICAGO **********************/
            Optional<Connection> connection1 = connectionRepository.findById(1L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(srcAirline2.get())
                        .numberSeats(120)
                        .price(225)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("04:30:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("10:30:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(srcAirline2.get())
                        .numberSeats(205)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("14:30:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("20:30:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(srcAirline1.get())
                        .numberSeats(265)
                        .price(175)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("21:30:00"))
                                .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                .arrivalTime(LocalTime.parse("03:30:00"))
                                .build())
                        .build());
            }


            /****************** Z CHICAGO DO NOWEGO YORKU ***********************/
            Optional<Connection> connection2 = connectionRepository.findById(2L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection2.get())
                        .airline(srcAirline2.get())
                        .numberSeats(125)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("07:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("13:00:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection2.get())
                        .airline(srcAirline2.get())
                        .numberSeats(255)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("18:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                .arrivalTime(LocalTime.parse("00:00:00"))
                                .build())
                        .build());
            }


            /****************** Z NOWEGO YORKU DO WARSZAWY ***********************/
            Optional<Connection> connection3 = connectionRepository.findById(3L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection3.get())
                        .airline(srcAirline2.get())
                        .numberSeats(100)
                        .price(350)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("09:30:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("19:00:00"))
                                .build())
                        .build());
            }


            /******************** Z WARSZAWY DO NOWEGO YORKU *********************/
            Optional<Connection> connection4 = connectionRepository.findById(4L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection4.get())
                        .airline(srcAirline2.get())
                        .numberSeats(180)
                        .price(340)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("20:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                .arrivalTime(LocalTime.parse("05:00:00"))
                                .build())
                        .build());
            }


            /********************* Z NOWEGO YORKU DO PEKINU *********************/
            Optional<Connection> connection5 = connectionRepository.findById(5L);
            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2==0){
                    flightRepository.save(Flight.builder()
                            .connection(connection5.get())
                            .airline(srcAirline2.get())
                            .numberSeats(190)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                    .arrivalTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            /******************** Z PEKINU DO NOWEGO YORKU *********************/
            Optional<Connection> connection6 = connectionRepository.findById(6L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection6.get())
                        .airline(srcAirline2.get())
                        .numberSeats(260)
                        .price(575)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("20:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                .arrivalTime(LocalTime.parse("08:00:00"))
                                .build())
                        .build());
            }



            /************************ Z PEKINU DO CHICAGO **********************/
            Optional<Connection> connection7 = connectionRepository.findById(7L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection7.get())
                        .airline(srcAirline2.get())
                        .numberSeats(150)
                        .price(555)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("08:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("18:00:00"))
                                .build())
                        .build());
            }


            /*********************** Z CHICAGO DO PEKINU ***********************/
            Optional<Connection> connection8 = connectionRepository.findById(8L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection8.get())
                        .airline(srcAirline2.get())
                        .numberSeats(200)
                        .price(560)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("23:00:00"))
                                .build())
                        .build());
            }


            /***********************  Z WARSZAWY DO PEKINU ***********************/
            Optional<Connection> connection10 = connectionRepository.findById(10L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection10.get())
                        .airline(srcAirline2.get())
                        .numberSeats(120)
                        .price(450)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("19:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                .arrivalTime(LocalTime.parse("04:00:00"))
                                .build())
                        .build());
            }


            /*********************** Z CHICAGO DO BERLINU ***********************/
            Optional<Connection> connection11 = connectionRepository.findById(11L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection11.get())
                        .airline(srcAirline2.get())
                        .numberSeats(180)
                        .price(375)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("10:45:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .arrivalTime(LocalTime.parse("19:45:00"))
                                .build())
                        .build());
            }


            /*********************** Z BERLINU DO CHICAGO ***********************/
            Optional<Connection> connection12 = connectionRepository.findById(12L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection12.get())
                        .airline(srcAirline2.get())
                        .numberSeats(130)
                        .price(400)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                .departureTime(LocalTime.parse("15:15:00"))
                                .arrivalDate(LocalDate.parse("2020-09-02").plusDays(i))
                                .arrivalTime(LocalTime.parse("00:15:00"))
                                .build())
                        .build());
            }


            /*********************** Z WARSZAWY DO BERLINA ***********************/
            Optional<Connection> connection13 = connectionRepository.findById(13L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2==0){
                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(srcAirline2.get())
                            .numberSeats(140)
                            .price(125)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .arrivalTime(LocalTime.parse("13:00:00"))
                                    .build())
                            .build());

                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(srcAirline2.get())
                            .numberSeats(120)
                            .price(125)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .arrivalTime(LocalTime.parse("21:00:00"))
                                    .build())
                            .build());
                }
                else{

                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(srcAirline2.get())
                            .numberSeats(140)
                            .price(155)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .arrivalTime(LocalTime.parse("17:00:00"))
                                    .build())
                            .build());
                }
            }


            /*********************** Z BERLINA DO WARSZAWY  ***********************/
            Optional<Connection> connection14 = connectionRepository.findById(14L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2==0){
                    flightRepository.save(Flight.builder()
                            .connection(connection14.get())
                            .airline(srcAirline2.get())
                            .numberSeats(160)
                            .price(110)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .arrivalTime(LocalTime.parse("10:45:00"))
                                    .build())
                            .build());
                }
                else{
                    flightRepository.save(Flight.builder()
                            .connection(connection14.get())
                            .airline(srcAirline2.get())
                            .numberSeats(160)
                            .price(110)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .departureTime(LocalTime.parse("14:45:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-01").plusDays(i))
                                    .arrivalTime(LocalTime.parse("16:45:00"))
                                    .build())
                            .build());
                }
            }


            /*********************** Z WARSZAWY DO CHICAGO ***********************/
            Optional<Connection> connection15 = connectionRepository.findById(15L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2!=0){
                    flightRepository.save(Flight.builder()
                            .connection(connection15.get())
                            .airline(srcAirline2.get())
                            .numberSeats(250)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate(LocalDate.parse("2020-09-01").plusDays(1))
                                    .departureTime(LocalTime.parse("15:30:00"))
                                    .arrivalDate(LocalDate.parse("2020-09-02").plusDays(1))
                                    .arrivalTime(LocalTime.parse("00:30:00"))
                                    .build())
                            .build());
                }
            }


            /*********************** Z CHICAGO DO WARSZAWY ***********************/
            Optional<Connection> connection16 = connectionRepository.findById(16L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection16.get())
                        .airline(srcAirline2.get())
                        .numberSeats(125)
                        .price(120)
                        .times(Times.
                                builder()
                                .departureDate(LocalDate.parse("2020-09-01").plusDays(1))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .arrivalDate(LocalDate.parse("2020-09-01").plusDays(1))
                                .arrivalTime(LocalTime.parse("20:00:00"))
                                .build())
                        .build());
            }
        }
    }
}