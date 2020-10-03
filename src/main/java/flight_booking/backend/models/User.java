package flight_booking.backend.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@ToString
@AllArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    @Column(name = "user_id")
    private Long id;
    private String password;
    private String role;
    @Email
    private String email;
    private String name;
    private String surname;
    @OneToMany(mappedBy = "user")
    private Set<Trip> trips;

    public User() {
        this.role = "ROLE_USER";
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = "ROLE_USER";
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }
}
