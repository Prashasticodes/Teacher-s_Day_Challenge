import java.util.Scanner;

public class XXXXX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int[] a = new int[n];
            
            int totalSum = 0;
            int firstNonDiv = -1;
            int lastNonDiv = -1;
            
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                totalSum += a[i];
                if (a[i] % x != 0) {
                    if (firstNonDiv == -1) {
                        firstNonDiv = i;
                    }
                    lastNonDiv = i;
                }
            }
            
            if (totalSum % x != 0) {
                System.out.println(n);
            } else if (firstNonDiv == -1) {
                System.out.println(-1);
            } else {
                int removeFromLeft = firstNonDiv + 1;
                int removeFromRight = n - lastNonDiv;
                int maxLen = n - Math.min(removeFromLeft, removeFromRight);
                System.out.println(maxLen);
            }
        }
        
        scanner.close();
    }
}