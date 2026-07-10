class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;

        java.util.Arrays.sort(order, (a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
            return Integer.compare(a, b);
        });

        int[] pos = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            pos[order[i]] = i;
            val[i] = nums[order[i]];
        }

        int[] far = new int[n];
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r + 1 < n && val[r + 1] - val[i] <= maxDiff) r++;
            far[i] = r;
        }

        int[] comp = new int[n];
        int cid = 0;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (i > end) {
                cid++;
                end = far[i];
            } else {
                end = Math.max(end, far[i]);
            }
            comp[i] = cid;
        }

        int LOG = 17;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[LOG][n];
        for (int i = 0; i < n; i++) up[0][i] = far[i];
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {
            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            if (u > v) {
                int tmp = u;
                u = v;
                v = tmp;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    steps += 1 << k;
                }
            }

            ans[qi] = steps + 1;
        }

        return ans;
    }
}