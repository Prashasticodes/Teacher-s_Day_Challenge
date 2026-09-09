class Solution {
    public long countCommas(long n) {
        long totalCommas = 0;
        long p = 1000;
        
        while (n >= p) {
            totalCommas += (n - p + 1);
            p *= 1000;
        }
        
        return totalCommas;
    }
}