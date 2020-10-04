package flight_booking.backend.aspects;

import java.time.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeLoggerAspect {

    @Around("flight_booking.backend.aspects.AspectUtil.allMethodsFromAllControllers()")
    public Object measureExecTime(ProceedingJoinPoint pjp) throws Throwable {
        Instant before = Instant.now();
        try {
            Object result = pjp.proceed();
            return result;
        } finally {
            Instant after = Instant.now();
            Duration execTime = Duration.between(before, after);
            System.out.printf("%s execution took %d ms\n", pjp.toShortString(), execTime.toMillis());
        }
    }
}
