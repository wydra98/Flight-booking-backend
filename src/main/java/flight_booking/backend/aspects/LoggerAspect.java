package flight_booking.backend.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Before("flight_booking.backend.aspects.AspectUtil.allMethodsFromAllControllers()")
    public void logInfoBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.printf("Log before %s with args: %s\n", joinPoint.getSignature(), Arrays.toString(args));
    }

    @AfterThrowing(
            pointcut = "flight_booking.backend.aspects.AspectUtil.allMethodsFromAllControllers()",
            throwing = "error")
    public void logError(JoinPoint joinPoint, Throwable error) {
        System.out.printf("Method %s finished with error %s\n", joinPoint.getSignature(), error.getMessage());
    }

    @AfterReturning(
            pointcut = "flight_booking.backend.aspects.AspectUtil.allMethodsFromAllControllers()")
    public void logSuccess(JoinPoint joinPoint) {
        System.out.printf("Method %s successfully executed \n", joinPoint.getSignature());
    }
}
