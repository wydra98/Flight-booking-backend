package flight_booking.backend.models.Ticket;


import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Passenger.Passenger;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
    @ManyToMany
    @JoinColumn(name = "id_flight")
    private List<Flight> flights;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private int seatNumber;
    private double price;

}
