class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + piles[i];
        }
        
        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = prefix[n] - prefix[i];
                } else {
                    int maxStones = 0;
                    for (int x = 1; x <= 2 * m; x++) {
                        int nextM = Math.max(m, x);
                        maxStones = Math.max(maxStones, (prefix[i + x] - prefix[i]) + 
                                             (prefix[n] - prefix[i + x] - dp[i + x][nextM]));
                    }
                    dp[i][m] = maxStones;
                }
            }
        }
        return dp[0][1];
    }
}