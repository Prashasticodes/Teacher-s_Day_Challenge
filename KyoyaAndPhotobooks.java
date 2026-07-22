import java.util.Scanner;

public class KyoyaAndPhotobooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        int n = s.length();
        
        int result = 26 * (n + 1) - n;
        
        System.out.println(result);
        
        scanner.close();
    }
}