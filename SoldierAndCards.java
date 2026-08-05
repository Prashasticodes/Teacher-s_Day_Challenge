import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SoldierAndCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        
        int k1 = scanner.nextInt();
        Queue<Integer> p1 = new LinkedList<>();
        for (int i = 0; i < k1; i++) {
            p1.add(scanner.nextInt());
        }
        
        int k2 = scanner.nextInt();
        Queue<Integer> p2 = new LinkedList<>();
        for (int i = 0; i < k2; i++) {
            p2.add(scanner.nextInt());
        }
        
        int fights = 0;
        int limit = 10000;
        
        while (!p1.isEmpty() && !p2.isEmpty() && fights < limit) {
            int card1 = p1.poll();
            int card2 = p2.poll();
            
            if (card1 > card2) {
                p1.add(card2);
                p1.add(card1);
            } else {
                p2.add(card1);
                p2.add(card2);
            }
            fights++;
        }
        
        if (p1.isEmpty()) {
            System.out.println(fights + " 2");
        } else if (p2.isEmpty()) {
            System.out.println(fights + " 1");
        } else {
            System.out.println(-1);
        }
        
        scanner.close();
    }
}