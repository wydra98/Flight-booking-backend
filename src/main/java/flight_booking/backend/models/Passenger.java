package flight_booking.backend.models;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "passenger_id")
    private Long id;
    private String pesel;
    private String firstName;
    private String surname;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    @OneToMany(mappedBy = "passenger")
    private Set<Trip> trips;
    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;
}
