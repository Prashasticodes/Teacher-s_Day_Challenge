class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Union-Find data structure
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        // Find with path compression
        java.util.function.IntUnaryOperator find = new java.util.function.IntUnaryOperator() {
            @Override
            public int applyAsInt(int x) {
                if (parent[x] != x) {
                    parent[x] = applyAsInt(parent[x]);
                }
                return parent[x];
            }
        };
        
        // Union function
        java.util.function.BiConsumer<Integer, Integer> union = (a, b) -> {
            int rootA = find.applyAsInt(a);
            int rootB = find.applyAsInt(b);
            
            if (rootA == rootB) return;
            
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }
        };
        
        // Since nums is sorted, we only need to connect adjacent nodes
        // because if |nums[i] - nums[j]| <= maxDiff for non-adjacent nodes,
        // then all intermediate nodes will also be within maxDiff and connected
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                union.accept(i, i + 1);
            }
        }
        
        // Process queries
        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = find.applyAsInt(u) == find.applyAsInt(v);
        }
        
        return answer;
    }
}