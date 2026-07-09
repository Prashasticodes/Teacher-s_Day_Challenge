class Solution {
private:
    vector<int> parent;
    vector<int> rank;
    
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    void unionSets(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) return;
        
        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;
        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;
        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
    
public:
    vector<bool> pathExistenceQueries(int n, vector<int>& nums, int maxDiff, vector<vector<int>>& queries) {
        // Union-Find data structure
        parent.resize(n);
        rank.resize(n, 0);
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // Since nums is sorted, we only need to connect adjacent nodes
        // because if |nums[i] - nums[j]| <= maxDiff for non-adjacent nodes,
        // then all intermediate nodes will also be within maxDiff and connected
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                unionSets(i, i + 1);
            }
        }
        
        // Process queries
        vector<bool> answer(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            answer[i] = (find(u) == find(v));
        }
        
        return answer;
    }
};