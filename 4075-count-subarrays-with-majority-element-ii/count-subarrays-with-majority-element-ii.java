class Solution {
    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] pref = new int[n + 1];
        int cur = 0;
        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            cur += (nums[i] == target) ? 1 : -1;
            pref[i + 1] = cur;
            min = Math.min(min, cur);
            max = Math.max(max, cur);
        }

        int shift = 1 - min;
        Fenwick bit = new Fenwick(max - min + 5);

        long ans = 0;

        bit.update(pref[0] + shift, 1);

        for (int i = 1; i <= n; i++) {
            ans += bit.query(pref[i] + shift - 1);
            bit.update(pref[i] + shift, 1);
        }

        return ans;
    }
}