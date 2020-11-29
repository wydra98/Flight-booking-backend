package flight_booking.backend.models;

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
    @OneToMany(mappedBy = "flight")
    private List<Seat> seats;

    public void updateForm(Airline airline,
                           int numberSeats,
                           double price,
                           String departureDate,
                           String departureTime,
                           String flightTime) {

        String parsedTime = null;
        if (flightTime.length() == 1) {
            parsedTime = "0" + flightTime + ":00";
        } else {
            parsedTime = flightTime + ":00";
        }
        String parsedDepartureTime = null;
        String[] arrayString = departureTime.split(":");
        if (arrayString[0].length() == 1) {
            arrayString[0] = '0' + arrayString[0];
        }
        if (arrayString[1].length() == 1) {
            arrayString[1] = '0' + arrayString[1];
        }
        parsedDepartureTime = arrayString[0] + ":" + arrayString[1];


        this.airline = airline;
        this.numberSeats = numberSeats;
        this.price = price;
        this.getTimes().setDepartureDate(LocalDate.parse(departureDate));
        this.getTimes().setDepartureTime(LocalTime.parse(parsedDepartureTime));
        this.getTimes().setFlightTime(LocalTime.parse(parsedTime));

    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public void removeSeat(int seatNumber) {
        for (Seat seat : seats) {
            if (seat.getSeatNumber() == seatNumber) {
                seats.remove(seat);
                break;
            }
        }
    }
}
