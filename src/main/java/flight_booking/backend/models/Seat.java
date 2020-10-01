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
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "seat_id")
    private Long id;
    private int seatNumber;
    @ManyToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;
}
