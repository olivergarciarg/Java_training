package com.oliver;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = divide();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println("error div");
        }
    }

    private static int divide() {
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println(x + " " + y);
            return x / y;
        } catch (NoSuchElementException e) {
            throw new ArithmeticException("bad input");
        } catch (ArithmeticException e) {
            throw new ArithmeticException("division by zero");
        }
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        System.out.println("enter integer");
        while (true) {
            try {
                return s.nextInt();
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("enter integer");
            }
        }
    }
}
