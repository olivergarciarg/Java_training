package com.oliver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        locations.put(0, new Location(0, "front of PC"));
        locations.put(1, new Location(1, "end of road in front of bridge"));
        locations.put(2, new Location(2, "top of a hill"));
        locations.put(3, new Location(3, "well house in small spring"));
        locations.put(4, new Location(4, "valley beside stream"));
        locations.put(5, new Location(5, "forest"));

        locations.get(1).addExit("W",2);
        locations.get(1).addExit("E",3);
        locations.get(1).addExit("S",4);
        locations.get(1).addExit("N",5);
        locations.get(1).addExit("Q",0);


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            loc = scanner.nextInt();
            if (!locations.containsKey(loc)) {
                System.out.println("cant go in that direction");
            }
        }
    }
}