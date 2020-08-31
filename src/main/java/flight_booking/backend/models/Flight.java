package flight_booking.backend.models;

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
@Setter
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "flight_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_connection")
    private Connection connection;
    @ManyToOne
    @JoinColumn(name = "id_airline")
    private Airline airline;
    private int numberSeats;
    private int availableSeats;
    private double price;
    @Embedded
    private Times times;

    public void updateForm(Airline airline,
                           int numberSeats,
                           double price,
                           String departureTime,
                           String departureDate,
                           String flightTime) {

        this.airline = airline;
        this.numberSeats = numberSeats;
        this.price = price;
        this.getTimes().setDepartureDate(LocalDate.parse(departureDate));
        this.getTimes().setDepartureTime(LocalTime.parse(departureTime));
        this.getTimes().setFlightTime(LocalTime.parse(flightTime));
    }
}
