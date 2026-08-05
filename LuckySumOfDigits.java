import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class LuckySumOfDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input == null || input.trim().isEmpty()) return;
        
        long n = Long.parseLong(input.trim());

        int count4 = -1;
        int count7 = -1;

        // Maximize '7's to minimize total digits
        for (int b = (int)(n / 7); b >= 0; --b) {
            long rem = n - 7L * b;
            if (rem % 4 == 0) {
                count4 = (int)(rem / 4);
                count7 = b;
                break;
            }
        }

        if (count4 == -1) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count4; i++) {
                sb.append('4');
            }
            for (int i = 0; i < count7; i++) {
                sb.append('7');
            }
            System.out.println(sb.toString());
        }
    }
}