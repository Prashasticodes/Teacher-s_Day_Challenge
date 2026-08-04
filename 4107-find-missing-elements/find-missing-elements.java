class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}