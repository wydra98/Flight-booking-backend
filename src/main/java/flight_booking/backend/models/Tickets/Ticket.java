package flight_booking.backend.models.Tickets;


import flight_booking.backend.models.Flights.Flight;
import flight_booking.backend.models.Passengers.Passenger;
import flight_booking.backend.models.Trips.Trip;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "ticket_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_passenger")
    private Passenger passenger;

    @OneToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_trip")
    private Trip trip;

    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private Integer seatNumber;
    private double price;


}
