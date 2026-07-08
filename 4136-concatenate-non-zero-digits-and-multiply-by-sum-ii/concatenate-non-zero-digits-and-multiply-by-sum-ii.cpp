class Solution {
private:
    const int MOD = 1000000007;
    
public:
    vector<int> sumAndMultiply(string s, vector<vector<int>>& queries) {
        int n = s.length();
        
        // Prefix sums for sum of digits (non-zero only)
        vector<long long> prefixSum(n + 1, 0);
        // Prefix value for concatenated non-zero digits
        vector<long long> prefixVal(n + 1, 0);
        // Count of non-zero digits
        vector<int> prefixCount(n + 1, 0);
        // Powers of 10 modulo MOD for building numbers
        vector<long long> pow10(n + 1, 1);
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }
        
        // Build prefix arrays
        for (int i = 0; i < n; i++) {
            char c = s[i];
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
        
        vector<int> result(queries.size());
        
        for (int qi = 0; qi < queries.size(); qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            
            // Count non-zero digits in range
            int countUpToL = prefixCount[l];
            int countUpToR = prefixCount[r + 1];
            int countInRange = countUpToR - countUpToL;
            
            if (countInRange == 0) {
                result[qi] = 0;
                continue;
            }
            
            // Get the sum of non-zero digits in range
            long long sum = (prefixSum[r + 1] - prefixSum[l] + MOD) % MOD;
            
            // Get the concatenated value in range
            // prefixVal[r+1] = value of non-zero digits from 0 to r
            // prefixVal[l] = value of non-zero digits from 0 to l-1
            // To get value in [l, r], we need to remove the contribution of digits before l
            // The digits before l are shifted left by countInRange positions
            long long valL = prefixVal[l];
            long long valR = prefixVal[r + 1];
            
            // Remove the prefix contribution and get the range value
            // valR = valL * 10^countInRange + valRange
            // So: valRange = valR - valL * 10^countInRange
            long long prefixContribution = (valL * pow10[countInRange]) % MOD;
            long long val = (valR - prefixContribution + MOD) % MOD;
            
            long long ans = (val * sum) % MOD;
            result[qi] = (int) ans;
        }
        
        return result;
    }
};