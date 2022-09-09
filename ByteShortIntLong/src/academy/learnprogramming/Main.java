package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        int myValue = 10000;

        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;
        System.out.println(minIntValue + " " + maxIntValue);
        System.out.println(maxIntValue + 1);
        System.out.println(minIntValue - 1);

        Byte minByteValue = Byte.MIN_VALUE;
        Byte maxByteValue = Byte.MAX_VALUE;
        System.out.println(minByteValue + " " + maxByteValue);

        Short minShortValue = Short.MIN_VALUE;
        Short maxShortValue = Short.MAX_VALUE;
        System.out.println(minShortValue + " " + maxShortValue);

        Long minLongValue = Long.MIN_VALUE;
        Long maxLongValue = Long.MAX_VALUE;
        System.out.println(minLongValue + " " + maxLongValue);

        byte newByteValue = (byte) (minByteValue / 2);
    }
}
