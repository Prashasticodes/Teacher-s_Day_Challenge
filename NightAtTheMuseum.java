import java.util.Scanner;

public class NightAtTheMuseum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        char current = 'a';
        int totalRotations = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            int diff = Math.abs(target - current);
            int rotations = Math.min(diff, 26 - diff);
            totalRotations += rotations;
            current = target;
        }
        
        System.out.println(totalRotations);
        
        scanner.close();
    }
}