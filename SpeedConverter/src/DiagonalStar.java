public class DiagonalStar {
    public static void printSquareStar(int n) {
        if(n<5){
            System.out.println("Invalid Value");
        } else {
            for (int row=1; row<=n; row++) {
                for (int col=1; col<=n; col++) {
                    if (row == 1 || row == n || col == 1 || col == n || row == col || n - row +1 == col) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
