class Solution {
public:
    int minimumPushes(string word) {
        vector<int> freq(26, 0);
        for (char c : word) {
            freq[c - 'a']++;
        }
        
        sort(freq.begin(), freq.end(), greater<int>());
        
        int pushes = 0;
        int pressCount = 1;
        int key = 8;
        
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) break;
            pushes += freq[i] * pressCount;
            if ((i + 1) % key == 0) {
                pressCount++;
            }
        }
        return pushes;
    }
};