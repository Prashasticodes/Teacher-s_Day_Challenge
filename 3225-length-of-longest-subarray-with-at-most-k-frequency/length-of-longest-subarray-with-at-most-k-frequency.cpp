class Solution {
public:
    int maxSubarrayLength(vector<int>& nums, int k) {
        int left = 0, maxLen = 0;
        unordered_map<int, int> freq;
        
        for (int right = 0; right < nums.size(); right++) {
            freq[nums[right]]++;
            
            while (freq[nums[right]] > k) {
                freq[nums[left]]--;
                left++;
            }
            
            maxLen = max(maxLen, right - left + 1);
        }
        return maxLen;
    }
};