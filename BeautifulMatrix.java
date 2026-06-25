import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int rowPos = 0, colPos = 0;
        
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    rowPos = i;
                    colPos = j;
                }
            }
        }
        
        int moves = Math.abs(rowPos - 3) + Math.abs(colPos - 3);
        System.out.println(moves);
        
        scanner.close();
    }
}