package com.oliver;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("xxx", 8, 12);
//        theatre.getSeats();
        if (theatre.reserveSeat("H11")) {
            System.out.println("pay");
        } else {
            System.out.println("taken");
        }
        if (theatre.reserveSeat("H11")) {
            System.out.println("pay");
        } else {
            System.out.println("taken");
        }
    }
}