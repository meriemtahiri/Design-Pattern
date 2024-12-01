package com.tahiri.ASPECTS;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Scanner;

@Aspect
public class SecurityAspect {

    @Pointcut("execution(* com.tahiri.TEST.Application.start(..))")
    public void loginAspect(){};

    @Around("loginAspect()")
    public void autourStart(ProceedingJoinPoint proceedingJoinPoint, JoinPoint joinPoint) throws Throwable {
        Scanner scanner=new Scanner(System.in);
        System.out.println("username : ");
        String username = scanner.next();
        System.out.println("password : ");
        String password = scanner.next();
        if(username.equals("meriem") && password.equals("meriem")){
            proceedingJoinPoint.proceed();
        }else{
            System.out.println("Access Denied ...... ");
        }
    }
}
