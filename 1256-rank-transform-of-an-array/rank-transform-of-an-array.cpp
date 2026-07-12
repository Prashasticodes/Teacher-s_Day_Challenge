class Solution {
public:
    vector<int> arrayRankTransform(vector<int>& arr) {
        int n = arr.size();
        vector<int> sorted = arr;
        sort(sorted.begin(), sorted.end());
        unordered_map<int, int> rank;
        int r = 1;
        for (int num : sorted) {
            if (!rank.count(num)) {
                rank[num] = r++;
            }
        }
        vector<int> result(n);
        for (int i = 0; i < n; i++) {
            result[i] = rank[arr[i]];
        }
        return result;
    }
};