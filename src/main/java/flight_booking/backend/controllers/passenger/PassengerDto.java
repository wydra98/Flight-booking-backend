package flight_booking.backend.controllers.passenger;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long id;
    private String pesel;
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
}
