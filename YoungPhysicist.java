import java.util.Scanner;

public class YoungPhysicist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int sumX = 0, sumY = 0, sumZ = 0;
        
        for (int i = 0; i < n; i++) {
            sumX += scanner.nextInt();
            sumY += scanner.nextInt();
            sumZ += scanner.nextInt();
        }
        
        if (sumX == 0 && sumY == 0 && sumZ == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}