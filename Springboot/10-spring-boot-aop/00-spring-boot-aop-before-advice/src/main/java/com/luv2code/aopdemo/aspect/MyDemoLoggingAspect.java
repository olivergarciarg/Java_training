package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterThrowing on the findAccounts method
    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        // log the exception
        System.out.println("\n=====>>> The exception is: " + theExc);
    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        // print out the results of the method call
        System.out.println("\n=====>>> result is: " + result);

        // let's post-process the data ... let's modify it :-)

        // convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account account : result) {
            // get uppercase version of name
            String upperName = account.getName().toUpperCase();
            // update the name on the account
            account.setName(upperName);
        }
    }

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
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (com.luv2code.aopdemo.Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
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
