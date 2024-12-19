package com.tahiri.ASPECTS;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class CacheAspect {
    @Around("@annotation(com.tahiri.ASPECTS.Log)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        
        return result;
    }
}
