import java.util.Scanner;

public class GeorgeAndAccommodation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            
            if (q - p >= 2) {
                count++;
            }
        }
        
        System.out.println(count);
        scanner.close();
    }
}