package pl.edu.pk.siwz.backend.models.Connection;

import javax.persistence.*;

import lombok.*;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Times;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "connections")
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "connection_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "airport_src_id")
    private Airport srcAirport;
    @OneToOne
    @JoinColumn(name = "airport_dst_id")
    private Airport dstAirport;
    @OneToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    private int numberSeats;
    @Embedded
    private Times times;
    private double price;
}
