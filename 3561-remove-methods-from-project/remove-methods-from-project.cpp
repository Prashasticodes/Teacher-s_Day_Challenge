class Solution {
public:
    vector<int> remainingMethods(int n, int k, vector<vector<int>>& invocations) {
        vector<vector<int>> graph(n), reverseGraph(n);
        for (auto& inv : invocations) {
            graph[inv[0]].push_back(inv[1]);
            reverseGraph[inv[1]].push_back(inv[0]);
        }
        
        vector<bool> suspicious(n, false);
        dfs(k, graph, suspicious);
        
        // Check if any non-suspicious method invokes suspicious method
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                for (int neighbor : graph[i]) {
                    if (suspicious[neighbor]) {
                        // Cannot remove suspicious methods
                        vector<int> result(n);
                        iota(result.begin(), result.end(), 0);
                        return result;
                    }
                }
            }
        }
        
        vector<int> result;
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) result.push_back(i);
        }
        return result;
    }
    
private:
    void dfs(int node, vector<vector<int>>& graph, vector<bool>& visited) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
};