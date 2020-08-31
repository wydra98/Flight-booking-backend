package flight_booking.backend.models;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private Integer seatNumber;
    private double price;

}
