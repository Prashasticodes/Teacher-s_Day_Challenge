class Solution {
public:
    int countMajoritySubarrays(vector<int>& nums, int target) {
        int n = nums.size();
        int result = 0;
        
        // Precompute positions where target appears
        vector<int> targetPositions;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                targetPositions.push_back(i);
            }
        }
        
        int m = targetPositions.size();
        if (m == 0) return 0;
        
        // For each possible start position, check if target can be majority
        for (int start = 0; start < n; start++) {
            int targetCount = 0;
            int otherCount = 0;
            
            for (int end = start; end < n; end++) {
                if (nums[end] == target) {
                    targetCount++;
                } else {
                    otherCount++;
                }
                
                // target is majority if it appears more than half
                if (targetCount > otherCount) {
                    result++;
                }
            }
        }
        
        return result;
    }
};