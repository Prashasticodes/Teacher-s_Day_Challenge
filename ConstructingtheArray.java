import java.util.Scanner;
import java.util.PriorityQueue;

public class ConstructingTheArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            
            PriorityQueue<Segment> pq = new PriorityQueue<>((s1, s2) -> {
                if (s1.length != s2.length) {
                    return s2.length - s1.length;
                }
                return s1.left - s2.left;
            });
            
            pq.add(new Segment(0, n - 1));
            
            for (int i = 1; i <= n; i++) {
                Segment seg = pq.poll();
                int mid = (seg.left + seg.right) / 2;
                a[mid] = i;
                
                if (seg.left <= mid - 1) {
                    pq.add(new Segment(seg.left, mid - 1));
                }
                if (mid + 1 <= seg.right) {
                    pq.add(new Segment(mid + 1, seg.right));
                }
            }
            
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
    
    static class Segment {
        int left, right, length;
        
        Segment(int left, int right) {
            this.left = left;
            this.right = right;
            this.length = right - left + 1;
        }
    }
}