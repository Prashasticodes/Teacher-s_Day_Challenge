class Solution {
public:
    int largestInteger(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> count(51, 0);
        
        for (int i = 0; i <= n - k; i++) {
            vector<bool> seen(51, false);
            for (int j = i; j < i + k; j++) {
                if (!seen[nums[j]]) {
                    seen[nums[j]] = true;
                    count[nums[j]]++;
                }
            }
        }
        
        int result = -1;
        for (int i = 0; i <= 50; i++) {
            if (count[i] == 1) {
                result = i;
            }
        }
        return result;
    }
};