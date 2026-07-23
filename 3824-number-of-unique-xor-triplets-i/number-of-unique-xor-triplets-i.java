class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n < 3) return n;
        
        int maxVal = 1;
        while (maxVal <= n) maxVal <<= 1;
        return maxVal;
    }
}