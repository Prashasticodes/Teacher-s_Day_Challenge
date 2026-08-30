class Solution {
public:
    int minimumDeletions(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return 1;
        
        int minIdx = 0, maxIdx = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }
        
        int left = min(minIdx, maxIdx);
        int right = max(minIdx, maxIdx);
        
        int option1 = right + 1;        // Remove from left only
        int option2 = n - left;          // Remove from right only
        int option3 = (left + 1) + (n - right); // Remove from both ends
        
        return min({option1, option2, option3});
    }
};