import java.util.Scanner;

public class Drinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        
        double result = (double) sum / n;
        System.out.println(result);
        
        scanner.close();
    }
}