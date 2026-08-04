class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        int minVal = INT_MAX, maxVal = INT_MIN;
        unordered_set<int> set;
        for (int num : nums) {
            minVal = min(minVal, num);
            maxVal = max(maxVal, num);
            set.insert(num);
        }
        vector<int> result;
        for (int i = minVal + 1; i < maxVal; i++) {
            if (!set.count(i)) {
                result.push_back(i);
            }
        }
        return result;
    }
};