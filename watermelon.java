import java.util.Scanner;

public class watermelon {
    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);
        
        // Read the weight of the watermelon
        int weight = scanner.nextInt();
        
        // Close the scanner to prevent resource leak
        scanner.close();
        
        // Check if the watermelon can be divided into two even parts
        // The weight must be even and greater than 2 because each part must have positive weight
        if (weight % 2 == 0 && weight > 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}