import java.util.Scanner;

public class ThreePairwiseMaximums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            
            int max = Math.max(x, Math.max(y, z));
            int countMax = 0;
            if (x == max) countMax++;
            if (y == max) countMax++;
            if (z == max) countMax++;
            
            if (countMax < 2) {
                System.out.println("NO");
                continue;
            }
            
            int a, b, c;
            if (x == max && y == max) {
                a = max;
                b = max;
                c = z;
            } else if (x == max && z == max) {
                a = max;
                b = y;
                c = max;
            } else {
                a = x;
                b = max;
                c = max;
            }
            
            if (a > 0 && b > 0 && c > 0) {
                System.out.println("YES");
                System.out.println(a + " " + b + " " + c);
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}