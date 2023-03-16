package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples","bananas","milk","eggs"};
        List<String> list = List.of(items);
        System.out.println(list);

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles","mustard","cheese")
        );
        System.out.println(nextList);

        groceries.addAll(nextList);
        System.out.println(groceries);
        System.out.println("3rd item = " + groceries.get(2));

        if (groceries.contains("mustard")) {
            System.out.println("yes");
        }

        groceries.add("yogurt");
        System.out.println("1st = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));

        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");
        System.out.println(groceries);

        groceries.removeAll(List.of("apples","eggs"));
        System.out.println(groceries);

        groceries.retainAll(List.of("apples","milk","mustard","cheese"));
        System.out.println(groceries);

        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());

        groceries.addAll(List.of("apples","milk","mustard","cheese"));
        groceries.addAll(Arrays.asList("eggs","pickles","mustard","ham"));
        System.out.println(groceries);
    }
}