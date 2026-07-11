class Solution {
public:
    int countCompleteComponents(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        
        vector<bool> visited(n, false);
        int complete = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                vector<int> component;
                dfs(i, graph, visited, component);
                
                int size = component.size();
                int edgeCount = 0;
                for (int node : component) {
                    edgeCount += graph[node].size();
                }
                edgeCount /= 2;
                
                if (edgeCount == size * (size - 1) / 2) {
                    complete++;
                }
            }
        }
        return complete;
    }
    
private:
    void dfs(int node, vector<vector<int>>& graph, vector<bool>& visited, vector<int>& component) {
        visited[node] = true;
        component.push_back(node);
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
};