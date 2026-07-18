import java.util.Scanner;

public class ParkLighting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            
            int cells = n * m;
            int lanterns = (cells + 1) / 2;
            
            System.out.println(lanterns);
        }
        
        scanner.close();
    }
}