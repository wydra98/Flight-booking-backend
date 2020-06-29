package pl.edu.pk.siwz.backend.models;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Times {
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
}
