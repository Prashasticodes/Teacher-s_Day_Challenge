import java.util.Scanner;

public class XeniaAndDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] count = new int[8];
        
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            count[x]++;
        }
        
        if (count[5] > 0 || count[7] > 0) {
            System.out.println(-1);
            return;
        }
        
        int c1 = count[1], c2 = count[2], c3 = count[3], c4 = count[4], c6 = count[6];
        int n3 = n / 3;
        
        StringBuilder result = new StringBuilder();
        boolean possible = true;
        
        for (int g126 = 0; g126 <= Math.min(c1, Math.min(c2, c6)); g126++) {
            int remaining1 = c1 - g126;
            int remaining2 = c2 - g126;
            int remaining6 = c6 - g126;
            
            int g124 = Math.min(remaining1, Math.min(remaining2, c4));
            remaining1 -= g124;
            remaining2 -= g124;
            int remaining4 = c4 - g124;
            
            int g136 = Math.min(remaining1, Math.min(c3, remaining6));
            remaining1 -= g136;
            int remaining3 = c3 - g136;
            remaining6 -= g136;
            
            if (remaining1 == 0 && remaining2 == 0 && remaining3 == 0 && remaining4 == 0 && remaining6 == 0) {
                for (int i = 0; i < g124; i++) {
                    result.append("1 2 4\n");
                }
                for (int i = 0; i < g126; i++) {
                    result.append("1 2 6\n");
                }
                for (int i = 0; i < g136; i++) {
                    result.append("1 3 6\n");
                }
                System.out.print(result);
                return;
            }
        }
        
        System.out.println(-1);
        scanner.close();
    }
}