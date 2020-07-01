package flight_booking.backend.controllers.PassengerController;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PassengerDto {
    private Long id;
    private String firstName;
    private String surname;
    private String dateOfBirth;
    private String phoneNumber;
    private String email;
}
