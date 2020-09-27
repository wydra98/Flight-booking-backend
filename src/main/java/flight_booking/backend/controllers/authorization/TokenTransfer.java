package flight_booking.backend.controllers.authorization;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter

public class TokenTransfer {
    private String token;
    private String name;
    private String surname;
    private String email;
    private String role;
}
