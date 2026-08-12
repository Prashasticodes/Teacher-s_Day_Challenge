import java.util.Scanner;

public class LittleElephantsAndBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int n = s.length();
        
        int pos = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                pos = i;
                break;
            }
        }
        
        if (pos == -1) {
            System.out.println(s.substring(1));
        } else {
            System.out.println(s.substring(0, pos) + s.substring(pos + 1));
        }
        
        scanner.close();
    }
}