package pl.edu.pk.siwz.backend.models.Connection;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineMapper;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportMapper;
import pl.edu.pk.siwz.backend.controllers.ConnectionController.ConnectionDto;
import pl.edu.pk.siwz.backend.models.Airline.Airline;
import pl.edu.pk.siwz.backend.models.Airport.Airport;
import pl.edu.pk.siwz.backend.models.Times;
import pl.edu.pk.siwz.backend.service.ConnectionService;

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

    public void updateForm(Long id,
                           Airport srcAirport,
                           Airport dstAirport,
                           Airline airline,
                           int numberSeats,
                           String arrivalDate,
                           String  arrivalTime,
                           String departureDate,
                           String departureTime,
                           double price
    ) {

        this.id = id;
        this.srcAirport = srcAirport;
        this.dstAirport = dstAirport;
        this.airline = airline;
        this.numberSeats = numberSeats;
        this.getTimes().setDepartureDate(LocalDate.parse(departureDate));
        this.getTimes().setArrivalDate(LocalDate.parse(arrivalDate));
        this.getTimes().setDepartureTime(LocalTime.parse(departureTime));
        this.getTimes().setArrivalTime(LocalTime.parse(arrivalTime));
        this.price = price;

    }
}
