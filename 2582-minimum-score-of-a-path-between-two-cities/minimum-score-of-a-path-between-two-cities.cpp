class Solution {
public:
    int minScore(int n, vector<vector<int>>& roads) {
        // Build adjacency list
        vector<vector<pair<int, int>>> graph(n + 1);
        for (auto& road : roads) {
            int u = road[0], v = road[1], dist = road[2];
            graph[u].push_back({v, dist});
            graph[v].push_back({u, dist});
        }
        
        // BFS/DFS to find all nodes reachable from city 1
        vector<bool> visited(n + 1, false);
        queue<int> q;
        q.push(1);
        visited[1] = true;
        
        while (!q.empty()) {
            int city = q.front();
            q.pop();
            
            for (auto& neighbor : graph[city]) {
                int nextCity = neighbor.first;
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    q.push(nextCity);
                }
            }
        }
        
        // Find minimum edge weight among all edges that connect reachable nodes
        int minScore = INT_MAX;
        for (auto& road : roads) {
            int u = road[0], v = road[1], dist = road[2];
            // If both cities are reachable from city 1, this edge can be part of a path
            if (visited[u] && visited[v]) {
                minScore = min(minScore, dist);
            }
        }
        
        return minScore;
    }
};