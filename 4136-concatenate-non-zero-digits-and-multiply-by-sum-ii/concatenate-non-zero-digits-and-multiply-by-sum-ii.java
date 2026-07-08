class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        
        // Prefix sums for sum of digits (non-zero only)
        long[] prefixSum = new long[n + 1];
        // Prefix value for concatenated non-zero digits
        long[] prefixVal = new long[n + 1];
        // Count of non-zero digits
        int[] prefixCount = new int[n + 1];
        // Powers of 10 modulo MOD for building numbers
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        // Build prefix arrays
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int digit = c - '0';
            
            prefixSum[i + 1] = prefixSum[i];
            prefixVal[i + 1] = prefixVal[i];
            prefixCount[i + 1] = prefixCount[i];
            
            if (digit != 0) {
                prefixSum[i + 1] = (prefixSum[i] + digit) % MOD;
                prefixVal[i + 1] = (prefixVal[i] * 10 + digit) % MOD;
                prefixCount[i + 1]++;
            }
        }
        
        int[] result = new int[queries.length];
        
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            
            // Count non-zero digits in range
            int count = prefixCount[r + 1] - prefixCount[l];
            
            if (count == 0) {
                result[qi] = 0;
                continue;
            }
            
            // Get the sum of non-zero digits in range
            long sum = (prefixSum[r + 1] - prefixSum[l] + MOD) % MOD;
            
            // Get the concatenated value in range
            // We need to extract the value formed by non-zero digits from l to r
            // This requires removing the contribution of digits before l and after r
            
            // Find the position of the first non-zero digit in the range
            // We'll extract the value by using prefixVal and adjusting
            long val = 0;
            
            // Method: we need the value formed by non-zero digits in the range
            // We can find the value at position r+1 and subtract the value at position l
            // But need to align place values
            
            // Let's find the value at position r+1 (all non-zero digits up to r)
            long valR = prefixVal[r + 1];
            // Find the value at position l (all non-zero digits up to l-1)
            long valL = prefixVal[l];
            
            // Need to know how many non-zero digits are in [l, r]
            int countUpToL = prefixCount[l];
            int countUpToR = prefixCount[r + 1];
            int countInRange = countUpToR - countUpToL;
            
            // Remove the contribution of digits before l
            // valR = valL * 10^(countInRange) + valRange
            // So valRange = valR - valL * 10^(countInRange)
            val = (valR - (valL * pow10[countInRange]) % MOD + MOD) % MOD;
            
            long ans = (val * sum) % MOD;
            result[qi] = (int) ans;
        }
        
        return result;
    }
}