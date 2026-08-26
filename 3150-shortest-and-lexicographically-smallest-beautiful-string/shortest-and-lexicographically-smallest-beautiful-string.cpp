class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.size();
        int minLen = INT_MAX;
        string ans = "";
        
        for (int i = 0; i < n; i++) {
            int ones = 0;
            for (int j = i; j < n; j++) {
                if (s[j] == '1') ones++;
                if (ones == k) {
                    int len = j - i + 1;
                    string sub = s.substr(i, len);
                    if (len < minLen || (len == minLen && (ans.empty() || sub < ans))) {
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
};