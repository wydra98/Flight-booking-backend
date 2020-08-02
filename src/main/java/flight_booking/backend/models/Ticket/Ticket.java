package flight_booking.backend.models.Ticket;


import flight_booking.backend.controllers.FlightController.FlightDto;
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
    @OneToOne
    @JoinColumn(name = "id_flight")
    private Flight flight;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private int seatNumber;
    private double price;


}
