class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        
        int[][] dp = new int[n][n];
        int[][] maxLeft = new int[n][n];
        int[][] maxRight = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            maxLeft[i][i] = 0;
            maxRight[i][i] = 0;
        }
        
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
                        best = Math.max(best, leftSum + dp[i][mid]);
                    } else if (leftSum > rightSum) {
                        best = Math.max(best, rightSum + dp[mid + 1][j]);
                    } else {
                        best = Math.max(best, leftSum + Math.max(dp[i][mid], dp[mid + 1][j]));
                    }
                }
                dp[i][j] = best;
            }
        }
        return dp[0][n - 1];
    }
}