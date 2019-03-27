package com.example.bootdemo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Viktar Lebedzeu
 */
@Aspect
@Component
public class LogMethodAspect {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(LogMethodAspect.class);


    @Around(value = "@annotation(com.example.bootdemo.annotation.LogMethod) && @annotation(logMethod)")
    public Object logMethodTime(ProceedingJoinPoint joinPoint, LogMethod logMethod) throws Throwable {
        long start = System.currentTimeMillis();

        /*
        Object[] args = joinPoint.getArgs();
        Object target = joinPoint.getTarget();
        Object pointThis = joinPoint.getThis();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        */
        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        logger.debug("{} [type = {}] executed in {}ms  ", joinPoint.getSignature(), logMethod.type(), executionTime);
        return proceed;
    }
}
