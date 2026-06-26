import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int solved = 0;
        
        for (int i = 0; i < n; i++) {
            int petya = scanner.nextInt();
            int vasya = scanner.nextInt();
            int tonya = scanner.nextInt();
            
            int sureCount = petya + vasya + tonya;
            
            if (sureCount >= 2) {
                solved++;
            }
        }
        
        System.out.println(solved);
        scanner.close();
    }
}