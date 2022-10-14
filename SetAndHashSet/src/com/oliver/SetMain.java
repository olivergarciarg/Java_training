package com.oliver;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i=1; i<=100; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println(squares.size() + " " + cubes.size());
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println(union.size());

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println(intersection.size());
        for (int i: intersection) {
            System.out.println(i + " is square of " + Math.sqrt(i) + " and cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String s: words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee" };
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "is", "divine" };
        nature.addAll(Arrays.asList(natureWords));
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric diff");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if (nature.containsAll(divine)) {
            System.out.println("divine is a sub set of nature");
        }
        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersectionTest is a sub set of nature");
        }
        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersectionTest is a sub set of divine");
        }
    }

    private static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s: set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
