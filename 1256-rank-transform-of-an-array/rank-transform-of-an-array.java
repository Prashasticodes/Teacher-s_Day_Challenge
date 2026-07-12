class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = rank.get(arr[i]);
        }
        return result;
    }
}