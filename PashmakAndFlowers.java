import java.util.Scanner;

public class PashmakAndFlowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long[] b = new long[n];
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
            if (b[i] < min) min = b[i];
            if (b[i] > max) max = b[i];
        }
        
        long diff = max - min;
        
        if (diff == 0) {
            long ways = (long) n * (n - 1) / 2;
            System.out.println(diff + " " + ways);
        } else {
            long countMin = 0, countMax = 0;
            for (int i = 0; i < n; i++) {
                if (b[i] == min) countMin++;
                if (b[i] == max) countMax++;
            }
            System.out.println(diff + " " + (countMin * countMax));
        }
        
        scanner.close();
    }
}