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
        }
    }
}