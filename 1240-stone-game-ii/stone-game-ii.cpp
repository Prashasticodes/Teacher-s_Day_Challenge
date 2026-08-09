class Solution {
public:
    int stoneGameII(vector<int>& piles) {
        int n = piles.size();
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + piles[i];
        }
        
        vector<vector<int>> dp(n, vector<int>(n + 1, 0));
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = prefix[n] - prefix[i];
                } else {
                    int maxStones = 0;
                    for (int x = 1; x <= 2 * m; x++) {
                        int nextM = max(m, x);
                        maxStones = max(maxStones, (prefix[i + x] - prefix[i]) + 
                                       (prefix[n] - prefix[i + x] - dp[i + x][nextM]));
                    }
                    dp[i][m] = maxStones;
                }
            }
        }
        return dp[0][1];
    }
};