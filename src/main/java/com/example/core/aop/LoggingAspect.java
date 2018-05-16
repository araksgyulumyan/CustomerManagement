package com.example.core.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by araksgyulumyan
 * Date - 5/16/18
 * Time - 4:37 PM
 */

@Aspect
@Configuration
public class LoggingAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.core.repository.*.*(..))")
    public void before(JoinPoint joinPoint) {
        //Advice
        LOGGER.debug(" Check for user access ");
        LOGGER.info(" Allowed execution for {}", joinPoint);
    }

}
