import java.util.Scanner;

public class TavasAndSaDDas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int len = s.length();
        
        int index = 0;
        
        for (int i = 1; i < len; i++) {
            index += Math.pow(2, i);
        }
        
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '7') {
                index += Math.pow(2, len - 1 - i);
            }
        }
        
        System.out.println(index + 1);
        
        scanner.close();
    }
}