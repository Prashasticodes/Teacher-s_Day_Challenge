class Solution {
public:
    struct Fenwick {
        vector<int> bit;

        Fenwick(int n) {
            bit.assign(n + 2, 0);
        }

        void update(int idx, int val) {
            while (idx < bit.size()) {
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
    };

    long long countMajoritySubarrays(vector<int>& nums, int target) {
        int n = nums.size();

        vector<int> pref(n + 1, 0);

        int cur = 0;
        int mn = 0, mx = 0;

        for (int i = 0; i < n; i++) {
            cur += (nums[i] == target) ? 1 : -1;
            pref[i + 1] = cur;
            mn = min(mn, cur);
            mx = max(mx, cur);
        }

        int shift = 1 - mn;
        Fenwick bit(mx - mn + 5);

        long long ans = 0;

        bit.update(pref[0] + shift, 1);

        for (int i = 1; i <= n; i++) {
            ans += bit.query(pref[i] + shift - 1);
            bit.update(pref[i] + shift, 1);
        }

        return ans;
    }
};