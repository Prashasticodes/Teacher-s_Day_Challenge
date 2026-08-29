class Solution {
public:
    vector<int> lexicographicallySmallestArray(vector<int>& nums, int limit) {
        int n = nums.size();
        vector<pair<int, int>> pairs(n);
        for (int i = 0; i < n; i++) {
            pairs[i] = {nums[i], i};
        }
        sort(pairs.begin(), pairs.end());
        
        vector<int> result(n);
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && pairs[j + 1].first - pairs[j].first <= limit) {
                j++;
            }
            
            vector<int> indices, values;
            for (int k = i; k <= j; k++) {
                indices.push_back(pairs[k].second);
                values.push_back(pairs[k].first);
            }
            sort(indices.begin(), indices.end());
            
            for (int k = 0; k < indices.size(); k++) {
                result[indices[k]] = values[k];
            }
            
            i = j + 1;
        }
        return result;
    }
};