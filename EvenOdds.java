import java.util.Scanner;

public class EvenOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        
        long oddCount = (n + 1) / 2;
        
        if (k <= oddCount) {
            System.out.println(2 * k - 1);
        } else {
            long evenPos = k - oddCount;
            System.out.println(2 * evenPos);
        }
        
        scanner.close();
    }
}