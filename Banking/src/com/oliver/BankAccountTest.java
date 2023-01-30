package com.oliver;

//import static org.junit.Assert.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("before any test method, count = " + count++);
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Tim", "B", 1000.00, BankAccount.CHECKING);
        System.out.println("running a test...");
    }

    @org.junit.Test
    public void deposit() {
//        BankAccount account = new BankAccount("Tim", "B", 1000.00, BankAccount.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
//        BankAccount account = new BankAccount("Tim", "B", 1000.00, BankAccount.CHECKING);
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        double balance = account.withdraw(600.00, false);
        fail("should have thrown IllegalArgumentException");
    }

//    @org.junit.Test // (expected = IllegalArgumentException.class)
//    public void withdraw_notBranch() throws Exception {
//        try {
//            double balance = account.withdraw(600.00, false);
//            fail("should have thrown IllegalArgumentException");
//        } catch (IllegalArgumentException e) {}
//    }

    @org.junit.Test
    public void getBalance_deposit() {
//        BankAccount account = new BankAccount("Tim", "B", 1000.00, BankAccount.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
//        BankAccount account = new BankAccount("Tim", "B", 1000.00, BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
//        BankAccount account = new BankAccount("Tim", "B", 1000.00, BankAccount.CHECKING);
        assertTrue("is not a checking account", account.isChecking());
    }

    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("after all test method, count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("count = " + count++);
    }

}