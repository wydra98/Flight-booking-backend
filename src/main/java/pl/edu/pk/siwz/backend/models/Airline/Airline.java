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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "airline_id")
    private Long id;
    private String name;
    private String country;
    private String code;
}
