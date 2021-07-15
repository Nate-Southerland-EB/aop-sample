package com.testdomain.aop_sample.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {
    private Logger logger = LoggerFactory.getLogger(SecurityAspect.class);

    @Around("execution(* com.testdomain.aop_sample.controllers.*.*(..))")
    public Object whenMethodCalled(ProceedingJoinPoint joinPoint) throws Throwable {
        //Get intercepted method details
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        logger.info("Check authorization here before executing " + className + "." + methodName + ".");
        Object result = joinPoint.proceed();
        logger.info("Post execution is too late.");

        return result;
    }
}
