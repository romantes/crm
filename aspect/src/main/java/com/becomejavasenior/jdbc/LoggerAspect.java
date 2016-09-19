package com.becomejavasenior.jdbc;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


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
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        log.trace("Method: " + methodName + "Method arguments: " + methodArgs.toString());
    }

    @AfterThrowing(value=POINTCUT, throwing="exception")
    private void logExeptionDaoCall(JoinPoint joinPoint, Exception exception) {
        String methodName = joinPoint.getSignature().getName();
        Object[] methodArgs = joinPoint.getArgs();
        errLog.error("Method: " + methodName + "Method arguments: " + methodArgs.toString());
    }

    private String parseMethodArgs(Object [] args) {
        String result = "";
        for (Object o : args) {
            result += o.toString();
                    result += " ";
        }
        return result;
    }

}
