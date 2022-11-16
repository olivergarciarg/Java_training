package com.oliver;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAcoount {
    private double balance;
    private String accountNumber;

    private Lock lock;

    public BankAcoount(String accountNumber, double balance) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.lock = new ReentrantLock();
    }

//    public synchronized void deposit(double amount) {
//        this.balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        this.balance -= amount;
//    }

    public void deposit(double amount) {
        boolean status = false;

//        synchronized (this) {
//            this.balance += amount;
//        }

//        lock.lock();
//        try {
//            this.balance += amount;
//        } finally {
//            lock.unlock();
//        }
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("could not get lock");
            }
        } catch (InterruptedException e) {

        }

        System.out.println("transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false;
//        synchronized (this) {
//            this.balance -= amount;
//        }

//        lock.lock();
//        try {
//            this.balance -= amount;
//        } finally {
//            lock.unlock();
//        }

        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    this.balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("could not get lock");
            }
        } catch (InterruptedException e) {

        }

        System.out.println("transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = " + accountNumber);
    }
}
