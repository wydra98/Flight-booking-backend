package flight_booking.backend.models.Connection;

import javax.persistence.*;

import flight_booking.backend.models.Airline.Airline;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import flight_booking.backend.models.Airport.Airport;
import flight_booking.backend.models.Times;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "connection_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_src_airport")
    private Airport srcAirport;
    @ManyToOne
    @JoinColumn(name = "id_dst_airport")
    private Airport dstAirport;

    public void updateForm(
            Airport srcAirport,
            Airport dstAirport
    ) {
        this.srcAirport = srcAirport;
        this.dstAirport = dstAirport;
    }
}
