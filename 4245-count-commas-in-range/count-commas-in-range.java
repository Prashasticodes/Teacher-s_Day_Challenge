class Solution {
    public int countCommas(int n) {
        int totalCommas = 0;
        long p = 1000;
        
        while (n >= p) {
            totalCommas += (n - p + 1);
            p *= 1000;
        }
        
        return totalCommas;
    }
}