import java.util.Scanner;
import java.util.HashSet;

public class IWannaBeTheGuy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        HashSet<Integer> levels = new HashSet<>();
        
        int p = scanner.nextInt();
        for (int i = 0; i < p; i++) {
            levels.add(scanner.nextInt());
        }
        
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            levels.add(scanner.nextInt());
        }
        
        if (levels.size() == n) {
            System.out.println("I become the guy.");
        } else {
            System.out.println("Oh, my keyboard!");
        }
        
        scanner.close();
    }
}