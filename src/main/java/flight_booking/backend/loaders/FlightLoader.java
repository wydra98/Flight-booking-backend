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


            /****************** Z NOWEGO YORKU DO CHICAGO **********************/
            Optional<Airline> airline1 = airlineRepository.findById(3L);
            Optional<Connection> connection1 = connectionRepository.findById(1L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(airline1.get())
                        .numberSeats(120)
                        .price(225)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("04:30:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("10:30:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(airline1.get())
                        .numberSeats(205)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("14:30:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("20:30:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(airline1.get())
                        .numberSeats(265)
                        .price(175)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("21:30:00"))
                                .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                .arrivalTime(LocalTime.parse("03:30:00"))
                                .build())
                        .build());
            }


            /****************** Z CHICAGO DO NOWEGO YORKU ***********************/
            Optional<Airline> airline2 = airlineRepository.findById(3L);
            Optional<Connection> connection2 = connectionRepository.findById(2L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection2.get())
                        .airline(airline2.get())
                        .numberSeats(125)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("07:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("13:00:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection2.get())
                        .airline(airline2.get())
                        .numberSeats(255)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("18:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                .arrivalTime(LocalTime.parse("00:00:00"))
                                .build())
                        .build());
            }


            /****************** Z NOWEGO YORKU DO WARSZAWY ***********************/
            Optional<Airline> airline3 = airlineRepository.findById(3L);
            Optional<Connection> connection3 = connectionRepository.findById(3L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection3.get())
                        .airline(airline3.get())
                        .numberSeats(100)
                        .price(350)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("09:30:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("19:00:00"))
                                .build())
                        .build());
            }


            /******************** Z WARSZAWY DO NOWEGO YORKU *********************/
            Optional<Airline> airline4 = airlineRepository.findById(1L);
            Optional<Connection> connection4 = connectionRepository.findById(4L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection4.get())
                        .airline(airline4.get())
                        .numberSeats(180)
                        .price(340)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("20:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                .arrivalTime(LocalTime.parse("05:00:00"))
                                .build())
                        .build());
            }


            /********************* Z NOWEGO YORKU DO PEKINU *********************/
            Optional<Airline> airline5 = airlineRepository.findById(3L);
            Optional<Connection> connection5 = connectionRepository.findById(5L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection5.get())
                            .airline(airline5.get())
                            .numberSeats(190)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            /******************** Z PEKINU DO NOWEGO YORKU *********************/
            Optional<Airline> airline6 = airlineRepository.findById(4L);
            Optional<Connection> connection6 = connectionRepository.findById(6L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection6.get())
                        .airline(airline6.get())
                        .numberSeats(260)
                        .price(575)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("20:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                .arrivalTime(LocalTime.parse("08:00:00"))
                                .build())
                        .build());
            }


            /************************ Z PEKINU DO CHICAGO **********************/
            Optional<Airline> airline7 = airlineRepository.findById(4L);
            Optional<Connection> connection7 = connectionRepository.findById(7L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection7.get())
                        .airline(airline7.get())
                        .numberSeats(150)
                        .price(555)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("08:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("18:00:00"))
                                .build())
                        .build());
            }


            /*********************** Z CHICAGO DO PEKINU ***********************/
            Optional<Airline> airline8 = airlineRepository.findById(2L);
            Optional<Connection> connection8 = connectionRepository.findById(8L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection8.get())
                        .airline(airline8.get())
                        .numberSeats(200)
                        .price(560)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("23:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z PEKINU DO WARSZAWY ***********************/
            Optional<Airline> airline9 = airlineRepository.findById(4L);
            Optional<Connection> connection9 = connectionRepository.findById(9L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection9.get())
                        .airline(airline9.get())
                        .numberSeats(200)
                        .price(560)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("03:30:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("16:30:00"))
                                .build())
                        .build());
            }

            /***********************  Z WARSZAWY DO PEKINU ***********************/
            Optional<Airline> airline10 = airlineRepository.findById(1L);
            Optional<Connection> connection10 = connectionRepository.findById(10L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection10.get())
                        .airline(airline10.get())
                        .numberSeats(120)
                        .price(450)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("19:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                .arrivalTime(LocalTime.parse("04:00:00"))
                                .build())
                        .build());
            }


            /*********************** Z CHICAGO DO BERLINU ***********************/
            Optional<Airline> airline11 = airlineRepository.findById(3L);
            Optional<Connection> connection11 = connectionRepository.findById(11L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection11.get())
                        .airline(airline11.get())
                        .numberSeats(180)
                        .price(375)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("10:45:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("19:45:00"))
                                .build())
                        .build());
            }


            /*********************** Z BERLINU DO CHICAGO ***********************/
            Optional<Airline> airline12 = airlineRepository.findById(2L);
            Optional<Connection> connection12 = connectionRepository.findById(12L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection12.get())
                        .airline(airline12.get())
                        .numberSeats(130)
                        .price(400)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("15:15:00"))
                                .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                .arrivalTime(LocalTime.parse("00:15:00"))
                                .build())
                        .build());
            }


            /*********************** Z WARSZAWY DO BERLINA ***********************/
            Optional<Airline> airline13 = airlineRepository.findById(1L);
            Optional<Connection> connection13 = connectionRepository.findById(13L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(airline13.get())
                            .numberSeats(140)
                            .price(125)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("13:00:00"))
                                    .build())
                            .build());

                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(airline13.get())
                            .numberSeats(120)
                            .price(125)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("21:00:00"))
                                    .build())
                            .build());
                } else {

                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(airline13.get())
                            .numberSeats(140)
                            .price(155)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("17:00:00"))
                                    .build())
                            .build());
                }
            }


            /*********************** Z BERLINA DO WARSZAWY  ***********************/
            Optional<Airline> airline14 = airlineRepository.findById(2L);
            Optional<Connection> connection14 = connectionRepository.findById(14L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection14.get())
                            .airline(airline14.get())
                            .numberSeats(160)
                            .price(110)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("10:45:00"))
                                    .build())
                            .build());
                } else {
                    flightRepository.save(Flight.builder()
                            .connection(connection14.get())
                            .airline(airline2.get())
                            .numberSeats(160)
                            .price(110)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("14:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("16:45:00"))
                                    .build())
                            .build());
                }
            }


            /*********************** Z WARSZAWY DO CHICAGO ***********************/
            Optional<Airline> airline15 = airlineRepository.findById(1L);
            Optional<Connection> connection15 = connectionRepository.findById(15L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 != 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection15.get())
                            .airline(airline15.get())
                            .numberSeats(250)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("15:30:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("00:30:00"))
                                    .build())
                            .build());
                }
            }


            /*********************** Z CHICAGO DO WARSZAWY ***********************/
            Optional<Airline> airline16 = airlineRepository.findById(3L);
            Optional<Connection> connection16 = connectionRepository.findById(16L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection16.get())
                        .airline(airline16.get())
                        .numberSeats(125)
                        .price(120)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                .arrivalTime(LocalTime.parse("20:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z SZANGHAJU DO NOWEGO YORKU ***********************/
            Optional<Airline> airline17 = airlineRepository.findById(4L);
            Optional<Connection> connection17 = connectionRepository.findById(17L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 != 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection17.get())
                            .airline(airline17.get())
                            .numberSeats(225)
                            .price(520)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .departureTime(LocalTime.parse("12:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("00:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z NOWEGO YORKU DO SZANGHAJU ***********************/
            Optional<Airline> airline18 = airlineRepository.findById(3L);
            Optional<Connection> connection18 = connectionRepository.findById(18L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection18.get())
                            .airline(airline18.get())
                            .numberSeats(200)
                            .price(530)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("22:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SZANGHAJU DO PEKINU ***********************/
            Optional<Airline> airline19 = airlineRepository.findById(4L);
            Optional<Connection> connection19 = connectionRepository.findById(19L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection19.get())
                            .airline(airline19.get())
                            .numberSeats(150)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("12:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("13:00:00"))
                                    .build())
                            .build());
            }

            /*********************** Z PEKINU DO SZANGHAJU ***********************/
            Optional<Airline> airline20 = airlineRepository.findById(4L);
            Optional<Connection> connection20 = connectionRepository.findById(20L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection20.get())
                            .airline(airline20.get())
                            .numberSeats(150)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("18:45:00"))
                                    .build())
                            .build());
            }

            /*********************** Z SZANGHAJU DO TORONTO ***********************/
            Optional<Airline> airline21 = airlineRepository.findById(4L);
            Optional<Connection> connection21 = connectionRepository.findById(21L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%5 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection21.get())
                            .airline(airline21.get())
                            .numberSeats(180)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-04")).plusDays(i))
                                    .departureTime(LocalTime.parse("17:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-05")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO SZANGHAJU ***********************/
            Optional<Airline> airline22 = airlineRepository.findById(5L);
            Optional<Connection> connection22 = connectionRepository.findById(22L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection22.get())
                            .airline(airline22.get())
                            .numberSeats(180)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-04")).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-04")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("18:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SZANGHAJU DO SYDNEY ***********************/
            Optional<Airline> airline23 = airlineRepository.findById(4L);
            Optional<Connection> connection23 = connectionRepository.findById(23L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%7 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection23.get())
                            .airline(airline23.get())
                            .numberSeats(150)
                            .price(250)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("09:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("14:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SYDNEY DO SZANGHAJU ***********************/
            Optional<Airline> airline24 = airlineRepository.findById(6L);
            Optional<Connection> connection24 = connectionRepository.findById(24L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection24.get())
                            .airline(airline24.get())
                            .numberSeats(200)
                            .price(230)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("20:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO PEKINU ***********************/
            Optional<Airline> airline25 = airlineRepository.findById(5L);
            Optional<Connection> connection25 = connectionRepository.findById(25L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%4 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection25.get())
                            .airline(airline25.get())
                            .numberSeats(200)
                            .price(405)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .departureTime(LocalTime.parse("14:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z PEKINU DO TORONTO ***********************/
            Optional<Airline> airline26 = airlineRepository.findById(4L);
            Optional<Connection> connection26 = connectionRepository.findById(26L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%4 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection26.get())
                            .airline(airline26.get())
                            .numberSeats(200)
                            .price(405)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-04")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("20:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO CHICAGO ***********************/
            Optional<Airline> airline27 = airlineRepository.findById(5L);
            Optional<Connection> connection27 = connectionRepository.findById(27L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection27.get())
                            .airline(airline27.get())
                            .numberSeats(90)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .departureTime(LocalTime.parse("13:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("18:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z CHICAGO DO TORONTO ***********************/
            Optional<Airline> airline28 = airlineRepository.findById(3L);
            Optional<Connection> connection28 = connectionRepository.findById(28L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection28.get())
                            .airline(airline28.get())
                            .numberSeats(100)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .departureTime(LocalTime.parse("14:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("19:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO SYDNEY ***********************/
            Optional<Airline> airline29 = airlineRepository.findById(5L);
            Optional<Connection> connection29 = connectionRepository.findById(29L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%3 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection29.get())
                            .airline(airline29.get())
                            .numberSeats(250)
                            .price(600)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .departureTime(LocalTime.parse("10:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-03")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SYDNEY DO TORONTO ***********************/
            Optional<Airline> airline30 = airlineRepository.findById(6L);
            Optional<Connection> connection30 = connectionRepository.findById(30L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%3 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection30.get())
                            .airline(airline30.get())
                            .numberSeats(250)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-15")).plusDays(i))
                                    .departureTime(LocalTime.parse("05:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-15")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("20:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SYDNEY DO BERLINA ***********************/
            Optional<Airline> airline31 = airlineRepository.findById(6L);
            Optional<Connection> connection31 = connectionRepository.findById(31L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection31.get())
                            .airline(airline31.get())
                            .numberSeats(200)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("22:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("08:00:00"))
                                    .build())
                            .build());
            }

            /*********************** Z BERLINA DO SYDNEY ***********************/
            Optional<Airline> airline32 = airlineRepository.findById(2L);
            Optional<Connection> connection32 = connectionRepository.findById(32L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection32.get())
                            .airline(airline32.get())
                            .numberSeats(200)
                            .price(390)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("06:30:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("16:30:00"))
                                    .build())
                            .build());
            }

            /*********************** Z SYDNEY DO TOKIO ***********************/
            Optional<Airline> airline33 = airlineRepository.findById(6L);
            Optional<Connection> connection33 = connectionRepository.findById(33L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%5 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection33.get())
                            .airline(airline33.get())
                            .numberSeats(150)
                            .price(210)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("10:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("15:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TOKIO DO SYDNEY ***********************/
            Optional<Airline> airline34 = airlineRepository.findById(7L);
            Optional<Connection> connection34 = connectionRepository.findById(34L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%5 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection34.get())
                            .airline(airline34.get())
                            .numberSeats(150)
                            .price(210)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("18:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("23:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TOKIO DO BERLINA ***********************/
            Optional<Airline> airline35 = airlineRepository.findById(7L);
            Optional<Connection> connection35 = connectionRepository.findById(34L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%3 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection35.get())
                            .airline(airline35.get())
                            .numberSeats(170)
                            .price(370)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("14:15:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("01:30:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z BERLINA DO TOKIO ***********************/
            Optional<Airline> airline36 = airlineRepository.findById(2L);
            Optional<Connection> connection36 = connectionRepository.findById(34L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%2 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection36.get())
                            .airline(airline36.get())
                            .numberSeats(150)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("04:15:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("14:30:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TOKIO DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline37 = airlineRepository.findById(7L);
            Optional<Connection> connection37 = connectionRepository.findById(34L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%3 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection37.get())
                            .airline(airline37.get())
                            .numberSeats(200)
                            .price(620)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("08:15:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z RIO DE JANEIRO DO TOKIO ***********************/
            Optional<Airline> airline38 = airlineRepository.findById(8L);
            Optional<Connection> connection38 = connectionRepository.findById(34L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if(i%3 == 0){
                    flightRepository.save(Flight.builder()
                            .connection(connection38.get())
                            .airline(airline38.get())
                            .numberSeats(200)
                            .price(620)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("23:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z RIO DE JANEIRO DO BERLINA ***********************/
            Optional<Airline> airline39 = airlineRepository.findById(8L);
            Optional<Connection> connection39 = connectionRepository.findById(35L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection39.get())
                            .airline(airline39.get())
                            .numberSeats(160)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("08:15:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("20:15:00"))
                                    .build())
                            .build());
            }

            /*********************** Z BERLINA DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline40 = airlineRepository.findById(2L);
            Optional<Connection> connection40 = connectionRepository.findById(36L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection40.get())
                            .airline(airline40.get())
                            .numberSeats(160)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse("2020-09-01")).plusDays(i))
                                    .departureTime(LocalTime.parse("21:00:00"))
                                    .arrivalDate((LocalDate.parse("2020-09-02")).plusDays(i))
                                    .arrivalTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
            }
        }
    }
}