class Solution {
public:
    long long countCommas(long long n) {
        long long totalCommas = 0;
        long long p = 1000;
        
        while (n >= p) {
            totalCommas += (n - p + 1);
            p *= 1000;
        }
        
        return totalCommas;
    }
};