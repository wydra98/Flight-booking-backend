package pl.edu.pk.siwz.backend.models.Airport;

import javax.persistence.*;

import lombok.*;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airport_id", updatable = false, nullable = false)
    private Long id;
    private String name;
    private String city;
    private String country;
    private double longitude;
    private double latitude;
    private int timezone;

    public void updateForm(AirportDto airportDto, double longitude, double latitude) {
        this.name = airportDto.getName();
        this.city = airportDto.getCity();
        this.country = airportDto.getCountry();
        this.longitude = longitude;
        this.latitude = latitude;
        this.timezone = airportDto.getTimezone();
    }
}
