import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int count = 1;
        boolean dangerous = false;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                if (count >= 7) {
                    dangerous = true;
                    break;
                }
            } else {
                count = 1;
            }
        }
        
        System.out.println(dangerous ? "YES" : "NO");
        
        scanner.close();
    }
}