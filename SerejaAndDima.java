import java.util.Scanner;

public class SerejaAndDima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }
        
        int left = 0, right = n - 1;
        int sereja = 0, dima = 0;
        boolean serejaTurn = true;
        
        while (left <= right) {
            int taken;
            if (cards[left] > cards[right]) {
                taken = cards[left];
                left++;
            } else {
                taken = cards[right];
                right--;
            }
            
            if (serejaTurn) {
                sereja += taken;
            } else {
                dima += taken;
            }
            serejaTurn = !serejaTurn;
        }
        
        System.out.println(sereja + " " + dima);
        
        scanner.close();
    }
}