package com.jobapprest.jobapprest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
//    @Before("execution(* com.jobapprest.jobapprest.service.JobService.*(..))")
//    public void logMethodCalled(){
//        logger.info("Logging aspect method called");
//    }

    @Before("execution(* com.jobapprest.jobapprest.service.JobService.getJobByid(..))")
    public void logMethodCalled(JoinPoint jp){
        logger.info("Logging aspect method called"+jp.getSignature().getName());
    }
}
