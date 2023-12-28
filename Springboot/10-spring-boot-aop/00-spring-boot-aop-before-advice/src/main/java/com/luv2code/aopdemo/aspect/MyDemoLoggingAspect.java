package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    // this is where we add all of our related advices for logging
    // let's start with @Before advice
//    @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
//    public void beforeAddAccountAdvice() {
//        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
//    }

//    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//    private void forDaoPackage() {}
//
//    // create pointcut for getter methods
//    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
//    private void getter() {}
//
//    // create pointcut for setter methods
//    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
//    private void setter() {}
//
//    // create pointcut: include package ... exclude getter/setter
//    @Pointcut("forDaoPackage() && !(getter() || setter())")
//    private void forDaoPackageNoGetterSetter() {}

//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account))")
//    @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
//    @Before("execution(* add*(..))")
//    @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
//    @Before("forDaoPackage()")
    @Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");
    }

//    @Before("forDaoPackage()")
//    @Before("forDaoPackageNoGetterSetter()")
//    public void performApiAnalytics() {
//        System.out.println("\n=====>>> Performing API analytics");
//    }

//    @Before("forDaoPackageNoGetterSetter()")
//    public void logToCloudAsync() {
//        System.out.println("\n=====>>> Logging to Cloud in async fashion");
//    }
}
