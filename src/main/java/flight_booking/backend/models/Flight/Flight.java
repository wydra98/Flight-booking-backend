package flight_booking.backend.models.Flight;

import flight_booking.backend.models.Airline.Airline;
import flight_booking.backend.models.Connection.Connection;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "flight_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "id_connection")
    private Connection connection;
    @ManyToOne
    @JoinColumn(name = "id_airline")
    private Airline airline;
    int numberSeats;
    double price;

    public void updateForm(Airline airline, int numberSeats, double price) {
        this.airline = airline;
        this.numberSeats = numberSeats;
        this.price = price;
    }
}
