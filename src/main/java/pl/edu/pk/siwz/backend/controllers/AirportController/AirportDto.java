package pl.edu.pk.siwz.backend.controllers.AirportController;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AirportDto {
    private String code;
    private String airportName;
    private String city;
    private String country;
    private int timezone;
}
