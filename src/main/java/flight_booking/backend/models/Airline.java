package flight_booking.backend.models;

import lombok.*;
import flight_booking.backend.controllers.AirlineController.AirlineDto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "airlines")
public class Airline {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "airline_id")
    private Long id;
    private String name;
    private String country;

    public void updateForm(AirlineDto airlineDto, String country) {
        this.name = airlineDto.getName();
        this.country = country;
    }
}
