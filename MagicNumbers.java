import java.util.Scanner;

public class MagicNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int i = 0;
        boolean magic = true;
        
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i) == '1' && s.charAt(i + 1) == '4' && s.charAt(i + 2) == '4') {
                i += 3;
            } else if (i + 1 < s.length() && s.charAt(i) == '1' && s.charAt(i + 1) == '4') {
                i += 2;
            } else if (s.charAt(i) == '1') {
                i += 1;
            } else {
                magic = false;
                break;
            }
        }
        
        System.out.println(magic ? "YES" : "NO");
        
        scanner.close();
    }
}