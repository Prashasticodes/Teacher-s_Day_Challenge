class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        List<Integer>[] reverseGraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }
        for (int[] inv : invocations) {
            graph[inv[0]].add(inv[1]);
            reverseGraph[inv[1]].add(inv[0]);
        }
        
        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);
        
        // Check if any non-suspicious method invokes suspicious method
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) {
                for (int neighbor : graph[i]) {
                    if (suspicious[neighbor]) {
                        // Cannot remove suspicious methods
                        List<Integer> result = new ArrayList<>();
                        for (int j = 0; j < n; j++) result.add(j);
                        return result;
                    }
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) result.add(i);
        }
        return result;
    }
    
    private void dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}