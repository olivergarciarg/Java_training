package academy.learnprogramming;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        System.out.println("enter count");
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] returnedArray = readIntegers(count);
        int returnedMin = findMin(returnedArray);
        System.out.println("min is " + returnedMin);
    }

    private static int[] readIntegers(int number) {
//        Scanner scanner = new Scanner(System.in);
        System.out.println("enter " + number + " value\r");
        int[] values = new int[number];
        for (int i=0; i<number; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    private static int findMin(int[] array) {
        int min;
        if (array.length > 0) {
            min = array[0];
        } else {
            min = -1;
        }
        for (int i=1; i<array.length;i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
}
