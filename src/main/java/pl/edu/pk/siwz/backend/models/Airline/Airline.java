package pl.edu.pk.siwz.backend.models.Airline;

import lombok.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id",updatable = false, nullable = false)
    private Long id;
    private String name;
    private String country;
    private String code;
}
