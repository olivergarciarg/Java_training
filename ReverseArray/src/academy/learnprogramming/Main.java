package academy.learnprogramming;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        reverse(array);
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length - 1;
        int halfLength = maxIndex / 2;
        int temp;
        for (int i=0; i<halfLength; i++) {
            temp = array[i];
            array[i] = array[maxIndex - i];
            array[maxIndex - i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
