package flight_booking.backend.loaders;

import flight_booking.backend.models.Airline;
import flight_booking.backend.models.Connection;
import flight_booking.backend.models.Flight;
import flight_booking.backend.models.Times;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Component
public class FlightLoader implements CommandLineRunner {

    private static final int MAX_DAYS_TO_LOAD = 183;
    private static final String FIRST_DAY = "2020-09-01";
    ConnectionRepository connectionRepository;
    AirlineRepository airlineRepository;
    FlightRepository flightRepository;

    FlightLoader(ConnectionRepository connectionRepository,
                 AirlineRepository airlineRepository,
                 FlightRepository flightRepository) {
        this.connectionRepository = connectionRepository;
        this.airlineRepository = airlineRepository;
        this.flightRepository = flightRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (flightRepository.amountOfRows() == 0) {

            // ALL AIRLINE
            Optional<Airline> airline1 = airlineRepository.findById(1L);
            Optional<Airline> airline2 = airlineRepository.findById(2L);
            Optional<Airline> airline3 = airlineRepository.findById(3L);
            Optional<Airline> airline4 = airlineRepository.findById(4L);
            Optional<Airline> airline5 = airlineRepository.findById(5L);
            Optional<Airline> airline6 = airlineRepository.findById(6L);
            Optional<Airline> airline7 = airlineRepository.findById(7L);
            Optional<Airline> airline8 = airlineRepository.findById(8L);
            Optional<Airline> airline9 = airlineRepository.findById(9L);
            Optional<Airline> airline10 = airlineRepository.findById(10L);
            Optional<Airline> airline11 = airlineRepository.findById(11L);
            Optional<Airline> airline12 = airlineRepository.findById(12L);
            Optional<Airline> airline13 = airlineRepository.findById(13L);
            Optional<Airline> airline14 = airlineRepository.findById(14L);
            Optional<Airline> airline15 = airlineRepository.findById(15L);


            // 1. FROM NEW YORK TO CHICAGO
            Optional<Connection> connection1 = connectionRepository.findById(1L);

            if (connection1.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection1.get())
                            .airline(airline3.get())
                            .numberSeats(120)
                            .availableSeats(120)
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
                            .airline(airline3.get())
                            .numberSeats(205)
                            .availableSeats(205)
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
                            .airline(airline3.get())
                            .numberSeats(265)
                            .availableSeats(265)
                            .price(175)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:30:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 2. FROM CHICAGO TO NEW YORK
            Optional<Connection> connection2 = connectionRepository.findById(2L);

            if (connection2.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection2.get())
                            .airline(airline3.get())
                            .numberSeats(125)
                            .availableSeats(125)
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
                            .airline(airline3.get())
                            .numberSeats(255)
                            .availableSeats(255)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:00:00"))
                                    .flightTime(LocalTime.parse("08:00:00"))
                                    .build())
                            .build());
                }
            }


            // 3. FROM NEW YORK TO WARSAW
            Optional<Connection> connection3 = connectionRepository.findById(3L);

            if (connection3.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection3.get())
                            .airline(airline3.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(350)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:30:00"))
                                    .flightTime(LocalTime.parse("09:30:00"))
                                    .build())
                            .build());
                }
            }


            // 4. FROM WARSAW TO NEW YORK
            Optional<Connection> connection4 = connectionRepository.findById(4L);

            if (connection4.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection4.get())
                            .airline(airline1.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(340)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:00:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 5. FROM NEW YORK TO PEKIN
            Optional<Connection> connection5 = connectionRepository.findById(5L);

            if (connection5.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection5.get())
                            .airline(airline3.get())
                            .numberSeats(190)
                            .availableSeats(190)
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


            // 6. FROM PEKIN TO NEW YORK
            Optional<Connection> connection6 = connectionRepository.findById(6L);

            if (connection6.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection6.get())
                            .airline(airline4.get())
                            .numberSeats(260)
                            .availableSeats(260)
                            .price(575)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }


            // 7. FROM PEKIN TO CHICAGO
            Optional<Connection> connection7 = connectionRepository.findById(7L);

            if (connection7.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection7.get())
                            .airline(airline4.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(555)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:00:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 8. FROM CHICAGO TO PEKIN
            Optional<Connection> connection8 = connectionRepository.findById(8L);

            if (connection8.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection8.get())
                            .airline(airline2.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(560)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }


            // 9. FROM PEKIN TO WARSAW
            Optional<Connection> connection9 = connectionRepository.findById(9L);

            if (connection9.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection9.get())
                            .airline(airline4.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(560)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("03:30:00"))
                                    .flightTime(LocalTime.parse("13:00:00"))
                                    .build())
                            .build());
                }
            }


            // 10. FROM WARSAW TO PEKIN
            Optional<Connection> connection10 = connectionRepository.findById(10L);

            if (connection10.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection10.get())
                            .airline(airline1.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 11. FROM CHICAGO TO BERLIN
            Optional<Connection> connection11 = connectionRepository.findById(11L);

            if (connection11.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection11.get())
                            .airline(airline3.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(375)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:45:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 12. FROM BERLIN TO CHICAGO
            Optional<Connection> connection12 = connectionRepository.findById(12L);

            if (connection12.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection12.get())
                            .airline(airline2.get())
                            .numberSeats(130)
                            .availableSeats(130)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:15:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 13. FROM WARSAW TO BERLIN
            Optional<Connection> connection13 = connectionRepository.findById(13L);

            if (connection13.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(airline1.get())
                            .numberSeats(140)
                            .availableSeats(140)
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
                            .airline(airline1.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(125)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());

                    flightRepository.save(Flight.builder()
                            .connection(connection13.get())
                            .airline(airline1.get())
                            .numberSeats(140)
                            .availableSeats(140)
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


            // 14. FROM BERLIN TO WARSAW
            Optional<Connection> connection14 = connectionRepository.findById(14L);

            if (connection14.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection14.get())
                            .airline(airline2.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(110)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:45:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());

                    flightRepository.save(Flight.builder()
                            .connection(connection14.get())
                            .airline(airline2.get())
                            .numberSeats(160)
                            .availableSeats(160)
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


            // 15. FROM WARSAW TO CHICAGO
            Optional<Connection> connection15 = connectionRepository.findById(15L);

            if (connection15.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection15.get())
                            .airline(airline1.get())
                            .numberSeats(250)
                            .availableSeats(250)
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


            // 16. FROM CHICAGO TO WARSAW
            Optional<Connection> connection16 = connectionRepository.findById(16L);

            if (connection16.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection16.get())
                            .airline(airline3.get())
                            .numberSeats(125)
                            .availableSeats(125)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 17. FROM SZANGHAI TO NEW YORK
            Optional<Connection> connection17 = connectionRepository.findById(17L);

            if (connection17.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection17.get())
                            .airline(airline4.get())
                            .numberSeats(225)
                            .availableSeats(225)
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


            // 18. FROM NEW YORK TO SZANGHAI
            Optional<Connection> connection18 = connectionRepository.findById(18L);

            if (connection18.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection18.get())
                            .airline(airline3.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 19. FROM SZANGHAI TO PEKIN
            Optional<Connection> connection19 = connectionRepository.findById(19L);

            if (connection19.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection19.get())
                            .airline(airline4.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:00:00"))
                                    .flightTime(LocalTime.parse("01:00:00"))
                                    .build())
                            .build());
                }
            }


            // 20. FROM PEKINU TO SZANGHAI
            Optional<Connection> connection20 = connectionRepository.findById(20L);

            if (connection20.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection20.get())
                            .airline(airline4.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .flightTime(LocalTime.parse("01:00:00"))
                                    .build())
                            .build());
                }
            }


            // 21. FROM SZANGHAI TO TORONTO
            Optional<Connection> connection21 = connectionRepository.findById(21L);

            if (connection21.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection21.get())
                            .airline(airline4.get())
                            .numberSeats(180)
                            .availableSeats(180)
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


            // 22. FROM TORONTO TO SZANGHAI
            Optional<Connection> connection22 = connectionRepository.findById(22L);

            if (connection22.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection22.get())
                            .airline(airline5.get())
                            .numberSeats(180)
                            .availableSeats(180)
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


            // 23. FROM SZANGHAI TO SYDNEY
            Optional<Connection> connection23 = connectionRepository.findById(23L);

            if (connection23.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection23.get())
                            .airline(airline4.get())
                            .numberSeats(150)
                            .availableSeats(150)
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


            // 24. FROM SYDNEY TO SZANGHAI
            Optional<Connection> connection24 = connectionRepository.findById(24L);

            if (connection24.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection24.get())
                            .airline(airline6.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 25. FROM TORONTO TO PEKIN
            Optional<Connection> connection25 = connectionRepository.findById(25L);

            if (connection25.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection25.get())
                            .airline(airline5.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 26. FROM PEKIN TO TORONTO
            Optional<Connection> connection26 = connectionRepository.findById(26L);

            if (connection26.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection26.get())
                            .airline(airline4.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 27. FROM TORONTO TO CHICAGO
            Optional<Connection> connection27 = connectionRepository.findById(27L);

            if (connection27.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection27.get())
                            .airline(airline5.get())
                            .numberSeats(90)
                            .availableSeats(90)
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


            // 28. FROM CHICAGO TO TORONTO
            Optional<Connection> connection28 = connectionRepository.findById(28L);

            if (connection28.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection28.get())
                            .airline(airline3.get())
                            .numberSeats(100)
                            .availableSeats(100)
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


            // 29. FROM TORONTO TO SYDNEY
            Optional<Connection> connection29 = connectionRepository.findById(29L);

            if (connection29.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection29.get())
                            .airline(airline5.get())
                            .numberSeats(250)
                            .availableSeats(250)
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


            // 30. FROM SYDNEY TO TORONTO
            Optional<Connection> connection30 = connectionRepository.findById(30L);

            if (connection30.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection30.get())
                            .airline(airline6.get())
                            .numberSeats(250)
                            .availableSeats(250)
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


            // 31. FROM SYDNEY TO BERLIN
            Optional<Connection> connection31 = connectionRepository.findById(31L);

            if (connection31.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection31.get())
                            .airline(airline6.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:00:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 32. FROM BERLIN TO SYDNEY
            Optional<Connection> connection32 = connectionRepository.findById(32L);

            if (connection32.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection32.get())
                            .airline(airline2.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(390)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:30:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 33. FROM SYDNEY TO TOKYO
            Optional<Connection> connection33 = connectionRepository.findById(33L);

            if (connection33.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection33.get())
                            .airline(airline6.get())
                            .numberSeats(150)
                            .availableSeats(150)
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


            // 34. FROM TOKYO TO SYDNEY
            Optional<Connection> connection34 = connectionRepository.findById(34L);

            if (connection34.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection34.get())
                            .airline(airline7.get())
                            .numberSeats(150)
                            .availableSeats(150)
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


            // 35. FROM TOKYO TO BERLIN
            Optional<Connection> connection35 = connectionRepository.findById(35L);

            if (connection35.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection35.get())
                            .airline(airline7.get())
                            .numberSeats(170)
                            .availableSeats(170)
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


            // 36. FROM BERLINA TO TOKYO
            Optional<Connection> connection36 = connectionRepository.findById(36L);

            if (connection36.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection36.get())
                            .airline(airline2.get())
                            .numberSeats(150)
                            .availableSeats(150)
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


            // 37. FROM TOKYO TO RIO DE JANEIRO
            Optional<Connection> connection37 = connectionRepository.findById(37L);

            if (connection37.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection37.get())
                            .airline(airline7.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 38. FROM RIO DE JANEIRO TO TOKYO
            Optional<Connection> connection38 = connectionRepository.findById(38L);

            if (connection38.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection38.get())
                            .airline(airline8.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 39. FROM RIO DE JANEIRO TO BERLIN
            Optional<Connection> connection39 = connectionRepository.findById(39L);

            if (connection39.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection39.get())
                            .airline(airline8.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:15:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }


            // 40. FROM BERLIN TO RIO DE JANEIRO
            Optional<Connection> connection40 = connectionRepository.findById(40L);

            if (connection40.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection40.get())
                            .airline(airline2.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }


            // 41. FROM RIO DE JANEIRO TO LOS ANGELES
            Optional<Connection> connection41 = connectionRepository.findById(41L);

            if (connection41.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection41.get())
                            .airline(airline8.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 42. FROM LOS ANGELES TO RIO DE JANEIRO
            Optional<Connection> connection42 = connectionRepository.findById(42L);

            if (connection42.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection42.get())
                            .airline(airline3.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 43. FROM RIO DE JANEIRO TO OSLO
            Optional<Connection> connection43 = connectionRepository.findById(43L);

            if (connection43.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection43.get())
                            .airline(airline8.get())
                            .numberSeats(200)
                            .availableSeats(200)
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


            // 44. FROM OSLO TO RIO DE JANEIRO
            Optional<Connection> connection44 = connectionRepository.findById(44L);

            if (connection44.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection44.get())
                            .airline(airline9.get())
                            .numberSeats(160)
                            .availableSeats(160)
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


            // 45. FROM RIO DE JANEIRO TO BUENOS AIRES
            Optional<Connection> connection45 = connectionRepository.findById(45L);

            if (connection45.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection45.get())
                            .airline(airline8.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:45:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 46. FROM BUENOS AIRES TO RIO DE JANEIRO
            Optional<Connection> connection46 = connectionRepository.findById(46L);

            if (connection46.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection46.get())
                            .airline(airline8.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 47. FROM OSLO TO BUENOS AIRES
            Optional<Connection> connection47 = connectionRepository.findById(47L);

            if (connection47.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection47.get())
                            .airline(airline9.get())
                            .numberSeats(80)
                            .availableSeats(80)
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


            // 48. FROM BUENOS AIRES TO OSLO
            Optional<Connection> connection48 = connectionRepository.findById(48L);

            if (connection48.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection48.get())
                            .airline(airline8.get())
                            .numberSeats(100)
                            .availableSeats(100)
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


            // 49. FROM OSLO TO PARIS
            Optional<Connection> connection49 = connectionRepository.findById(49L);

            if (connection49.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection49.get())
                            .airline(airline9.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:15:00"))
                                    .flightTime(LocalTime.parse("01:30:00"))
                                    .build())
                            .build());
                }
            }


            // 50. FROM PARIS TO OSLO
            Optional<Connection> connection50 = connectionRepository.findById(50L);

            if (connection50.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection50.get())
                            .airline(airline10.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:15:00"))
                                    .flightTime(LocalTime.parse("01:30:00"))
                                    .build())
                            .build());
                }
            }
