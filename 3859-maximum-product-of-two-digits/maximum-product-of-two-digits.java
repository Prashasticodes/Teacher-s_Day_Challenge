class Solution {
    public int maxProduct(int n) {
        String s = Integer.toString(n);
        int max1 = 0, max2 = 0;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (digit > max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
        }
        return max1 * max2;
    }
}