import java.util.Arrays;
import java.util.Scanner;

public class BerSUBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] boys = new int[n];
        for (int i = 0; i < n; i++) {
            boys[i] = scanner.nextInt();
        }
        
        int m = scanner.nextInt();
        int[] girls = new int[m];
        for (int i = 0; i < m; i++) {
            girls[i] = scanner.nextInt();
        }
        
        Arrays.sort(boys);
        Arrays.sort(girls);
        
        int pairs = 0;
        int i = 0, j = 0;
        
        while (i < n && j < m) {
            if (Math.abs(boys[i] - girls[j]) <= 1) {
                pairs++;
                i++;
                j++;
            } else if (boys[i] < girls[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        System.out.println(pairs);
        
        scanner.close();
    }
}