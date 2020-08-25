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
    private static String FIRST_DAY = "2020-09-01";

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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("04:30:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(airline1.get())
                        .numberSeats(205)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("14:30:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection1.get())
                        .airline(airline1.get())
                        .numberSeats(265)
                        .price(175)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("21:30:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("07:00:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());

                flightRepository.save(Flight.builder()
                        .connection(connection2.get())
                        .airline(airline2.get())
                        .numberSeats(255)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("18:00:00"))
                                .flightTime(LocalTime.parse("08:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("09:30:00"))
                                .flightTime(LocalTime.parse("09:30:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("20:00:00"))
                                .flightTime(LocalTime.parse("09:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("20:00:00"))
                                .flightTime(LocalTime.parse("12:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("08:00:00"))
                                .flightTime(LocalTime.parse("10:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .flightTime(LocalTime.parse("12:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("03:30:00"))
                                .flightTime(LocalTime.parse("13:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("19:00:00"))
                                .flightTime(LocalTime.parse("09:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("10:45:00"))
                                .flightTime(LocalTime.parse("09:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("15:15:00"))
                                .flightTime(LocalTime.parse("09:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());

                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(airline13.get())
                            .numberSeats(120)
                            .price(125)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:45:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:30:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .flightTime(LocalTime.parse("09:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
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
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:00:00"))
                                .flightTime(LocalTime.parse("01:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("17:45:00"))
                                .flightTime(LocalTime.parse("01:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z SZANGHAJU DO TORONTO ***********************/
            Optional<Airline> airline21 = airlineRepository.findById(4L);
            Optional<Connection> connection21 = connectionRepository.findById(21L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 5 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection21.get())
                            .airline(airline21.get())
                            .numberSeats(180)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO SZANGHAJU ***********************/
            Optional<Airline> airline22 = airlineRepository.findById(5L);
            Optional<Connection> connection22 = connectionRepository.findById(22L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection22.get())
                            .airline(airline22.get())
                            .numberSeats(180)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SZANGHAJU DO SYDNEY ***********************/
            Optional<Airline> airline23 = airlineRepository.findById(4L);
            Optional<Connection> connection23 = connectionRepository.findById(23L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 7 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection23.get())
                            .airline(airline23.get())
                            .numberSeats(150)
                            .price(250)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:00:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SYDNEY DO SZANGHAJU ***********************/
            Optional<Airline> airline24 = airlineRepository.findById(6L);
            Optional<Connection> connection24 = connectionRepository.findById(24L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection24.get())
                            .airline(airline24.get())
                            .numberSeats(200)
                            .price(230)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO PEKINU ***********************/
            Optional<Airline> airline25 = airlineRepository.findById(5L);
            Optional<Connection> connection25 = connectionRepository.findById(25L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 4 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection25.get())
                            .airline(airline25.get())
                            .numberSeats(200)
                            .price(405)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z PEKINU DO TORONTO ***********************/
            Optional<Airline> airline26 = airlineRepository.findById(4L);
            Optional<Connection> connection26 = connectionRepository.findById(26L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 4 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection26.get())
                            .airline(airline26.get())
                            .numberSeats(200)
                            .price(405)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO CHICAGO ***********************/
            Optional<Airline> airline27 = airlineRepository.findById(5L);
            Optional<Connection> connection27 = connectionRepository.findById(27L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection27.get())
                            .airline(airline27.get())
                            .numberSeats(90)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:00:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z CHICAGO DO TORONTO ***********************/
            Optional<Airline> airline28 = airlineRepository.findById(3L);
            Optional<Connection> connection28 = connectionRepository.findById(28L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection28.get())
                            .airline(airline28.get())
                            .numberSeats(100)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:45:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TORONTO DO SYDNEY ***********************/
            Optional<Airline> airline29 = airlineRepository.findById(5L);
            Optional<Connection> connection29 = connectionRepository.findById(29L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection29.get())
                            .airline(airline29.get())
                            .numberSeats(250)
                            .price(600)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:00:00"))
                                    .flightTime(LocalTime.parse("15:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z SYDNEY DO TORONTO ***********************/
            Optional<Airline> airline30 = airlineRepository.findById(6L);
            Optional<Connection> connection30 = connectionRepository.findById(30L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection30.get())
                            .airline(airline30.get())
                            .numberSeats(250)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:00:00"))
                                    .flightTime(LocalTime.parse("15:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("22:00:00"))
                                .flightTime(LocalTime.parse("10:00:00"))
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
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("06:30:00"))
                                .flightTime(LocalTime.parse("10:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z SYDNEY DO TOKIO ***********************/
            Optional<Airline> airline33 = airlineRepository.findById(6L);
            Optional<Connection> connection33 = connectionRepository.findById(33L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 5 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection33.get())
                            .airline(airline33.get())
                            .numberSeats(150)
                            .price(210)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:45:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TOKIO DO SYDNEY ***********************/
            Optional<Airline> airline34 = airlineRepository.findById(7L);
            Optional<Connection> connection34 = connectionRepository.findById(34L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 5 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection34.get())
                            .airline(airline34.get())
                            .numberSeats(150)
                            .price(210)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:00:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TOKIO DO BERLINA ***********************/
            Optional<Airline> airline35 = airlineRepository.findById(7L);
            Optional<Connection> connection35 = connectionRepository.findById(35L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection35.get())
                            .airline(airline35.get())
                            .numberSeats(170)
                            .price(370)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:15:00"))
                                    .flightTime(LocalTime.parse("11:15:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z BERLINA DO TOKIO ***********************/
            Optional<Airline> airline36 = airlineRepository.findById(2L);
            Optional<Connection> connection36 = connectionRepository.findById(36L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection36.get())
                            .airline(airline36.get())
                            .numberSeats(150)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:15:00"))
                                    .flightTime(LocalTime.parse("11:15:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z TOKIO DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline37 = airlineRepository.findById(7L);
            Optional<Connection> connection37 = connectionRepository.findById(37L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection37.get())
                            .airline(airline37.get())
                            .numberSeats(200)
                            .price(620)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .flightTime(LocalTime.parse("14:30:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z RIO DE JANEIRO DO TOKIO ***********************/
            Optional<Airline> airline38 = airlineRepository.findById(8L);
            Optional<Connection> connection38 = connectionRepository.findById(38L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection38.get())
                            .airline(airline38.get())
                            .numberSeats(200)
                            .price(620)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .flightTime(LocalTime.parse("14:30:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z RIO DE JANEIRO DO BERLINA ***********************/
            Optional<Airline> airline39 = airlineRepository.findById(8L);
            Optional<Connection> connection39 = connectionRepository.findById(39L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection39.get())
                        .airline(airline39.get())
                        .numberSeats(160)
                        .price(450)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("08:15:00"))
                                .flightTime(LocalTime.parse("12:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z BERLINA DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline40 = airlineRepository.findById(2L);
            Optional<Connection> connection40 = connectionRepository.findById(40L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection40.get())
                        .airline(airline40.get())
                        .numberSeats(160)
                        .price(450)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("21:00:00"))
                                .flightTime(LocalTime.parse("12:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z RIO DE JANEIRO DO LOS ANGELES ***********************/
            Optional<Airline> airline41 = airlineRepository.findById(8L);
            Optional<Connection> connection41 = connectionRepository.findById(41L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection41.get())
                            .airline(airline41.get())
                            .numberSeats(200)
                            .price(230)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:45:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z LOS ANGELES DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline42 = airlineRepository.findById(3L);
            Optional<Connection> connection42 = connectionRepository.findById(42L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection42.get())
                            .airline(airline42.get())
                            .numberSeats(200)
                            .price(260)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:45:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z RIO DE JANEIRO DO OSLO ***********************/
            Optional<Airline> airline43 = airlineRepository.findById(8L);
            Optional<Connection> connection43 = connectionRepository.findById(43L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 7 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection43.get())
                            .airline(airline43.get())
                            .numberSeats(200)
                            .price(470)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:30:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z OSLO DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline44 = airlineRepository.findById(9L);
            Optional<Connection> connection44 = connectionRepository.findById(44L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 7 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection44.get())
                            .airline(airline44.get())
                            .numberSeats(160)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:30:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z RIO DE JANEIRO DO BUENOS AIRES ***********************/
            Optional<Airline> airline45 = airlineRepository.findById(8L);
            Optional<Connection> connection45 = connectionRepository.findById(45L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection45.get())
                        .airline(airline45.get())
                        .numberSeats(150)
                        .price(120)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("11:45:00"))
                                .flightTime(LocalTime.parse("02:00:00"))
                                .build())
                        .build());
            }


            /*********************** Z BUENOS AIRES DO RIO DE JANEIRO ***********************/
            Optional<Airline> airline46 = airlineRepository.findById(8L);
            Optional<Connection> connection46 = connectionRepository.findById(46L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection46.get())
                        .airline(airline46.get())
                        .numberSeats(140)
                        .price(120)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("17:45:00"))
                                .flightTime(LocalTime.parse("02:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z OSLO DO BUENOS AIRES ***********************/
            Optional<Airline> airline47 = airlineRepository.findById(9L);
            Optional<Connection> connection47 = connectionRepository.findById(47L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection47.get())
                            .airline(airline47.get())
                            .numberSeats(80)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:30:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }

            }

            /*********************** Z BUENOS AIRES DO OSLO ***********************/
            Optional<Airline> airline48 = airlineRepository.findById(8L);
            Optional<Connection> connection48 = connectionRepository.findById(48L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection48.get())
                            .airline(airline48.get())
                            .numberSeats(100)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("01:15:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z OSLO DO PARYŻA ***********************/
            Optional<Airline> airline49 = airlineRepository.findById(9L);
            Optional<Connection> connection49 = connectionRepository.findById(49L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection49.get())
                        .airline(airline49.get())
                        .numberSeats(140)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:15:00"))
                                .flightTime(LocalTime.parse("01:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z PARYŻA DO OSLO ***********************/
            Optional<Airline> airline50 = airlineRepository.findById(10L);
            Optional<Connection> connection50 = connectionRepository.findById(50L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection50.get())
                        .airline(airline50.get())
                        .numberSeats(140)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("15:15:00"))
                                .flightTime(LocalTime.parse("01:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z OSLO DO LONDYNU ***********************/
            Optional<Airline> airline51 = airlineRepository.findById(9L);
            Optional<Connection> connection51 = connectionRepository.findById(51L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection51.get())
                        .airline(airline51.get())
                        .numberSeats(120)
                        .price(150)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:15:00"))
                                .flightTime(LocalTime.parse("01:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO OSLO ***********************/
            Optional<Airline> airline52 = airlineRepository.findById(11L);
            Optional<Connection> connection52 = connectionRepository.findById(52L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection52.get())
                        .airline(airline52.get())
                        .numberSeats(120)
                        .price(150)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("15:30:00"))
                                .flightTime(LocalTime.parse("02:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z OSLO DO LOS ANGELES ***********************/
            Optional<Airline> airline53 = airlineRepository.findById(9L);
            Optional<Connection> connection53 = connectionRepository.findById(53L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection53.get())
                            .airline(airline53.get())
                            .numberSeats(180)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:15:00"))
                                    .flightTime(LocalTime.parse("15:45:00"))
                                    .build())
                            .build());
                }

            }

            /*********************** Z LOS ANGELES DO OSLO ***********************/
            Optional<Airline> airline54 = airlineRepository.findById(3L);
            Optional<Connection> connection54 = connectionRepository.findById(54L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection54.get())
                            .airline(airline54.get())
                            .numberSeats(180)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:30:00"))
                                    .flightTime(LocalTime.parse("15:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z BUENOS AIRES DO PARYŻA ***********************/
            Optional<Airline> airline55 = airlineRepository.findById(8L);
            Optional<Connection> connection55 = connectionRepository.findById(55L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 4 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection55.get())
                            .airline(airline55.get())
                            .numberSeats(220)
                            .price(390)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:00:00"))
                                    .flightTime(LocalTime.parse("06:15:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z PARYŻA DO BUENOS AIRES ***********************/
            Optional<Airline> airline56 = airlineRepository.findById(10L);
            Optional<Connection> connection56 = connectionRepository.findById(56L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 4 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection56.get())
                            .airline(airline56.get())
                            .numberSeats(220)
                            .price(390)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:45:00"))
                                    .flightTime(LocalTime.parse("06:15:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z PARYŻA DO LONDYNU ***********************/
            Optional<Airline> airline57 = airlineRepository.findById(10L);
            Optional<Connection> connection57 = connectionRepository.findById(57L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection57.get())
                        .airline(airline57.get())
                        .numberSeats(130)
                        .price(100)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("07:00:00"))
                                .flightTime(LocalTime.parse("01:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO PARYŻA ***********************/
            Optional<Airline> airline58 = airlineRepository.findById(11L);
            Optional<Connection> connection58 = connectionRepository.findById(58L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection58.get())
                        .airline(airline58.get())
                        .numberSeats(130)
                        .price(100)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("16:00:00"))
                                .flightTime(LocalTime.parse("01:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO TORONTO ***********************/
            Optional<Airline> airline59 = airlineRepository.findById(11L);
            Optional<Connection> connection59 = connectionRepository.findById(59L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection59.get())
                        .airline(airline59.get())
                        .numberSeats(240)
                        .price(350)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("07:30:00"))
                                .flightTime(LocalTime.parse("07:15:00"))
                                .build())
                        .build());
            }


            /*********************** Z TORONTO DO LONDYNU ***********************/
            Optional<Airline> airline60 = airlineRepository.findById(5L);
            Optional<Connection> connection60 = connectionRepository.findById(60L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection60.get())
                        .airline(airline60.get())
                        .numberSeats(240)
                        .price(350)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("14:30:00"))
                                .flightTime(LocalTime.parse("07:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO KAIRU ***********************/
            Optional<Airline> airline61 = airlineRepository.findById(11L);
            Optional<Connection> connection61 = connectionRepository.findById(61L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection61.get())
                        .airline(airline61.get())
                        .numberSeats(160)
                        .price(320)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("04:15:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z KAIRU DO LONDYNU ***********************/
            Optional<Airline> airline62 = airlineRepository.findById(13L);
            Optional<Connection> connection62 = connectionRepository.findById(62L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection62.get())
                        .airline(airline62.get())
                        .numberSeats(160)
                        .price(320)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:30:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO MOSKWY ***********************/
            Optional<Airline> airline63 = airlineRepository.findById(11L);
            Optional<Connection> connection63 = connectionRepository.findById(63L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection63.get())
                        .airline(airline63.get())
                        .numberSeats(250)
                        .price(220)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("06:45:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z MOSKWY DO LONDYNU ***********************/
            Optional<Airline> airline64 = airlineRepository.findById(12L);
            Optional<Connection> connection64 = connectionRepository.findById(64L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection64.get())
                        .airline(airline64.get())
                        .numberSeats(250)
                        .price(220)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("09:30:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO WARSZAWY ***********************/
            Optional<Airline> airline65 = airlineRepository.findById(11L);
            Optional<Connection> connection65 = connectionRepository.findById(65L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection65.get())
                        .airline(airline65.get())
                        .numberSeats(190)
                        .price(150)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:15:00"))
                                .flightTime(LocalTime.parse("02:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z WARSZAWY DO LONDYNU ***********************/
            Optional<Airline> airline66 = airlineRepository.findById(1L);
            Optional<Connection> connection66 = connectionRepository.findById(66L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection66.get())
                        .airline(airline66.get())
                        .numberSeats(190)
                        .price(150)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("15:15:00"))
                                .flightTime(LocalTime.parse("02:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z LONDYNU DO LOS ANGELES ***********************/
            Optional<Airline> airline67 = airlineRepository.findById(11L);
            Optional<Connection> connection67 = connectionRepository.findById(67L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 != 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection67.get())
                            .airline(airline67.get())
                            .numberSeats(120)
                            .price(360)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:00:00"))
                                    .flightTime(LocalTime.parse("10:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z LOS ANGELES DO LONDYNU ***********************/
            Optional<Airline> airline68 = airlineRepository.findById(3L);
            Optional<Connection> connection68 = connectionRepository.findById(68L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 2 != 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection68.get())
                            .airline(airline68.get())
                            .numberSeats(120)
                            .price(360)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:15:00"))
                                    .flightTime(LocalTime.parse("10:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z LOS ANGELES DO BERLINA ***********************/
            Optional<Airline> airline69 = airlineRepository.findById(13L);
            Optional<Connection> connection69 = connectionRepository.findById(69L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection69.get())
                            .airline(airline69.get())
                            .numberSeats(105)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:15:00"))
                                    .flightTime(LocalTime.parse("12:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z BERLINA DO LOS ANGELES ***********************/
            Optional<Airline> airline70 = airlineRepository.findById(2L);
            Optional<Connection> connection70 = connectionRepository.findById(70L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                if (i % 3 == 0) {
                    flightRepository.save(Flight.builder()
                            .connection(connection70.get())
                            .airline(airline70.get())
                            .numberSeats(105)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:00:00"))
                                    .flightTime(LocalTime.parse("12:45:00"))
                                    .build())
                            .build());
                }
            }

            /*********************** Z LOS ANGELES DO CHICAGO ***********************/
            Optional<Airline> airline71 = airlineRepository.findById(3L);
            Optional<Connection> connection71 = connectionRepository.findById(71L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection71.get())
                        .airline(airline71.get())
                        .numberSeats(210)
                        .price(150)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("10:30:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z CHICAGO DO LOS ANGELES ***********************/
            Optional<Airline> airline72 = airlineRepository.findById(3L);
            Optional<Connection> connection72 = connectionRepository.findById(72L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection72.get())
                        .airline(airline72.get())
                        .numberSeats(210)
                        .price(150)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("16:30:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z LOS ANGELES DO WARSZAWY ***********************/
            Optional<Airline> airline73 = airlineRepository.findById(3L);
            Optional<Connection> connection73 = connectionRepository.findById(73L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection73.get())
                        .airline(airline73.get())
                        .numberSeats(240)
                        .price(420)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("16:00:00"))
                                .flightTime(LocalTime.parse("15:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z WARSZAWY DO LOS ANGELES ***********************/
            Optional<Airline> airline74 = airlineRepository.findById(13L);
            Optional<Connection> connection74 = connectionRepository.findById(74L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection74.get())
                        .airline(airline74.get())
                        .numberSeats(240)
                        .price(420)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:00:00"))
                                .flightTime(LocalTime.parse("15:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z LOS ANGELES DO KIJOWA ***********************/
            Optional<Airline> airline75 = airlineRepository.findById(3L);
            Optional<Connection> connection75 = connectionRepository.findById(75L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection75.get())
                        .airline(airline75.get())
                        .numberSeats(250)
                        .price(460)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("15:00:00"))
                                .flightTime(LocalTime.parse("16:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z KIJOWA DO LOS ANGELES ***********************/
            Optional<Airline> airline76 = airlineRepository.findById(15L);
            Optional<Connection> connection76 = connectionRepository.findById(76L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection76.get())
                        .airline(airline76.get())
                        .numberSeats(250)
                        .price(460)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .flightTime(LocalTime.parse("16:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z MOSKWY DO DELHI ***********************/
            Optional<Airline> airline77 = airlineRepository.findById(12L);
            Optional<Connection> connection77 = connectionRepository.findById(77L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection77.get())
                        .airline(airline77.get())
                        .numberSeats(150)
                        .price(290)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("02:45:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z DELHI DO MOSKWY ***********************/
            Optional<Airline> airline78 = airlineRepository.findById(14L);
            Optional<Connection> connection78 = connectionRepository.findById(78L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection78.get())
                        .airline(airline78.get())
                        .numberSeats(180)
                        .price(290)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:15:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z MOSKWY DO KRAKOWA  ***********************/
            Optional<Airline> airline79 = airlineRepository.findById(12L);
            Optional<Connection> connection79 = connectionRepository.findById(79L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection79.get())
                        .airline(airline79.get())
                        .numberSeats(180)
                        .price(220)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("06:15:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z KRAKOWA DO MOSKWY ***********************/
            Optional<Airline> airline80 = airlineRepository.findById(1L);
            Optional<Connection> connection80 = connectionRepository.findById(80L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection80.get())
                        .airline(airline80.get())
                        .numberSeats(180)
                        .price(220)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("12:15:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z MOSKWY DO NOWEGO YORKU ***********************/
            Optional<Airline> airline81 = airlineRepository.findById(12L);
            Optional<Connection> connection81 = connectionRepository.findById(81L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection81.get())
                        .airline(airline81.get())
                        .numberSeats(140)
                        .price(550)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("13:45:00"))
                                .flightTime(LocalTime.parse("11:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z NOWEGO YORKU DO MOSKWY ***********************/
            Optional<Airline> airline82 = airlineRepository.findById(3L);
            Optional<Connection> connection82 = connectionRepository.findById(82L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection82.get())
                        .airline(airline82.get())
                        .numberSeats(140)
                        .price(550)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("11:15:00"))
                                .flightTime(LocalTime.parse("11:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z MOSKWY DO WARSZAWY ***********************/
            Optional<Airline> airline83 = airlineRepository.findById(12L);
            Optional<Connection> connection83 = connectionRepository.findById(83L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection83.get())
                        .airline(airline83.get())
                        .numberSeats(160)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("08:30:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z WARSZAWY DO MOSKWY ***********************/
            Optional<Airline> airline84 = airlineRepository.findById(1L);
            Optional<Connection> connection84 = connectionRepository.findById(84L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection84.get())
                        .airline(airline84.get())
                        .numberSeats(160)
                        .price(200)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("17:45:00"))
                                .flightTime(LocalTime.parse("03:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z MOSKWY DO LOS ANGELES ***********************/
            Optional<Airline> airline85 = airlineRepository.findById(12L);
            Optional<Connection> connection85 = connectionRepository.findById(85L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection85.get())
                        .airline(airline85.get())
                        .numberSeats(200)
                        .price(600)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("02:15:00"))
                                .flightTime(LocalTime.parse("16:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z LOS ANGELES DO MOSKWY ***********************/
            Optional<Airline> airline86 = airlineRepository.findById(1L);
            Optional<Connection> connection86 = connectionRepository.findById(86L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection86.get())
                        .airline(airline86.get())
                        .numberSeats(200)
                        .price(600)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("05:15:00"))
                                .flightTime(LocalTime.parse("16:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z KAIRU DO DELHI ***********************/
            Optional<Airline> airline87 = airlineRepository.findById(13L);
            Optional<Connection> connection87 = connectionRepository.findById(87L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection87.get())
                        .airline(airline87.get())
                        .numberSeats(160)
                        .price(320)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("23:15:00"))
                                .flightTime(LocalTime.parse("04:00:00"))
                                .build())
                        .build());
            }


            /*********************** Z DELHI DO KAIRU ***********************/
            Optional<Airline> airline88 = airlineRepository.findById(14L);
            Optional<Connection> connection88 = connectionRepository.findById(88L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection88.get())
                        .airline(airline88.get())
                        .numberSeats(160)
                        .price(320)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("21:45:00"))
                                .flightTime(LocalTime.parse("04:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z KAIRU DO KRAKOWA ***********************/
            Optional<Airline> airline89 = airlineRepository.findById(13L);
            Optional<Connection> connection89 = connectionRepository.findById(89L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection89.get())
                        .airline(airline89.get())
                        .numberSeats(90)
                        .price(255)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("09:45:00"))
                                .flightTime(LocalTime.parse("04:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z KRAKOWA DO KAIRU ***********************/
            Optional<Airline> airline90 = airlineRepository.findById(1L);
            Optional<Connection> connection90 = connectionRepository.findById(90L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection90.get())
                        .airline(airline90.get())
                        .numberSeats(90)
                        .price(255)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("10:30:00"))
                                .flightTime(LocalTime.parse("04:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z KRAKOWA DO DELHI ***********************/
            Optional<Airline> airline91 = airlineRepository.findById(1L);
            Optional<Connection> connection91 = connectionRepository.findById(91L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection91.get())
                        .airline(airline91.get())
                        .numberSeats(145)
                        .price(330)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("06:15:00"))
                                .flightTime(LocalTime.parse("08:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z DELHI DO KRAKOWA ***********************/
            Optional<Airline> airline92 = airlineRepository.findById(14L);
            Optional<Connection> connection92 = connectionRepository.findById(92L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection92.get())
                        .airline(airline92.get())
                        .numberSeats(145)
                        .price(330)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("11:00:00"))
                                .flightTime(LocalTime.parse("08:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z KRAKOWA DO KIJOWA ***********************/
            Optional<Airline> airline93 = airlineRepository.findById(1L);
            Optional<Connection> connection93 = connectionRepository.findById(93L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection93.get())
                        .airline(airline93.get())
                        .numberSeats(170)
                        .price(100)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("14:00:00"))
                                .flightTime(LocalTime.parse("01:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z KIJOWA DO KRAKOWA ***********************/
            Optional<Airline> airline94 = airlineRepository.findById(15L);
            Optional<Connection> connection94 = connectionRepository.findById(94L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection94.get())
                        .airline(airline94.get())
                        .numberSeats(170)
                        .price(100)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("18:00:00"))
                                .flightTime(LocalTime.parse("01:15:00"))
                                .build())
                        .build());
            }

            /*********************** Z KRAKOWA DO NOWEGO YORKU ***********************/
            Optional<Airline> airline95 = airlineRepository.findById(1L);
            Optional<Connection> connection95 = connectionRepository.findById(95L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection95.get())
                        .airline(airline95.get())
                        .numberSeats(110)
                        .price(380)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("19:00:00"))
                                .flightTime(LocalTime.parse("10:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z NOWEGO YORKU DO KRAKOWA  ***********************/
            Optional<Airline> airline96 = airlineRepository.findById(3L);
            Optional<Connection> connection96 = connectionRepository.findById(96L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection96.get())
                        .airline(airline96.get())
                        .numberSeats(110)
                        .price(380)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("09:30:00"))
                                .flightTime(LocalTime.parse("10:30:00"))
                                .build())
                        .build());
            }

            /*********************** Z DELHI DO KIJOWA ***********************/
            Optional<Airline> airline97 = airlineRepository.findById(14L);
            Optional<Connection> connection97 = connectionRepository.findById(97L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection97.get())
                        .airline(airline97.get())
                        .numberSeats(165)
                        .price(340)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("17:15:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z KIJOWA DO DELHI ***********************/
            Optional<Airline> airline98 = airlineRepository.findById(15L);
            Optional<Connection> connection98 = connectionRepository.findById(98L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection98.get())
                        .airline(airline98.get())
                        .numberSeats(165)
                        .price(340)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("17:00:00"))
                                .flightTime(LocalTime.parse("06:00:00"))
                                .build())
                        .build());
            }

            /*********************** Z KIJOWA DO NOWEGO YORKU ***********************/
            Optional<Airline> airline99 = airlineRepository.findById(15L);
            Optional<Connection> connection99 = connectionRepository.findById(99L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection99.get())
                        .airline(airline99.get())
                        .numberSeats(120)
                        .price(430)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("19:45:00"))
                                .flightTime(LocalTime.parse("11:45:00"))
                                .build())
                        .build());
            }

            /*********************** Z NOWEGO YORKU DO KIJOWA ***********************/
            Optional<Airline> airline100 = airlineRepository.findById(3L);
            Optional<Connection> connection100 = connectionRepository.findById(100L);

            for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                flightRepository.save(Flight.builder()
                        .connection(connection100.get())
                        .airline(airline100.get())
                        .numberSeats(120)
                        .price(430)
                        .times(Times.
                                builder()
                                .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                .departureTime(LocalTime.parse("22:15:00"))
                                .flightTime(LocalTime.parse("11:45:00"))
                                .build())
                        .build());
            }


        }
    }
}