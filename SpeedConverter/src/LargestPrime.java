public class LargestPrime {
    public static int getLargestPrime(int n) {
        if (n<2) {
            return -1;
        }
        for (int i = 2; i < n; i++) {
            if ((n % i) == 0) {
                n /= i;
                i--;
            }
        }
        return n;
    }
}
