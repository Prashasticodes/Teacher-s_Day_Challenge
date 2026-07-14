import java.util.Scanner;

public class XeniaAndRingroad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int current = 1;
        long time = 0;
        
        for (int i = 0; i < m; i++) {
            int target = scanner.nextInt();
            if (target >= current) {
                time += target - current;
            } else {
                time += n - current + target;
            }
            current = target;
        }
        
        System.out.println(time);
        
        scanner.close();
    }
}