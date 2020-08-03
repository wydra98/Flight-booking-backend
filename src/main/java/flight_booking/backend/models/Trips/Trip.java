package flight_booking.backend.models.Trips;

import flight_booking.backend.models.Flight.Flight;
import flight_booking.backend.models.Passenger.Passenger;
import flight_booking.backend.models.Ticket.Ticket;
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
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "trip_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_ticket")
    private Ticket tickets;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private double price;
}
