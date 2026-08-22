class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        if (xor != 0) return nums.length;
        
        // If total XOR is 0, we need to remove at least 1 element
        // to make XOR non-zero. Find minimum elements to remove.
        int n = nums.length;
        int minRemove = n;
        
        // Try removing each element
        for (int i = 0; i < n; i++) {
            int newXor = xor ^ nums[i];
            if (newXor != 0) {
                minRemove = Math.min(minRemove, 1);
            }
        }
        
        return n - minRemove;
    }
}