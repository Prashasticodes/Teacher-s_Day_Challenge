class Solution {
public:
    int stoneGameV(vector<int>& stoneValue) {
        int n = stoneValue.size();
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int best = 0;
                int leftSum = 0;
                int rightSum = prefix[j + 1] - prefix[i];
                
                for (int mid = i; mid < j; mid++) {
                    leftSum += stoneValue[mid];
                    rightSum -= stoneValue[mid];
                    
                    if (leftSum < rightSum) {
                        best = max(best, leftSum + dp[i][mid]);
                    } else if (leftSum > rightSum) {
                        best = max(best, rightSum + dp[mid + 1][j]);
                    } else {
                        best = max(best, leftSum + max(dp[i][mid], dp[mid + 1][j]));
                    }
                }
                dp[i][j] = best;
            }
        }
        return dp[0][n - 1];
    }
};