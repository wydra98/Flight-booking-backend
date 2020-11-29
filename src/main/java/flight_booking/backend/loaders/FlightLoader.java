package flight_booking.backend.loaders;

import flight_booking.backend.repository.AirlineRepository;
import flight_booking.backend.repository.ConnectionRepository;
import flight_booking.backend.repository.FlightRepository;
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
    private static final String FIRST_DAY = "2020-12-01";
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


            // 51. FROM OSLO TO LONDON
            Optional<Connection> connection51 = connectionRepository.findById(51L);

            if (connection51.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection51.get())
                            .airline(airline9.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:15:00"))
                                    .flightTime(LocalTime.parse("01:30:00"))
                                    .build())
                            .build());
                }
            }


            // 52. FROM LONDON TO OSLO
            Optional<Connection> connection52 = connectionRepository.findById(52L);

            if (connection52.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection52.get())
                            .airline(airline11.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:30:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 53. FROM OSLO TO LOS ANGELES
            Optional<Connection> connection53 = connectionRepository.findById(53L);

            if (connection53.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection53.get())
                            .airline(airline9.get())
                            .numberSeats(180)
                            .availableSeats(180)
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


            // 54. FROM LOS ANGELES TO OSLO
            Optional<Connection> connection54 = connectionRepository.findById(54L);

            if (connection54.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection54.get())
                            .airline(airline3.get())
                            .numberSeats(180)
                            .availableSeats(180)
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


            // 55. FROM BUENOS AIRES TO PARIS
            Optional<Connection> connection55 = connectionRepository.findById(55L);

            if (connection55.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection55.get())
                            .airline(airline8.get())
                            .numberSeats(220)
                            .availableSeats(220)
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


            // 56. FROM PARIS TO BUENOS AIRES
            Optional<Connection> connection56 = connectionRepository.findById(56L);

            if (connection56.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection56.get())
                            .airline(airline10.get())
                            .numberSeats(220)
                            .availableSeats(220)
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


            // 57. FROM PARIS TO LONDON
            Optional<Connection> connection57 = connectionRepository.findById(57L);

            if (connection57.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection57.get())
                            .airline(airline10.get())
                            .numberSeats(130)
                            .availableSeats(130)
                            .price(100)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:00:00"))
                                    .flightTime(LocalTime.parse("01:00:00"))
                                    .build())
                            .build());
                }
            }


            // 58. FROM LONDON TO PARIS
            Optional<Connection> connection58 = connectionRepository.findById(58L);

            if (connection58.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection58.get())
                            .airline(airline11.get())
                            .numberSeats(130)
                            .availableSeats(130)
                            .price(100)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:00:00"))
                                    .flightTime(LocalTime.parse("01:00:00"))
                                    .build())
                            .build());
                }
            }


            // 59. FROM LONDON TO TORONTO
            Optional<Connection> connection59 = connectionRepository.findById(59L);

            if (connection59.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection59.get())
                            .airline(airline11.get())
                            .numberSeats(240)
                            .availableSeats(240)
                            .price(350)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:30:00"))
                                    .flightTime(LocalTime.parse("07:15:00"))
                                    .build())
                            .build());
                }
            }


            // 60. FROM TORONTO TO LONDON
            Optional<Connection> connection60 = connectionRepository.findById(60L);

            if (connection60.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection60.get())
                            .airline(airline5.get())
                            .numberSeats(240)
                            .availableSeats(240)
                            .price(350)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:30:00"))
                                    .flightTime(LocalTime.parse("07:15:00"))
                                    .build())
                            .build());
                }
            }


            // 61. FROM LONDON TO CAIRO
            Optional<Connection> connection61 = connectionRepository.findById(61L);

            if (connection61.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection61.get())
                            .airline(airline11.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(320)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:15:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 62. FROM CAIRO TO LONDON
            Optional<Connection> connection62 = connectionRepository.findById(62L);

            if (connection62.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection62.get())
                            .airline(airline13.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(320)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:30:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 63. FROM LONDON TO MOSCOW
            Optional<Connection> connection63 = connectionRepository.findById(63L);

            if (connection63.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection63.get())
                            .airline(airline11.get())
                            .numberSeats(250)
                            .availableSeats(250)
                            .price(220)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:45:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 64. FROM MOSCOW TO LONDON
            Optional<Connection> connection64 = connectionRepository.findById(64L);

            if (connection64.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection64.get())
                            .airline(airline12.get())
                            .numberSeats(250)
                            .availableSeats(250)
                            .price(220)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:30:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 65. FROM LONDON TO WARSAW
            Optional<Connection> connection65 = connectionRepository.findById(65L);

            if (connection65.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection65.get())
                            .airline(airline11.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:15:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 66. FROM WARSAW TO LONDON
            Optional<Connection> connection66 = connectionRepository.findById(66L);

            if (connection66.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection66.get())
                            .airline(airline1.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:15:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 67. FROM LONDON TO LOS ANGELES
            Optional<Connection> connection67 = connectionRepository.findById(67L);

            if (connection67.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection67.get())
                            .airline(airline11.get())
                            .numberSeats(120)
                            .availableSeats(120)
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


            // 68. FROM LOS ANGELES TO LONDON
            Optional<Connection> connection68 = connectionRepository.findById(68L);

            if (connection68.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection68.get())
                            .airline(airline3.get())
                            .numberSeats(120)
                            .availableSeats(120)
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


            // 69. FROM LOS ANGELES TO BERLIN
            Optional<Connection> connection69 = connectionRepository.findById(69L);

            if (connection69.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection69.get())
                            .airline(airline13.get())
                            .numberSeats(105)
                            .availableSeats(105)
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


            // 70. FROM BERLIN TO LOS ANGELES
            Optional<Connection> connection70 = connectionRepository.findById(70L);

            if (connection70.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection70.get())
                            .airline(airline2.get())
                            .numberSeats(105)
                            .availableSeats(105)
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


            // 71. FROM LOS ANGELES TO CHICAGO
            Optional<Connection> connection71 = connectionRepository.findById(71L);

            if (connection71.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection71.get())
                            .airline(airline3.get())
                            .numberSeats(210)
                            .availableSeats(210)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:30:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 72. FROM CHICAGO TO LOS ANGELES
            Optional<Connection> connection72 = connectionRepository.findById(72L);

            if (connection72.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection72.get())
                            .airline(airline3.get())
                            .numberSeats(210)
                            .availableSeats(120)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:30:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 73. FROM LOS ANGELES TO WARSAW
            Optional<Connection> connection73 = connectionRepository.findById(73L);

            if (connection73.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection73.get())
                            .airline(airline3.get())
                            .numberSeats(240)
                            .availableSeats(240)
                            .price(420)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:00:00"))
                                    .flightTime(LocalTime.parse("15:15:00"))
                                    .build())
                            .build());
                }
            }


            // 74. FROM WARSAW TO LOS ANGELES
            Optional<Connection> connection74 = connectionRepository.findById(74L);

            if (connection74.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection74.get())
                            .airline(airline13.get())
                            .numberSeats(240)
                            .availableSeats(240)
                            .price(420)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:00:00"))
                                    .flightTime(LocalTime.parse("15:15:00"))
                                    .build())
                            .build());
                }
            }


            // 75. FROM LOS ANGELES TO KIEV
            Optional<Connection> connection75 = connectionRepository.findById(75L);

            if (connection75.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection75.get())
                            .airline(airline3.get())
                            .numberSeats(250)
                            .availableSeats(250)
                            .price(460)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .flightTime(LocalTime.parse("16:15:00"))
                                    .build())
                            .build());
                }
            }


            // 76. FROM KIEV TO LOS ANGELES
            Optional<Connection> connection76 = connectionRepository.findById(76L);

            if (connection76.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection76.get())
                            .airline(airline15.get())
                            .numberSeats(250)
                            .availableSeats(250)
                            .price(460)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .flightTime(LocalTime.parse("16:15:00"))
                                    .build())
                            .build());
                }
            }


            // 77. FROM MOSCOW TO DELHI
            Optional<Connection> connection77 = connectionRepository.findById(77L);

            if (connection77.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection77.get())
                            .airline(airline12.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(290)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("02:45:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 78. FROM DELHI TO MOSCOW
            Optional<Connection> connection78 = connectionRepository.findById(78L);

            if (connection78.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection78.get())
                            .airline(airline14.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(290)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:15:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 79. FROM MOSCOW TO CRACOW
            Optional<Connection> connection79 = connectionRepository.findById(79L);

            if (connection79.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection79.get())
                            .airline(airline12.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(220)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:15:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 80. FROM CRACOW TO MOSCOW
            Optional<Connection> connection80 = connectionRepository.findById(80L);

            if (connection80.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection80.get())
                            .airline(airline1.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(220)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:15:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 81. FROM MOSCOW TO NEW YORK
            Optional<Connection> connection81 = connectionRepository.findById(81L);

            if (connection81.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection81.get())
                            .airline(airline12.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:45:00"))
                                    .flightTime(LocalTime.parse("11:30:00"))
                                    .build())
                            .build());
                }
            }


            // 82. FROM NEW YORK TO MOSCOW
            Optional<Connection> connection82 = connectionRepository.findById(82L);

            if (connection82.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection82.get())
                            .airline(airline3.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:15:00"))
                                    .flightTime(LocalTime.parse("11:30:00"))
                                    .build())
                            .build());
                }
            }


            // 83. FROM MOSCOW TO WARSAW
            Optional<Connection> connection83 = connectionRepository.findById(83L);

            if (connection83.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection83.get())
                            .airline(airline12.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:30:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 84. FROM WARSAW TO MOSCOW
            Optional<Connection> connection84 = connectionRepository.findById(84L);

            if (connection84.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection84.get())
                            .airline(airline1.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 85. FROM MOSCOW TO LOS ANGELES
            Optional<Connection> connection85 = connectionRepository.findById(85L);

            if (connection85.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection85.get())
                            .airline(airline12.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(600)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("02:15:00"))
                                    .flightTime(LocalTime.parse("16:30:00"))
                                    .build())
                            .build());
                }
            }


            // 86. FROM LOS ANGELES TO MOSCOW
            Optional<Connection> connection86 = connectionRepository.findById(86L);

            if (connection86.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection86.get())
                            .airline(airline1.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(600)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:15:00"))
                                    .flightTime(LocalTime.parse("16:30:00"))
                                    .build())
                            .build());
                }
            }


            // 87. FROM CAIRO TO DELHI
            Optional<Connection> connection87 = connectionRepository.findById(87L);

            if (connection87.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection87.get())
                            .airline(airline13.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(320)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("23:15:00"))
                                    .flightTime(LocalTime.parse("04:00:00"))
                                    .build())
                            .build());
                }
            }


            // 88. FROM DELHI TO CAIRO
            Optional<Connection> connection88 = connectionRepository.findById(88L);

            if (connection88.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection88.get())
                            .airline(airline14.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(320)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:45:00"))
                                    .flightTime(LocalTime.parse("04:00:00"))
                                    .build())
                            .build());
                }
            }


            // 89. FROM CAIRO TO CRACOW
            Optional<Connection> connection89 = connectionRepository.findById(89L);

            if (connection89.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection89.get())
                            .airline(airline13.get())
                            .numberSeats(90)
                            .availableSeats(90)
                            .price(255)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:45:00"))
                                    .flightTime(LocalTime.parse("04:15:00"))
                                    .build())
                            .build());
                }
            }


            // 90. FROM CRACOW TO CAIRO
            Optional<Connection> connection90 = connectionRepository.findById(90L);

            if (connection90.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection90.get())
                            .airline(airline1.get())
                            .numberSeats(90)
                            .availableSeats(90)
                            .price(255)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:30:00"))
                                    .flightTime(LocalTime.parse("04:15:00"))
                                    .build())
                            .build());
                }
            }


            // 91. FROM CRACOW TO DELHI
            Optional<Connection> connection91 = connectionRepository.findById(91L);

            if (connection91.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection91.get())
                            .airline(airline1.get())
                            .numberSeats(145)
                            .availableSeats(145)
                            .price(330)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:15:00"))
                                    .flightTime(LocalTime.parse("08:15:00"))
                                    .build())
                            .build());
                }
            }


            // 92. FROM DELHI TO CRACOW
            Optional<Connection> connection92 = connectionRepository.findById(92L);

            if (connection92.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection92.get())
                            .airline(airline14.get())
                            .numberSeats(145)
                            .availableSeats(145)
                            .price(330)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:00:00"))
                                    .flightTime(LocalTime.parse("08:15:00"))
                                    .build())
                            .build());
                }
            }


            // 93. FROM CRACOW TO KIEV
            Optional<Connection> connection93 = connectionRepository.findById(93L);

            if (connection93.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection93.get())
                            .airline(airline1.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(100)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:00:00"))
                                    .flightTime(LocalTime.parse("01:15:00"))
                                    .build())
                            .build());
                }
            }


            // 94. FROM KIEV TO CRACOW
            Optional<Connection> connection94 = connectionRepository.findById(94L);

            if (connection94.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection94.get())
                            .airline(airline15.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(100)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:00:00"))
                                    .flightTime(LocalTime.parse("01:15:00"))
                                    .build())
                            .build());
                }
            }


            // 95. FROM CRACOW TO NEW YORK
            Optional<Connection> connection95 = connectionRepository.findById(95L);

            if (connection95.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection95.get())
                            .airline(airline1.get())
                            .numberSeats(110)
                            .availableSeats(110)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .flightTime(LocalTime.parse("10:30:00"))
                                    .build())
                            .build());
                }
            }


            // 96. FROM NEW YORK TO CRACOW
            Optional<Connection> connection96 = connectionRepository.findById(96L);

            if (connection96.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection96.get())
                            .airline(airline3.get())
                            .numberSeats(110)
                            .availableSeats(110)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("09:30:00"))
                                    .flightTime(LocalTime.parse("10:30:00"))
                                    .build())
                            .build());
                }
            }


            // 97. FROM DELHI TO KIEV
            Optional<Connection> connection97 = connectionRepository.findById(97L);

            if (connection97.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection97.get())
                            .airline(airline14.get())
                            .numberSeats(165)
                            .availableSeats(165)
                            .price(340)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:15:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 98. FROM KIEV TO DELHI
            Optional<Connection> connection98 = connectionRepository.findById(98L);

            if (connection98.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection98.get())
                            .airline(airline15.get())
                            .numberSeats(165)
                            .availableSeats(165)
                            .price(340)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:00:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 99. FROM KIEV TO NEW YORK
            Optional<Connection> connection99 = connectionRepository.findById(99L);

            if (connection99.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection99.get())
                            .airline(airline15.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(430)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:45:00"))
                                    .flightTime(LocalTime.parse("11:45:00"))
                                    .build())
                            .build());
                }
            }


            // 100. FROM NEW YORK TO KIEV
            Optional<Connection> connection100 = connectionRepository.findById(100L);

            if (connection100.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection100.get())
                            .airline(airline3.get())
                            .numberSeats(120)
                            .availableSeats(120)
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

            // 101. FROM PEKIN TO CRACOW
            Optional<Connection> connection101 = connectionRepository.findById(101L);

            if (connection101.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection101.get())
                            .airline(airline4.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(350)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:30:00"))
                                    .flightTime(LocalTime.parse("09:15:00"))
                                    .build())
                            .build());
                }
            }

            // 102. FROM CRACOW TO PEKIN
            Optional<Connection> connection102 = connectionRepository.findById(102L);

            if (connection102.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection102.get())
                            .airline(airline1.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(350)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:30:00"))
                                    .flightTime(LocalTime.parse("09:15:00"))
                                    .build())
                            .build());
                }
            }


            // 103. FROM SZANGHAI TO DELHI
            Optional<Connection> connection103 = connectionRepository.findById(103L);

            if (connection103.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection103.get())
                            .airline(airline14.get())
                            .numberSeats(100)
                            .availableSeats(100)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:15:00"))
                                    .flightTime(LocalTime.parse("02:15:00"))
                                    .build())
                            .build());
                }
            }


            // 104. FROM DELHI TO SZANGHAI
            Optional<Connection> connection104 = connectionRepository.findById(104L);

            if (connection104.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection104.get())
                            .airline(airline14.get())
                            .numberSeats(135)
                            .availableSeats(135)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:00:00"))
                                    .flightTime(LocalTime.parse("02:15:00"))
                                    .build())
                            .build());
                }
            }


            // 105. FROM CHICAGO TO KIEV
            Optional<Connection> connection105 = connectionRepository.findById(105L);

            if (connection105.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection105.get())
                            .airline(airline3.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(470)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:15:00"))
                                    .flightTime(LocalTime.parse("12:45:00"))
                                    .build())
                            .build());
                }
            }


            // 106. FROM KIEV TO CHICAGO
            Optional<Connection> connection106 = connectionRepository.findById(106L);

            if (connection106.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection106.get())
                            .airline(airline15.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(470)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:30:00"))
                                    .flightTime(LocalTime.parse("12:45:00"))
                                    .build())
                            .build());
                }
            }


            // 107. FROM NEW YORK TO OSLO
            Optional<Connection> connection107 = connectionRepository.findById(107L);

            if (connection107.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection107.get())
                            .airline(airline3.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(360)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:15:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 108. FROM OSLO TO NEW YORK
            Optional<Connection> connection108 = connectionRepository.findById(108L);

            if (connection108.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection108.get())
                            .airline(airline9.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(360)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:00:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 109. FROM SZANGHAI TO BERLIN
            Optional<Connection> connection109 = connectionRepository.findById(109L);

            if (connection109.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection109.get())
                            .airline(airline14.get())
                            .numberSeats(155)
                            .availableSeats(155)
                            .price(420)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:30:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 110. FROM BERLIN TO SZANGHAI
            Optional<Connection> connection110 = connectionRepository.findById(110L);

            if (connection110.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection110.get())
                            .airline(airline2.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(420)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:45:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 111. FROM PEKIN TO TOKIO
            Optional<Connection> connection111 = connectionRepository.findById(111L);

            if (connection111.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection111.get())
                            .airline(airline4.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(180)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:00:00"))
                                    .flightTime(LocalTime.parse("02:15:00"))
                                    .build())
                            .build());
                }
            }


            // 112. FROM TOKIO TO PEKIN
            Optional<Connection> connection112 = connectionRepository.findById(112L);

            if (connection112.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection112.get())
                            .airline(airline7.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(180)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("10:45:00"))
                                    .flightTime(LocalTime.parse("02:15:00"))
                                    .build())
                            .build());
                }
            }


            // 113. FROM TOKIO TO LONDON
            Optional<Connection> connection113 = connectionRepository.findById(113L);

            if (connection113.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection113.get())
                            .airline(airline7.get())
                            .numberSeats(220)
                            .availableSeats(220)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:15:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }


            // 114. FROM LONDON TO TOKIO
            Optional<Connection> connection114 = connectionRepository.findById(114L);

            if (connection114.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection114.get())
                            .airline(airline11.get())
                            .numberSeats(220)
                            .availableSeats(220)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:00:00"))
                                    .flightTime(LocalTime.parse("12:00:00"))
                                    .build())
                            .build());
                }
            }

            // 115. FROM CAIRO TO BERLIN
            Optional<Connection> connection115 = connectionRepository.findById(115L);

            if (connection115.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection115.get())
                            .airline(airline13.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(270)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("23:30:00"))
                                    .flightTime(LocalTime.parse("04:00:00"))
                                    .build())
                            .build());
                }
            }

            // 116. FROM BERLIN TO CAIRO
            Optional<Connection> connection116 = connectionRepository.findById(116L);

            if (connection116.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection116.get())
                            .airline(airline2.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(270)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:45:00"))
                                    .flightTime(LocalTime.parse("04:00:00"))
                                    .build())
                            .build());
                }
            }

            // 117. FROM CAIRO TO SZANGHAI
            Optional<Connection> connection117 = connectionRepository.findById(117L);

            if (connection117.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection117.get())
                            .airline(airline13.get())
                            .numberSeats(145)
                            .availableSeats(145)
                            .price(280)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:30:00"))
                                    .flightTime(LocalTime.parse("03:45:00"))
                                    .build())
                            .build());
                }
            }


            // 118. FROM SZANGHAI TO CAIRO
            Optional<Connection> connection118 = connectionRepository.findById(118L);

            if (connection118.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection118.get())
                            .airline(airline14.get())
                            .numberSeats(145)
                            .availableSeats(145)
                            .price(280)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("03:30:00"))
                                    .flightTime(LocalTime.parse("03:45:00"))
                                    .build())
                            .build());
                }
            }


            // 119. FROM PARIS TO MOSCOW
            Optional<Connection> connection119 = connectionRepository.findById(119L);

            if (connection119.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection119.get())
                            .airline(airline10.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(300)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:15:00"))
                                    .flightTime(LocalTime.parse("03:30:00"))
                                    .build())
                            .build());
                }
            }


            // 120. FROM MOSCOW TO PARIS
            Optional<Connection> connection120 = connectionRepository.findById(120L);

            if (connection120.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection120.get())
                            .airline(airline12.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(300)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("11:30:00"))
                                    .flightTime(LocalTime.parse("03:30:00"))
                                    .build())
                            .build());
                }
            }


            // 121. FROM SYDNEY TO CHICAGO
            Optional<Connection> connection121 = connectionRepository.findById(121L);

            if (connection121.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection121.get())
                            .airline(airline6.get())
                            .numberSeats(100)
                            .availableSeats(100)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:00:00"))
                                    .flightTime(LocalTime.parse("12:30:00"))
                                    .build())
                            .build());
                }
            }


            // 122. FROM CHICAGO TO SYDNEY
            Optional<Connection> connection122 = connectionRepository.findById(122L);

            if (connection122.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection122.get())
                            .airline(airline3.get())
                            .numberSeats(105)
                            .availableSeats(105)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:15:00"))
                                    .flightTime(LocalTime.parse("12:30:00"))
                                    .build())
                            .build());
                }
            }


            // 123. FROM KIEV TO MOSCOW
            Optional<Connection> connection123 = connectionRepository.findById(123L);

            if (connection123.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection123.get())
                            .airline(airline15.get())
                            .numberSeats(110)
                            .availableSeats(110)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:30:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 124. FROM MOSCOW TO KIEV
            Optional<Connection> connection124 = connectionRepository.findById(124L);

            if (connection124.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection124.get())
                            .airline(airline12.get())
                            .numberSeats(115)
                            .availableSeats(115)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("12:45:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 125. FROM WARSAW TO CRACOW
            Optional<Connection> connection125 = connectionRepository.findById(125L);

            if (connection125.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection125.get())
                            .airline(airline1.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(80)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:00:00"))
                                    .flightTime(LocalTime.parse("01:30:00"))
                                    .build())
                            .build());
                }
            }


            // 126. FROM CRACOW TO WARSAW
            Optional<Connection> connection126 = connectionRepository.findById(126L);

            if (connection126.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection126.get())
                            .airline(airline1.get())
                            .numberSeats(125)
                            .availableSeats(125)
                            .price(80)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:15:00"))
                                    .flightTime(LocalTime.parse("01:30:00"))
                                    .build())
                            .build());
                }
            }


            // 127. FROM BERLIN TO OSLO
            Optional<Connection> connection127 = connectionRepository.findById(127L);

            if (connection127.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection127.get())
                            .airline(airline2.get())
                            .numberSeats(130)
                            .availableSeats(130)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:30:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 128. FROM OSLO TO BERLIN
            Optional<Connection> connection128 = connectionRepository.findById(128L);

            if (connection128.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection128.get())
                            .airline(airline9.get())
                            .numberSeats(135)
                            .availableSeats(135)
                            .price(150)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("13:45:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 129. FROM TOKIO TO PARIS
            Optional<Connection> connection129 = connectionRepository.findById(129L);

            if (connection129.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection129.get())
                            .airline(airline7.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(590)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:00:00"))
                                    .flightTime(LocalTime.parse("15:30:00"))
                                    .build())
                            .build());
                }
            }


            // 130. FROM PARIS TO TOKIO
            Optional<Connection> connection130 = connectionRepository.findById(130L);

            if (connection130.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection130.get())
                            .airline(airline10.get())
                            .numberSeats(145)
                            .availableSeats(145)
                            .price(590)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:15:00"))
                                    .flightTime(LocalTime.parse("15:30:00"))
                                    .build())
                            .build());
                }
            }


            // 131. FROM BERLIN TO PARIS
            Optional<Connection> connection131 = connectionRepository.findById(131L);

            if (connection131.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection131.get())
                            .airline(airline2.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:30:00"))
                                    .flightTime(LocalTime.parse("01:45:00"))
                                    .build())
                            .build());
                }
            }


            // 132. FROM PARIS TO BERLIN
            Optional<Connection> connection132 = connectionRepository.findById(132L);

            if (connection132.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection132.get())
                            .airline(airline10.get())
                            .numberSeats(155)
                            .availableSeats(155)
                            .price(120)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("14:45:00"))
                                    .flightTime(LocalTime.parse("01:45:00"))
                                    .build())
                            .build());
                }
            }


            // 133. FROM PEKIN TO LONDON
            Optional<Connection> connection133 = connectionRepository.findById(133L);

            if (connection133.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection133.get())
                            .airline(airline4.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(540)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:00:00"))
                                    .flightTime(LocalTime.parse("14:15:00"))
                                    .build())
                            .build());
                }
            }


            // 134. FROM LONDON TO PEKIN
            Optional<Connection> connection134 = connectionRepository.findById(134L);

            if (connection134.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection134.get())
                            .airline(airline12.get())
                            .numberSeats(165)
                            .availableSeats(165)
                            .price(540)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:15:00"))
                                    .flightTime(LocalTime.parse("14:15:00"))
                                    .build())
                            .build());
                }
            }


            // 135. FROM LONDON TO TOKIO
            Optional<Connection> connection135 = connectionRepository.findById(135L);

            if (connection135.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection135.get())
                            .airline(airline12.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(600)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:30:00"))
                                    .flightTime(LocalTime.parse("16:00:00"))
                                    .build())
                            .build());
                }
            }


            // 136. FROM TOKIO TO LONDON
            Optional<Connection> connection136 = connectionRepository.findById(136L);

            if (connection136.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection136.get())
                            .airline(airline7.get())
                            .numberSeats(175)
                            .availableSeats(175)
                            .price(600)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("15:45:00"))
                                    .flightTime(LocalTime.parse("16:00:00"))
                                    .build())
                            .build());
                }
            }


            // 137. FROM CRACOW TO PARIS
            Optional<Connection> connection137 = connectionRepository.findById(137L);

            if (connection137.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection137.get())
                            .airline(airline1.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(300)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:00:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 138. FROM PARIS TO CRACOW
            Optional<Connection> connection138 = connectionRepository.findById(138L);

            if (connection138.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection138.get())
                            .airline(airline10.get())
                            .numberSeats(185)
                            .availableSeats(185)
                            .price(300)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:15:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 139. FROM PEKIN TO PARIS
            Optional<Connection> connection139 = connectionRepository.findById(139L);

            if (connection139.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection139.get())
                            .airline(airline4.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:30:00"))
                                    .flightTime(LocalTime.parse("14:00:00"))
                                    .build())
                            .build());
                }
            }


            // 140. FROM PARIS TO PEKIN
            Optional<Connection> connection140 = connectionRepository.findById(140L);

            if (connection140.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection140.get())
                            .airline(airline10.get())
                            .numberSeats(195)
                            .availableSeats(195)
                            .price(550)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("16:45:00"))
                                    .flightTime(LocalTime.parse("14:00:00"))
                                    .build())
                            .build());
                }
            }


            // 141. FROM NEW YORK TO PARIS
            Optional<Connection> connection141 = connectionRepository.findById(141L);

            if (connection141.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection141.get())
                            .airline(airline3.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:00:00"))
                                    .flightTime(LocalTime.parse("07:30:00"))
                                    .build())
                            .build());
                }
            }


            // 142. FROM PARIS TO NEW YORK
            Optional<Connection> connection142 = connectionRepository.findById(142L);

            if (connection142.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection142.get())
                            .airline(airline10.get())
                            .numberSeats(205)
                            .availableSeats(205)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:15:00"))
                                    .flightTime(LocalTime.parse("07:30:00"))
                                    .build())
                            .build());
                }
            }


            // 143. FROM WARSAW TO PARIS
            Optional<Connection> connection143 = connectionRepository.findById(143L);

            if (connection143.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection143.get())
                            .airline(airline1.get())
                            .numberSeats(210)
                            .availableSeats(210)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:30:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 144. FROM PARIS TO WARSAW
            Optional<Connection> connection144 = connectionRepository.findById(144L);

            if (connection144.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection144.get())
                            .airline(airline10.get())
                            .numberSeats(215)
                            .availableSeats(215)
                            .price(200)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("17:45:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 145. FROM RIO DE JANEIRO TO PARIS
            Optional<Connection> connection145 = connectionRepository.findById(145L);

            if (connection145.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection145.get())
                            .airline(airline8.get())
                            .numberSeats(220)
                            .availableSeats(220)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:00:00"))
                                    .flightTime(LocalTime.parse("08:00:00"))
                                    .build())
                            .build());
                }
            }


            // 146. FROM PARIS TO RIO DE JANEIRO
            Optional<Connection> connection146 = connectionRepository.findById(146L);

            if (connection146.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection146.get())
                            .airline(airline10.get())
                            .numberSeats(225)
                            .availableSeats(225)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:15:00"))
                                    .flightTime(LocalTime.parse("08:00:00"))
                                    .build())
                            .build());
                }
            }


            // 147. FROM CHICAGO TO PARIS
            Optional<Connection> connection147 = connectionRepository.findById(147L);

            if (connection147.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection147.get())
                            .airline(airline3.get())
                            .numberSeats(230)
                            .availableSeats(230)
                            .price(420)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:30:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 148. FROM PARIS TO CHICAGO
            Optional<Connection> connection148 = connectionRepository.findById(148L);

            if (connection148.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection148.get())
                            .airline(airline10.get())
                            .numberSeats(225)
                            .availableSeats(225)
                            .price(420)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("18:45:00"))
                                    .flightTime(LocalTime.parse("09:00:00"))
                                    .build())
                            .build());
                }
            }


            // 149. FROM TORONTO TO PARIS
            Optional<Connection> connection149 = connectionRepository.findById(149L);

            if (connection149.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection149.get())
                            .airline(airline5.get())
                            .numberSeats(220)
                            .availableSeats(220)
                            .price(390)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:00:00"))
                                    .flightTime(LocalTime.parse("07:00:00"))
                                    .build())
                            .build());
                }
            }


            // 150. FROM PARIS TO TORONTO
            Optional<Connection> connection150 = connectionRepository.findById(150L);

            if (connection150.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection150.get())
                            .airline(airline10.get())
                            .numberSeats(215)
                            .availableSeats(215)
                            .price(390)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:15:00"))
                                    .flightTime(LocalTime.parse("07:00:00"))
                                    .build())
                            .build());
                }
            }


            // 151. FROM TOKIO TO SZANGHAI
            Optional<Connection> connection151 = connectionRepository.findById(151L);

            if (connection151.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection151.get())
                            .airline(airline7.get())
                            .numberSeats(210)
                            .availableSeats(210)
                            .price(190)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:30:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 152. FROM SZANGHAI TO TOKIO
            Optional<Connection> connection152 = connectionRepository.findById(152L);

            if (connection152.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection152.get())
                            .airline(airline14.get())
                            .numberSeats(205)
                            .availableSeats(205)
                            .price(190)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("19:45:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 153. FROM TORONTO TO NEW YORK
            Optional<Connection> connection153 = connectionRepository.findById(153L);

            if (connection153.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection153.get())
                            .airline(airline5.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(160)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:00:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 154. FROM NEW YORK TO TORONTO
            Optional<Connection> connection154 = connectionRepository.findById(154L);

            if (connection154.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection154.get())
                            .airline(airline3.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(160)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:15:00"))
                                    .flightTime(LocalTime.parse("02:00:00"))
                                    .build())
                            .build());
                }
            }


            // 155. FROM TORONTO TO DELHI
            Optional<Connection> connection155 = connectionRepository.findById(155L);

            if (connection155.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection155.get())
                            .airline(airline5.get())
                            .numberSeats(185)
                            .availableSeats(185)
                            .price(500)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:30:00"))
                                    .flightTime(LocalTime.parse("13:30:00"))
                                    .build())
                            .build());
                }
            }


            // 156. FROM DELHI TO TORONTO
            Optional<Connection> connection156 = connectionRepository.findById(156L);

            if (connection156.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection156.get())
                            .airline(airline14.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(500)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("20:45:00"))
                                    .flightTime(LocalTime.parse("13:30:00"))
                                    .build())
                            .build());
                }
            }


            // 157. FROM WARSAW TO KIEV
            Optional<Connection> connection157 = connectionRepository.findById(157L);

            if (connection157.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection157.get())
                            .airline(airline1.get())
                            .numberSeats(175)
                            .availableSeats(175)
                            .price(210)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:00:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 158. FROM KIEV TO WARSAW
            Optional<Connection> connection158 = connectionRepository.findById(158L);

            if (connection158.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection158.get())
                            .airline(airline15.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(210)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:15:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 159. FROM KIEV TO CAIRO
            Optional<Connection> connection159 = connectionRepository.findById(159L);

            if (connection159.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection159.get())
                            .airline(airline15.get())
                            .numberSeats(165)
                            .availableSeats(165)
                            .price(290)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:30:00"))
                                    .flightTime(LocalTime.parse("03:30:00"))
                                    .build())
                            .build());
                }
            }


            // 160. FROM CAIRO TO KIEV
            Optional<Connection> connection160 = connectionRepository.findById(160L);

            if (connection160.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection160.get())
                            .airline(airline13.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(290)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("21:45:00"))
                                    .flightTime(LocalTime.parse("03:30:00"))
                                    .build())
                            .build());
                }
            }


            // 161. FROM DELHI TO PARIS
            Optional<Connection> connection161 = connectionRepository.findById(161L);

            if (connection161.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection161.get())
                            .airline(airline14.get())
                            .numberSeats(155)
                            .availableSeats(155)
                            .price(480)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:00:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 162. FROM PARIS TO DELHI
            Optional<Connection> connection162 = connectionRepository.findById(162L);

            if (connection162.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection162.get())
                            .airline(airline10.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(480)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:15:00"))
                                    .flightTime(LocalTime.parse("10:00:00"))
                                    .build())
                            .build());
                }
            }


            // 163. FROM DELHI TO LONDON
            Optional<Connection> connection163 = connectionRepository.findById(163L);

            if (connection163.isPresent() && airline14.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection163.get())
                            .airline(airline14.get())
                            .numberSeats(145)
                            .availableSeats(145)
                            .price(500)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:30:00"))
                                    .flightTime(LocalTime.parse("10:45:00"))
                                    .build())
                            .build());
                }
            }


            // 164. FROM LONDON TO DELHI
            Optional<Connection> connection164 = connectionRepository.findById(164L);

            if (connection164.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection164.get())
                            .airline(airline11.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(500)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("22:45:00"))
                                    .flightTime(LocalTime.parse("10:45:00"))
                                    .build())
                            .build());
                }
            }


            // 165. FROM NEW YORK TO RIO DE JANEIRO
            Optional<Connection> connection165 = connectionRepository.findById(165L);

            if (connection165.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection165.get())
                            .airline(airline3.get())
                            .numberSeats(135)
                            .availableSeats(135)
                            .price(340)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("23:00:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }


            // 166. FROM RIO DE JANEIRO TO NEW YORK
            Optional<Connection> connection166 = connectionRepository.findById(166L);

            if (connection166.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection166.get())
                            .airline(airline8.get())
                            .numberSeats(130)
                            .availableSeats(130)
                            .price(340)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("23:15:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }


            // 167. FROM MOSCOW TO SYDNEY
            Optional<Connection> connection167 = connectionRepository.findById(167L);

            if (connection167.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection167.get())
                            .airline(airline12.get())
                            .numberSeats(125)
                            .availableSeats(125)
                            .price(430)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("23:30:00"))
                                    .flightTime(LocalTime.parse("06:30:00"))
                                    .build())
                            .build());
                }
            }


            // 168. FROM SYDNEY TO MOSCOW
            Optional<Connection> connection168 = connectionRepository.findById(168L);

            if (connection168.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection168.get())
                            .airline(airline6.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(430)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("23:45:00"))
                                    .flightTime(LocalTime.parse("06:30:00"))
                                    .build())
                            .build());
                }
            }


            // 169. FROM WARSAW TO OSLO
            Optional<Connection> connection169 = connectionRepository.findById(169L);

            if (connection169.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection169.get())
                            .airline(airline1.get())
                            .numberSeats(115)
                            .availableSeats(115)
                            .price(190)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("00:15:00"))
                                    .flightTime(LocalTime.parse("02:15:00"))
                                    .build())
                            .build());
                }
            }


            // 170. FROM OSLO TO WARSAW
            Optional<Connection> connection170 = connectionRepository.findById(170L);

            if (connection170.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection170.get())
                            .airline(airline9.get())
                            .numberSeats(110)
                            .availableSeats(110)
                            .price(190)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("00:30:00"))
                                    .flightTime(LocalTime.parse("02:15:00"))
                                    .build())
                            .build());
                }
            }


            // 171. FROM CRACOW TO OSLO
            Optional<Connection> connection171 = connectionRepository.findById(171L);

            if (connection171.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection171.get())
                            .airline(airline1.get())
                            .numberSeats(105)
                            .availableSeats(105)
                            .price(250)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("00:45:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 172. FROM OSLO TO CRACOW
            Optional<Connection> connection172 = connectionRepository.findById(172L);

            if (connection172.isPresent() && airline9.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection172.get())
                            .airline(airline9.get())
                            .numberSeats(100)
                            .availableSeats(100)
                            .price(250)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("01:00:00"))
                                    .flightTime(LocalTime.parse("03:00:00"))
                                    .build())
                            .build());
                }
            }


            // 173. FROM CHICAGO TO TOKIO
            Optional<Connection> connection173 = connectionRepository.findById(173L);

            if (connection173.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection173.get())
                            .airline(airline3.get())
                            .numberSeats(95)
                            .availableSeats(95)
                            .price(580)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("01:15:00"))
                                    .flightTime(LocalTime.parse("15:30:00"))
                                    .build())
                            .build());
                }
            }


            // 174. FROM TOKIO TO CHICAGO
            Optional<Connection> connection174 = connectionRepository.findById(174L);

            if (connection174.isPresent() && airline7.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection174.get())
                            .airline(airline7.get())
                            .numberSeats(90)
                            .availableSeats(90)
                            .price(580)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("01:30:00"))
                                    .flightTime(LocalTime.parse("15:30:00"))
                                    .build())
                            .build());
                }
            }


            // 175. FROM SYDNEY TO RIO DE JANEIRO
            Optional<Connection> connection175 = connectionRepository.findById(175L);

            if (connection175.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection175.get())
                            .airline(airline6.get())
                            .numberSeats(95)
                            .availableSeats(95)
                            .price(520)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("01:45:00"))
                                    .flightTime(LocalTime.parse("12:30:00"))
                                    .build())
                            .build());
                }
            }


            // 176. FROM RIO DE JANEIRO TO SYDNEY
            Optional<Connection> connection176 = connectionRepository.findById(176L);

            if (connection176.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection176.get())
                            .airline(airline8.get())
                            .numberSeats(100)
                            .availableSeats(100)
                            .price(520)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("02:00:00"))
                                    .flightTime(LocalTime.parse("12:30:00"))
                                    .build())
                            .build());
                }
            }


            // 177. FROM LONDON TO BUENOS AIRES
            Optional<Connection> connection177 = connectionRepository.findById(177L);

            if (connection177.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection177.get())
                            .airline(airline11.get())
                            .numberSeats(105)
                            .availableSeats(105)
                            .price(440)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("02:15:00"))
                                    .flightTime(LocalTime.parse("07:30:00"))
                                    .build())
                            .build());
                }
            }


            // 178. FROM BUENOS AIRES TO LONDON
            Optional<Connection> connection178 = connectionRepository.findById(178L);

            if (connection178.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection178.get())
                            .airline(airline8.get())
                            .numberSeats(110)
                            .availableSeats(110)
                            .price(440)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("02:30:00"))
                                    .flightTime(LocalTime.parse("07:30:00"))
                                    .build())
                            .build());
                }
            }


            // 179. FROM BERLIN TO PARIS
            Optional<Connection> connection179 = connectionRepository.findById(179L);

            if (connection179.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection179.get())
                            .airline(airline2.get())
                            .numberSeats(115)
                            .availableSeats(115)
                            .price(180)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("02:45:00"))
                                    .flightTime(LocalTime.parse("01:45:00"))
                                    .build())
                            .build());
                }
            }


            // 180. FROM PARIS TO BERLIN
            Optional<Connection> connection180 = connectionRepository.findById(180L);

            if (connection180.isPresent() && airline10.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection180.get())
                            .airline(airline10.get())
                            .numberSeats(120)
                            .availableSeats(120)
                            .price(180)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("03:00:00"))
                                    .flightTime(LocalTime.parse("01:45:00"))
                                    .build())
                            .build());
                }
            }


            // 181. FROM KIEV TO RIO DE JANEIRO
            Optional<Connection> connection181 = connectionRepository.findById(181L);

            if (connection181.isPresent() && airline15.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection181.get())
                            .airline(airline15.get())
                            .numberSeats(125)
                            .availableSeats(125)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("03:15:00"))
                                    .flightTime(LocalTime.parse("09:30:00"))
                                    .build())
                            .build());
                }
            }


            // 182. FROM RIO DE JANEIRO TO KIEV
            Optional<Connection> connection182 = connectionRepository.findById(182L);

            if (connection182.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection182.get())
                            .airline(airline8.get())
                            .numberSeats(130)
                            .availableSeats(130)
                            .price(450)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("03:30:00"))
                                    .flightTime(LocalTime.parse("09:30:00"))
                                    .build())
                            .build());
                }
            }


            // 183. FROM SZANGHAI TO LONDON
            Optional<Connection> connection183 = connectionRepository.findById(183L);

            if (connection183.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection183.get())
                            .airline(airline4.get())
                            .numberSeats(135)
                            .availableSeats(135)
                            .price(620)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("03:45:00"))
                                    .flightTime(LocalTime.parse("16:30:00"))
                                    .build())
                            .build());
                }
            }


            // 184. FROM LONDON TO SZANHGAI
            Optional<Connection> connection184 = connectionRepository.findById(184L);

            if (connection184.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection184.get())
                            .airline(airline11.get())
                            .numberSeats(140)
                            .availableSeats(140)
                            .price(620)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:00:00"))
                                    .flightTime(LocalTime.parse("16:30:00"))
                                    .build())
                            .build());
                }
            }


            // 185. FROM PEKIN TO CRACOW
            Optional<Connection> connection185 = connectionRepository.findById(185L);

            if (connection185.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection185.get())
                            .airline(airline4.get())
                            .numberSeats(150)
                            .availableSeats(150)
                            .price(430)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:15:00"))
                                    .flightTime(LocalTime.parse("08:30:00"))
                                    .build())
                            .build());
                }
            }


            // 186. FROM CRACOW TO PEKIN
            Optional<Connection> connection186 = connectionRepository.findById(186L);

            if (connection186.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection186.get())
                            .airline(airline1.get())
                            .numberSeats(155)
                            .availableSeats(155)
                            .price(430)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:30:00"))
                                    .flightTime(LocalTime.parse("08:30:00"))
                                    .build())
                            .build());
                }
            }


            // 187. FROM PEKIN TO MOSCOW
            Optional<Connection> connection187 = connectionRepository.findById(187L);

            if (connection187.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection187.get())
                            .airline(airline4.get())
                            .numberSeats(160)
                            .availableSeats(160)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("04:45:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 188. FROM MOSCOW TO PEKIN
            Optional<Connection> connection188 = connectionRepository.findById(188L);

            if (connection188.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection188.get())
                            .airline(airline12.get())
                            .numberSeats(165)
                            .availableSeats(165)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:00:00"))
                                    .flightTime(LocalTime.parse("06:00:00"))
                                    .build())
                            .build());
                }
            }


            // 189. FROM PEKIN TO BERLIN
            Optional<Connection> connection189 = connectionRepository.findById(189L);

            if (connection189.isPresent() && airline4.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection189.get())
                            .airline(airline4.get())
                            .numberSeats(170)
                            .availableSeats(170)
                            .price(480)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:15:00"))
                                    .flightTime(LocalTime.parse("08:00:00"))
                                    .build())
                            .build());
                }
            }


            // 190. FROM BERLIN TO PEKIN
            Optional<Connection> connection190 = connectionRepository.findById(190L);

            if (connection190.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection190.get())
                            .airline(airline2.get())
                            .numberSeats(175)
                            .availableSeats(175)
                            .price(480)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:30:00"))
                                    .flightTime(LocalTime.parse("08:00:00"))
                                    .build())
                            .build());
                }
            }


            // 191. FROM CRACOW TO LONDON
            Optional<Connection> connection191 = connectionRepository.findById(191L);

            if (connection191.isPresent() && airline1.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection191.get())
                            .airline(airline1.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(250)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("05:45:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 192. FROM LONDON TO CRACOW
            Optional<Connection> connection192 = connectionRepository.findById(192L);

            if (connection192.isPresent() && airline11.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection192.get())
                            .airline(airline11.get())
                            .numberSeats(185)
                            .availableSeats(185)
                            .price(250)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:00:00"))
                                    .flightTime(LocalTime.parse("02:30:00"))
                                    .build())
                            .build());
                }
            }


            // 193. FROM SYDNEY TO CAIRO
            Optional<Connection> connection193 = connectionRepository.findById(193L);

            if (connection193.isPresent() && airline6.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection193.get())
                            .airline(airline6.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:15:00"))
                                    .flightTime(LocalTime.parse("07:15:00"))
                                    .build())
                            .build());
                }
            }


            // 194. FROM CAIRO TO SYDNEY
            Optional<Connection> connection194 = connectionRepository.findById(194L);

            if (connection194.isPresent() && airline13.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection194.get())
                            .airline(airline13.get())
                            .numberSeats(195)
                            .availableSeats(195)
                            .price(400)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:30:00"))
                                    .flightTime(LocalTime.parse("07:15:00"))
                                    .build())
                            .build());
                }
            }


            // 195. FROM TORONTO TO BUENOS AIRES
            Optional<Connection> connection195 = connectionRepository.findById(195L);

            if (connection195.isPresent() && airline5.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection195.get())
                            .airline(airline5.get())
                            .numberSeats(200)
                            .availableSeats(200)
                            .price(360)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("06:45:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }


            // 196. FROM BUENOS AIRES TO TORONTO
            Optional<Connection> connection196 = connectionRepository.findById(196L);

            if (connection196.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection196.get())
                            .airline(airline8.get())
                            .numberSeats(195)
                            .availableSeats(195)
                            .price(360)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:00:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }


            // 197. FROM CHICAGO TO BUENOS AIRES
            Optional<Connection> connection197 = connectionRepository.findById(197L);

            if (connection197.isPresent() && airline3.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection197.get())
                            .airline(airline3.get())
                            .numberSeats(190)
                            .availableSeats(190)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:15:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }


            // 198. FROM BUENOS AIRES TO CHICAGO
            Optional<Connection> connection198 = connectionRepository.findById(198L);

            if (connection198.isPresent() && airline8.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection198.get())
                            .airline(airline8.get())
                            .numberSeats(185)
                            .availableSeats(185)
                            .price(380)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:30:00"))
                                    .flightTime(LocalTime.parse("05:00:00"))
                                    .build())
                            .build());
                }
            }


            // 199. FROM MOSCOW TO BERLIN
            Optional<Connection> connection199 = connectionRepository.findById(199L);

            if (connection199.isPresent() && airline12.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection199.get())
                            .airline(airline12.get())
                            .numberSeats(180)
                            .availableSeats(180)
                            .price(330)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("07:45:00"))
                                    .flightTime(LocalTime.parse("03:30:00"))
                                    .build())
                            .build());
                }
            }


            // 200. FROM BERLIN TO MOSCOW
            Optional<Connection> connection200 = connectionRepository.findById(200L);

            if (connection200.isPresent() && airline2.isPresent()) {
                for (int i = 0; i < MAX_DAYS_TO_LOAD; i++) {
                    flightRepository.save(Flight.builder()
                            .connection(connection200.get())
                            .airline(airline2.get())
                            .numberSeats(175)
                            .availableSeats(175)
                            .price(330)
                            .times(Times.
                                    builder()
                                    .departureDate((LocalDate.parse(FIRST_DAY)).plusDays(i))
                                    .departureTime(LocalTime.parse("08:00:00"))
                                    .flightTime(LocalTime.parse("03:30:00"))
                                    .build())
                            .build());
                }
            }
        }
    }
}
