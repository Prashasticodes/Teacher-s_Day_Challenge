import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class HelpfulMaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i += 2) {
            numbers.add(s.charAt(i) - '0');
        }
        
        Collections.sort(numbers);
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            result.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                result.append("+");
            }
        }
        
        System.out.println(result);
        scanner.close();
    }
}