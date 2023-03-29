package com.study.java.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// 빈 등록
@Component
//애스펙트는 부가기능을 정의한 코드인 어드바이스(Advice)와 어드바이스를 어디에 적용하지를 결정하는
//포인트컷(PointCut)을 합친 개념
@Aspect
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws  Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object ret = joinPoint.proceed();

        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());
        return ret;
    }

}
