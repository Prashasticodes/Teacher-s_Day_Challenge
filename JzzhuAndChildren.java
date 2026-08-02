import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JzzhuAndChildren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[] a = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            queue.add(i);
        }
        
        int lastChild = 0;
        
        while (!queue.isEmpty()) {
            int child = queue.poll();
            a[child] -= m;
            
            if (a[child] > 0) {
                queue.add(child);
            }
            
            lastChild = child;
        }
        
        System.out.println(lastChild + 1);
        
        scanner.close();
    }
}