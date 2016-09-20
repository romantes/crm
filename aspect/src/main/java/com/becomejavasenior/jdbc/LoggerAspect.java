package com.becomejavasenior.jdbc;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;
import java.util.Date;


/**
 * Created by apple on 9/8/16.
 */
@Aspect
public class LoggerAspect {

    private final static Logger log = Logger.getLogger("dao_logger");
    private final static Logger errLog  = Logger.getLogger("dao_logger_err");
    private final static String POINTCUT = "execution(* com.becomejavasenior.jdbc.*.*.*(..))";

    @AfterReturning(value = POINTCUT)
    private void logDaoCall(JoinPoint joinPoint) {

        String methodArgs = parseJoinPoint(joinPoint);
        log.trace(new Date().toString() +
                getShortClassName(joinPoint) +
                "." + getShortMethodName(joinPoint) +
                " (" + methodArgs + ") " +
                " ..Was successful " );
    }

    @AfterThrowing(value=POINTCUT, throwing="exception")
    private void logExeptionDaoCall(JoinPoint joinPoint, Exception exception) {
        String methodArgs = parseJoinPoint(joinPoint);
        errLog.warn(new Date().toString() + " " +
                getShortClassName(joinPoint) +
                "." + getShortMethodName(joinPoint) +
                " (" + methodArgs + ") " +
                " ..Was unsuccessful " );
    }

    private String parseJoinPoint(JoinPoint joinPoint) {
        Object [] args = joinPoint.getArgs();
        return Arrays.stream(args).map((obj) -> obj.toString()).reduce((st1, st2) -> st1 + " " + st2).orElse("");
    }

    private String getShortClassName(JoinPoint joinPoint) {
        String className = joinPoint.getThis().toString();
        int idx = className.indexOf('@');
        String clazz = className.substring(0, idx);
        return clazz;
    }

    private String getShortMethodName(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }
}
