package pl.edu.pk.siwz.backend.controllers.ConnectionController;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pk.siwz.backend.controllers.AirlineController.AirlineDto;
import pl.edu.pk.siwz.backend.controllers.AirportController.AirportDto;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConnectionDto {
    private Long id;
    private AirportDto srcAirportDto;
    private AirportDto  dstAirportDto;
    private AirlineDto airlineDto;
    private int numberSeats;
    private String departureDate;
    private String arrivalDate;
    private String departureTime;
    private String arrivalTime;
    private double price;
}
