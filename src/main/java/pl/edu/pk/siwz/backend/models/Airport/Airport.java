package pl.edu.pk.siwz.backend.models.Airport;

import javax.persistence.*;

import lombok.*;

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
    @Column(name = "airport_id",updatable = false, nullable = false)
    private long id;
    private String name;
    private String city;
    private String country;
    private double longitude;
    private double latitude;
    private int timezone;
    private String code;
}
