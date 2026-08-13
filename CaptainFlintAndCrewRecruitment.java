import java.util.Scanner;

public class CaptainFlintAndCrewRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            int n = scanner.nextInt();
            
            int[] nearlyPrimes = {6, 10, 14, 15, 21, 22, 26, 33, 34, 35, 38, 39, 46, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95};
            
            boolean found = false;
            
            for (int i = 0; i < nearlyPrimes.length && !found; i++) {
                for (int j = i + 1; j < nearlyPrimes.length && !found; j++) {
                    for (int k = j + 1; k < nearlyPrimes.length && !found; k++) {
                        int sum = nearlyPrimes[i] + nearlyPrimes[j] + nearlyPrimes[k];
                        int fourth = n - sum;
                        if (fourth > 0 && fourth != nearlyPrimes[i] && fourth != nearlyPrimes[j] && fourth != nearlyPrimes[k]) {
                            System.out.println("YES");
                            System.out.println(nearlyPrimes[i] + " " + nearlyPrimes[j] + " " + nearlyPrimes[k] + " " + fourth);
                            found = true;
                            break;
                        }
                    }
                }
            }
            
            if (!found) {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }
}