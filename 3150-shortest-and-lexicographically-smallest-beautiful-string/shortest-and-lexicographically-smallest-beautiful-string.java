class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') ones++;
                if (ones == k) {
                    int len = j - i + 1;
                    String sub = s.substring(i, j + 1);
                    if (len < minLen || (len == minLen && (ans.isEmpty() || sub.compareTo(ans) < 0))) {
                        minLen = len;
                        ans = sub;
                    }
                    break;
                }
                if (ones > k) break;
            }
        }
        return ans;
    }
}