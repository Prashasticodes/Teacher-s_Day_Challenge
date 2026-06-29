import java.util.Scanner;
import java.util.HashSet;

public class BoyOrGirl {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        HashSet<Character> distinct = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            distinct.add(s.charAt(i));
        }
        
        if (distinct.size() % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
        
        scanner.close();
    }
}