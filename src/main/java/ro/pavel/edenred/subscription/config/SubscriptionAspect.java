package ro.pavel.edenred.subscription.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SubscriptionAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());




    @Before("execution(* ro.pavel.edenred.subscription.service.*.*(..))")
    public void beforeUser(JoinPoint joinPoint) {
        logger.info("Method  {}  called with parameters {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @AfterReturning(pointcut = "execution(* ro.pavel.edenred.subscription.service.*.*(..))", returning = "retVal")
    public void afterUser(JoinPoint joinPoint, Object retVal) {
        logger.info("Method  {}  returned  {}", joinPoint.getSignature(), retVal);
    }
}
