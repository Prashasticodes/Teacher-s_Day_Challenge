import java.util.Scanner;

public class Domino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int sumUpper = 0;
        int sumLower = 0;
        boolean hasOddPair = false;
        
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            sumUpper += x;
            sumLower += y;
            if ((x % 2 == 1 && y % 2 == 0) || (x % 2 == 0 && y % 2 == 1)) {
                hasOddPair = true;
            }
        }
        
        if (sumUpper % 2 == 0 && sumLower % 2 == 0) {
            System.out.println(0);
        } else if (sumUpper % 2 == 1 && sumLower % 2 == 1 && hasOddPair) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
        
        scanner.close();
    }
}