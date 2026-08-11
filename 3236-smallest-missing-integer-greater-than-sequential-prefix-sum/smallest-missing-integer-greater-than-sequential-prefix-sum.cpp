class Solution {
public:
    int missingInteger(vector<int>& nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        
        unordered_set<int> set(nums.begin(), nums.end());
        while (set.count(sum)) {
            sum++;
        }
        return sum;
    }
};