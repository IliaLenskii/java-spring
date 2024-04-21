package org.example.proxies;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.model.Comment;
import org.example.services.CommentService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@Order(2) // order of execution
public class LoggingAspect {

    private Logger logger = Logger.getLogger(CommentService.class.getName());

    // intercept any types from *services* and methods
    @Around("execution(* org.example.services.CommentService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        logger.info("Method will execute");

        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();

        Object[] commIntercepted = {new Comment("Godzilla", "arrrrrrr")};

        Number returned = (Number) joinPoint.proceed( commIntercepted );

        logger.info("Method executed: "+ returned);

        return returned;
    }

    // @Before - before exec
    // @After - after exec
    // @AfterReturning - successful completion of the method
    // @AfterThrowing - after throw exception

    @Around("@annotation(IToLog)")
    public Object log2(ProceedingJoinPoint jp) throws Throwable {

        logger.info("__log2");

        return jp.proceed();
    }
}
