import java.util.Scanner;

public class CheapTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        int cost1 = n * a;
        int cost2 = (n / m) * b + (n % m) * a;
        int cost3 = ((n + m - 1) / m) * b;
        
        int result = Math.min(cost1, Math.min(cost2, cost3));
        System.out.println(result);
        
        scanner.close();
    }
}