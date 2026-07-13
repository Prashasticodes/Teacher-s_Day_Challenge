import java.util.Scanner;

public class QueueAtSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        String s = scanner.next();
        
        char[] queue = s.toCharArray();
        
        for (int time = 0; time < t; time++) {
            for (int i = 0; i < n - 1; i++) {
                if (queue[i] == 'B' && queue[i + 1] == 'G') {
                    queue[i] = 'G';
                    queue[i + 1] = 'B';
                    i++;
                }
            }
        }
        
        System.out.println(new String(queue));
        
        scanner.close();
    }
}