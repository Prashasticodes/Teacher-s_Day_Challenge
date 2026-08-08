class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] suffix = new int[n + 1];
        suffix[n] = m;
        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1.charAt(i) == word2.charAt(j)) {
                j--;
            }
            suffix[i] = j + 1;
        }
        
        int[] result = new int[m];
        int mismatch = 0;
        j = 0;
        
        for (int i = 0; i < n && j < m; i++) {
            if (word1.charAt(i) == word2.charAt(j)) {
                result[j] = i;
                j++;
            } else if (mismatch == 0 && suffix[i + 1] <= j + 1) {
                result[j] = i;
                j++;
                mismatch = 1;
            }
        }
        
        if (j < m) return new int[0];
        return result;
    }
}