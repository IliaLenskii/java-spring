package org.example.proxies;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.example.services.CommentService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(1) // order of execution
public class SecurityAspect {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    // @Before - before exec
    // @After - after exec
    // @AfterReturning - successful completion of the method
    // @AfterThrowing - after throw exception

    @Around("@annotation(IToLog)")
    public Object secure(ProceedingJoinPoint jp) throws Throwable {

        logger.info("Security Aspect: executed and returned");

        return jp.proceed();
    }
}
