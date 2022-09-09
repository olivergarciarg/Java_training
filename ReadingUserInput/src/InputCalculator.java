import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        int sum = 0;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("input number");
        while(scanner.hasNextInt()){
            sum += scanner.nextInt();
            count++;
        }
        System.out.println("SUM = " + sum + " AVG = " + Math.round(sum/count));
    }
}
