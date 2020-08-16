package flight_booking.backend.models.Flight;

import flight_booking.backend.models.Airline.Airline;
import flight_booking.backend.models.Connection.Connection;
import flight_booking.backend.models.Times;
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

    @Embedded
    private Times times;

    public void updateForm(Airline airline,
                           int numberSeats,
                           double price,
                           String arrivalDate,
                           String departureDate,
                           String arrivalTime,
                           String departureTime) {

        this.airline = airline;
        this.numberSeats = numberSeats;
        this.price = price;
        this.getTimes().setDepartureDate(LocalDate.parse(departureDate));
        this.getTimes().setArrivalDate(LocalDate.parse(arrivalDate));
        this.getTimes().setArrivalTime(LocalTime.parse(arrivalTime));
        this.getTimes().setDepartureTime(LocalTime.parse(departureTime));
    }
}
