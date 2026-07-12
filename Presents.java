import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] p = new int[n + 1];
        int[] result = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
            result[p[i]] = i;
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}