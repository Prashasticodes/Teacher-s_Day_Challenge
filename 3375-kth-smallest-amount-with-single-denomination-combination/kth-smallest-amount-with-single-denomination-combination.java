class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long low = 1, high = (long) 1e18;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private long count(long x, int[] coins) {
        int n = coins.length;
        long total = 0;
        // Inclusion-exclusion over all subsets
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
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
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}