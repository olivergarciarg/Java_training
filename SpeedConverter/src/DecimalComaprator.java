public class DecimalComaprator {
    public static boolean areEqualByThreeDecimalPlaces(double n1, double n2) {
        return (long)(n1 * 1000) == (long)(n2 * 1000);
    }
}
