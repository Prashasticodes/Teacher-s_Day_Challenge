import java.util.Scanner;

public class PetyaAndStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        
        String lower1 = s1.toLowerCase();
        String lower2 = s2.toLowerCase();
        
        int result = lower1.compareTo(lower2);
        
        if (result < 0) {
            System.out.println(-1);
        } else if (result > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
        
        scanner.close();
    }
}