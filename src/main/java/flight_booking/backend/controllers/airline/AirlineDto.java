package flight_booking.backend.controllers.airline;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AirlineDto {
    private Long id;
    private String name;
}
