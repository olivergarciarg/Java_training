package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        for (int i=0; i<myIntegers.length; i++) {
            System.out.println(myIntegers[i]);
        }
        System.out.println("average: " + getAverage(myIntegers));
    }

    public static int[] getIntegers(int number) {
        System.out.println("enter " + number + " value\r");
        int[] values = new int[number];
        for (int i=0; i<number; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static  double getAverage(int[] array) {
        int sum = 0;
        for (int i=0; i< array.length;i++){
            sum += array[i];
        }
        return (double) sum/ (double) array.length;
    }
}
