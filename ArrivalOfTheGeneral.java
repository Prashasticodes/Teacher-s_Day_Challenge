import java.util.Scanner;

public class ArrivalOfTheGeneral {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] a = new int[n];
        
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int maxIdx = 0;
        int minIdx = 0;
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] > maxVal) {
                maxVal = a[i];
                maxIdx = i;
            }
            if (a[i] <= minVal) {
                minVal = a[i];
                minIdx = i;
            }
        }
        
        int moves = maxIdx + (n - 1 - minIdx);
        if (maxIdx > minIdx) {
            moves--;
        }
        
        System.out.println(moves);
        
        scanner.close();
    }
}