public class NumberToWords {
    public static int getDigitCount(int n) {
        if(n<0){
            return -1;
        }
        int count = 0;
        do {
            count ++;
            n /= 10;
        }while(n>0);
        return count;
    }
    public static int reverse(int n) {
        int multiplier = n<0?-1:1;
        n *= multiplier;
        int revN = 0;
        while (n>0) {
            revN = revN*10 + (n%10);
            n /= 10;
        }
        return multiplier*revN;
    }
    public static void numberToWords(int n){
        if(n<0){
            System.out.println("Invalid Value");
        }
        int revN = reverse(n);
        int nLength = getDigitCount(n);
        int revNLength = getDigitCount(revN);
        int printDigit;
        for (int i = 1; i<=nLength;i++) {
            if (i>revNLength) {
                printDigit =0;
            } else {
                printDigit=revN%10;
                revN /=10;
            }
            switch(printDigit){
                case 0:
                    System.out.println("ZERO");
                    break;
                case 1:
                    System.out.println("ONE");
                    break;
                case 2:
                    System.out.println("TWO");
                    break;
                case 3:
                    System.out.println("THREE");
                    break;
                case 4:
                    System.out.println("FOUR");
                    break;
                case 5:
                    System.out.println("FIVE");
                    break;
                case 6:
                    System.out.println("SIX");
                    break;
                case 7:
                    System.out.println("SEVEN");
                    break;
                case 8:
                    System.out.println("EIGHT");
                    break;
                case 9:
                    System.out.println("NINE");
                    break;
                default:
                    System.out.println("Invalid Value");
                    break;
            }
        }
    }
}
