class Solution {
public:
    int uniqueXorTriplets(vector<int>& nums) {
        int n = nums.size();
        if (n < 3) return n;
        
        int maxVal = 1;
        while (maxVal <= n) maxVal <<= 1;
        return maxVal;
    }
};