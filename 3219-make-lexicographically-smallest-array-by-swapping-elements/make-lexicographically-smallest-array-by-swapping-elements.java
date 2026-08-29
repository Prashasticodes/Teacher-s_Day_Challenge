class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums[i], i};
        }
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        
        int[] result = new int[n];
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && pairs[j + 1][0] - pairs[j][0] <= limit) {
                j++;
            }
            
            // Sort indices in this group
            int[] indices = new int[j - i + 1];
            int[] values = new int[j - i + 1];
            for (int k = i; k <= j; k++) {
                indices[k - i] = pairs[k][1];
                values[k - i] = pairs[k][0];
            }
            Arrays.sort(indices);
            
            for (int k = 0; k < indices.length; k++) {
                result[indices[k]] = values[k];
            }
            
            i = j + 1;
        }
        return result;
    }
}