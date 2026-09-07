class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        int[] last = new int[26];
        long total = 0;
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newCount = (total + 1) % MOD;
            total = (total + newCount - last[idx] + MOD) % MOD;
            last[idx] = (int) newCount;
        }
        
        return (int) total;
    }
}