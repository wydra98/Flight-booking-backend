package flight_booking.backend.models.Trips;

import flight_booking.backend.models.Tickets.Ticket;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "trip_id")
    private Long id;

    @OneToMany(mappedBy = "trip")
    private List<Ticket> tickets;

//    @ManyToOne
//    @JoinColumn(name = "id_passenger")
//    private Passenger passenger;

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private double price;

}
