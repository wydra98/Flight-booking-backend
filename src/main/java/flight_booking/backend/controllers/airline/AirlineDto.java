package flight_booking.backend.controllers.airline;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirlineDto {
    private Long id;
    private String name;
    private String country;
}
