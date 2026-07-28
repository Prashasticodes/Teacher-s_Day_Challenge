class Solution {
public:
    string smallestPalindrome(string s) {
        int n = s.size();
        vector<int> count(26, 0);
        for (char c : s) {
            count[c - 'a']++;
        }
        
        string result(n, ' ');
        int left = 0, right = n - 1;
        char middle = '\0';
        
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                middle = 'a' + i;
            }
            for (int j = 0; j < count[i] / 2; j++) {
                result[left++] = result[right--] = 'a' + i;
            }
        }
        
        if (middle != '\0') {
            result[left] = middle;
        }
        
        return result;
    }
};