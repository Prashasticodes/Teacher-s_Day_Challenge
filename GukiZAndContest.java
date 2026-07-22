import java.util.Scanner;

public class GukiZAndContest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] a = new int[n];
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            int position = 1;
            for (int j = 0; j < n; j++) {
                if (a[j] > a[i]) {
                    position++;
                }
            }
            System.out.print(position + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}