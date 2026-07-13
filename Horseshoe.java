import java.util.Scanner;
import java.util.HashSet;

public class Horseshoe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        HashSet<Integer> colors = new HashSet<>();
        
        for (int i = 0; i < 4; i++) {
            colors.add(scanner.nextInt());
        }
        
        System.out.println(4 - colors.size());
        
        scanner.close();
    }
}