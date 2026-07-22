import java.util.Scanner;

public class ValeraAndPlates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        
        int bowls = m;
        int plates = k;
        int washes = 0;
        
        for (int i = 0; i < n; i++) {
            int type = scanner.nextInt();
            
            if (type == 1) {
                if (bowls > 0) {
                    bowls--;
                } else {
                    washes++;
                }
            } else {
                if (plates > 0) {
                    plates--;
                } else if (bowls > 0) {
                    bowls--;
                } else {
                    washes++;
                }
            }
        }
        
        System.out.println(washes);
        
        scanner.close();
    }
}