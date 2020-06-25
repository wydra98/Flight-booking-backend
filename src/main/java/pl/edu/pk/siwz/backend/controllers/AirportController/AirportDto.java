package pl.edu.pk.siwz.backend.controllers.AirportController;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AirportDto {
    private Long id;
    private String name;
    private String city;
    private String country;
    private int timezone;
}
