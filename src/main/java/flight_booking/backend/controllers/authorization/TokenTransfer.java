package flight_booking.backend.controllers.authorization;

import flight_booking.backend.controllers.user.UserDto;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class TokenTransfer {
    private String token;
    private UserDto userDto;
}
