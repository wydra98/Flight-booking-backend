package pl.edu.pk.siwz.backend.models.Connection;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Times;

import java.time.LocalDateTime;

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
    private Long id;
    @OneToOne
    @JoinColumn(name = "src_airport_id")
    private Airport srcAirport;
    @OneToOne
    @JoinColumn(name = "dst_airport_dst")
    private Airport dstAirport;
    @OneToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    @Embedded
    private Times times;

    public void updateForm(Long id,
                           Airport srcAirport,
                           Airport dstAirport,
                           String arrivalDate,
                           String departureDate
                           ) {
        this.id = id;
        this.srcAirport = srcAirport;
        this.dstAirport = dstAirport;
        this.getTimes().setDepartureDate(LocalDateTime.parse(departureDate));
        this.getTimes().setArrivalDate(LocalDateTime.parse(arrivalDate));
    }
}
