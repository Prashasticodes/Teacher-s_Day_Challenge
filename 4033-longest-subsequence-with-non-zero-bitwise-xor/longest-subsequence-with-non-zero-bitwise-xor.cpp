class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        if (xorSum != 0) return nums.size();
        
        int n = nums.size();
        int minRemove = n;
        
        for (int i = 0; i < n; i++) {
            int newXor = xorSum ^ nums[i];
            if (newXor != 0) {
                minRemove = min(minRemove, 1);
            }
        }
        
        return n - minRemove;
    }
};