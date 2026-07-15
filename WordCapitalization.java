import java.util.Scanner;

public class WordCapitalization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        
        String result = s.substring(0, 1).toUpperCase() + s.substring(1);
        
        System.out.println(result);
        
        scanner.close();
    }
}