package flight_booking.backend.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectUtil {

    @Pointcut("execution(* flight_booking.backend.controllers.airline.AirlineController.*(..))"
    + " || execution(* flight_booking.backend.controllers.airport.AirportController.*(..))"
    + " || execution(* flight_booking.backend.controllers.authorization.AuthorizationController.*(..))"
    + " || execution(* flight_booking.backend.controllers.flight.FlightController.*(..))"
    + " || execution(* flight_booking.backend.controllers.passenger.PassengerController.*(..))"
    + " || execution(* flight_booking.backend.controllers.trip.TripController.*(..))"
    + " || execution(* flight_booking.backend.controllers.user.UserController.*(..))")
    public void allMethodsFromAllControllers() { }
}
