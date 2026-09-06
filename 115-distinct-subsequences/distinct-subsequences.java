class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        double[] dp = new double[n + 1];
        dp[0] = 1; // Base case: 1 way to form an empty string
        
        for (int i = 0; i < m; i++) {
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        
        return (int) dp[n];
    }
}