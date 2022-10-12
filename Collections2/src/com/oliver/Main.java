package com.oliver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre("xxx", 8, 12);
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);
//        theatre.getSeats();
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("pay");
//        } else {
//            System.out.println("taken");
//        }
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("pay");
//        } else {
//            System.out.println("taken");
//        }

        seatCopy.get(1).reserve();
        if (theatre.reserveSeat("A02")) {
            System.out.println("pay");
        } else {
            System.out.println("taken");
        }

        Collections.shuffle(seatCopy);
        printList(seatCopy);
        printList(theatre.seats);

        sortList(seatCopy);
        System.out.println("sorted seatCopy");
        printList(seatCopy);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("========================================================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for (int i=0; i < list.size() - 1; i++) {
            for (int j=i+1; j<list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}