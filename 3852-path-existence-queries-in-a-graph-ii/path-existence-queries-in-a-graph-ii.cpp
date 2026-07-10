class Solution {
public:
    vector<int> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        vector<int> order(n);
        iota(order.begin(), order.end(), 0);

        sort(order.begin(), order.end(), [&](int a, int b) {
            if (nums[a] != nums[b]) return nums[a] < nums[b];
            return a < b;
        });

        vector<int> pos(n), val(n);
        for (int i = 0; i < n; i++) {
            pos[order[i]] = i;
            val[i] = nums[order[i]];
        }

        vector<int> far(n);
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r + 1 < n && val[r + 1] - val[i] <= maxDiff)
                r++;
            far[i] = r;
        }

        vector<int> comp(n);
        int cid = 0, end = -1;
        for (int i = 0; i < n; i++) {
            if (i > end) {
                cid++;
                end = far[i];
            } else {
                end = max(end, far[i]);
            }
            comp[i] = cid;
        }

        int LOG = 17;
        while ((1 << LOG) <= n) LOG++;

        vector<vector<int>> up(LOG, vector<int>(n));
        for (int i = 0; i < n; i++)
            up[0][i] = far[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        vector<int> ans;

        for (auto &q : queries) {
            int u = pos[q[0]];
            int v = pos[q[1]];

            if (u == v) {
                ans.push_back(0);
                continue;
            }

            if (comp[u] != comp[v]) {
                ans.push_back(-1);
                continue;
            }

            if (u > v) swap(u, v);

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    steps += (1 << k);
                }
            }

            ans.push_back(steps + 1);
        }

        return ans;
    }
};