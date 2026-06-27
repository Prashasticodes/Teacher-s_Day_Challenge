import java.util.Scanner;

public class NearlyLuckyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String n = scanner.nextLine();
        int luckyCount = 0;
        
        for (int i = 0; i < n.length(); i++) {
            char c = n.charAt(i);
            if (c == '4' || c == '7') {
                luckyCount++;
            }
        }
        
        String countStr = Integer.toString(luckyCount);
        boolean isLucky = true;
        
        if (luckyCount == 0) {
            isLucky = false;
        } else {
            for (int i = 0; i < countStr.length(); i++) {
                char c = countStr.charAt(i);
                if (c != '4' && c != '7') {
                    isLucky = false;
                    break;
                }
            }
        }
        
        if (isLucky) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        scanner.close();
    }
}