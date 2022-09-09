public class NumberPalindrome {
    public static boolean isPalindrome(int n){
        int originalN = n;
        int palN = 0;
        int rem;
        while (n>0) {
            rem = n%10;
            palN = ((palN*10) + (rem));
            n = n/10;
        }
        return originalN == palN || originalN == -palN;
    }
}
