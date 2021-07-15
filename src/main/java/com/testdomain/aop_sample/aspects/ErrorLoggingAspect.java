package com.testdomain.aop_sample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorLoggingAspect {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.testdomain.aop_sample.controllers.*.*(..))", throwing = "ex")
    public void afterThrowingError(JoinPoint joinPoint, Throwable ex) throws Throwable {
        //Get intercepted method details
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        log.info("Error thrown in " + className + "." + methodName);
        log.info("Exception: " + ex);
    }
}
