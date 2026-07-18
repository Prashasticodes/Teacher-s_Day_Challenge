import java.util.Scanner;

public class SoftDrinking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int l = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int p = scanner.nextInt();
        int nl = scanner.nextInt();
        int np = scanner.nextInt();
        
        int totalDrink = k * l;
        int totalLime = c * d;
        
        int toastsByDrink = totalDrink / nl;
        int toastsByLime = totalLime;
        int toastsBySalt = p / np;
        
        int totalToasts = Math.min(toastsByDrink, Math.min(toastsByLime, toastsBySalt));
        int perFriend = totalToasts / n;
        
        System.out.println(perFriend);
        
        scanner.close();
    }
}