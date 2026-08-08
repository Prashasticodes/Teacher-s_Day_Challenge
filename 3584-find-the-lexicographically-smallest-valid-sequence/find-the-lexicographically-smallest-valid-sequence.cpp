class Solution {
public:
    vector<int> validSequence(string word1, string word2) {
        int n = word1.size(), m = word2.size();
        vector<int> suffix(n + 1);
        suffix[n] = m;
        int j = m - 1;
        for (int i = n - 1; i >= 0 && j >= 0; i--) {
            if (word1[i] == word2[j]) {
                j--;
            }
            suffix[i] = j + 1;
        }
        
        vector<int> result;
        int mismatch = 0;
        j = 0;
        
        for (int i = 0; i < n && j < m; i++) {
            if (word1[i] == word2[j]) {
                result.push_back(i);
                j++;
            } else if (mismatch == 0 && suffix[i + 1] <= j + 1) {
                result.push_back(i);
                j++;
                mismatch = 1;
            }
        }
        
        if (j < m) return {};
        return result;
    }
};