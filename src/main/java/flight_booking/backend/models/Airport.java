package flight_booking.backend.models;

import javax.persistence.*;

import flight_booking.backend.controllers.airport.AirportDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "airport_id")
    private Long id;
    private String name;
    private String city;
    private String country;
    private double longitude;
    private double latitude;
    private int timezone;

    public void updateForm(AirportDto airportDto) {
        this.name = airportDto.getName();
        this.city = airportDto.getCity();
        this.country = airportDto.getCountry();
        this.timezone = airportDto.getTimezone();
        this.longitude = airportDto.getLongitude();
        this.latitude = airportDto.getLatitude();
    }
}
