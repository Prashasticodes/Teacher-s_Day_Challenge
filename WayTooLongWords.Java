import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        // Create a scanner to read input
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of words
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after the integer
        
        // Process each word
        for (int i = 0; i < n; i++) {
            // Read the current word
            String word = scanner.nextLine();
            
            // Check if the word is too long (length > 10)
            if (word.length() > 10) {
                // Create abbreviation: first letter + (length - 2) + last letter
                int middleCount = word.length() - 2;
                String abbreviated = word.charAt(0) + Integer.toString(middleCount) + word.charAt(word.length() - 1);
                System.out.println(abbreviated);
            } else {
                // Word is short enough, print it as is
                System.out.println(word);
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}