package flight_booking.backend.controllers.airport;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AirportDto {
    private Long id;
    private String name;
    private String city;
    private String country;
    private int timezone;
    private double longitude;
    private double latitude;
}
