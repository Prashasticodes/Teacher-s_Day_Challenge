import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            
            if (map.containsKey(name)) {
                int count = map.get(name);
                String newName = name + count;
                while (map.containsKey(newName)) {
                    count++;
                    newName = name + count;
                }
                System.out.println(newName);
                map.put(name, count + 1);
                map.put(newName, 1);
            } else {
                System.out.println("OK");
                map.put(name, 1);
            }
        }
        
        scanner.close();
    }
}