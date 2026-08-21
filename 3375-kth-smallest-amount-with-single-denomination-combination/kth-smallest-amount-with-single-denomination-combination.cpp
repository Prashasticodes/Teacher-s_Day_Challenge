class Solution {
public:
    long long findKthSmallest(vector<int>& coins, int k) {
        long long low = 1, high = 1e18;
        while (low < high) {
            long long mid = low + (high - low) / 2;
            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
private:
    long long count(long long x, vector<int>& coins) {
        int n = coins.size();
        long long total = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long long lcm = 1;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if (mask & (1 << i)) {
                    lcm = lcm_val(lcm, coins[i]);
                    bits++;
                    if (lcm > x) break;
                }
            }
            if (lcm <= x) {
                if (bits % 2 == 1) total += x / lcm;
                else total -= x / lcm;
            }
        }
        return total;
    }
    
    long long gcd_val(long long a, long long b) {
        while (b != 0) {
            long long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    long long lcm_val(long long a, long long b) {
        return a / gcd_val(a, b) * b;
    }
};