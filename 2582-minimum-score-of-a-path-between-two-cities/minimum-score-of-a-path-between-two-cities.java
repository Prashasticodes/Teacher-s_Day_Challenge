class Solution {
    public int minScore(int n, int[][] roads) {
        // Build adjacency list using arrays
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0], v = road[1], dist = road[2];
            graph[u].add(new int[]{v, dist});
            graph[v].add(new int[]{u, dist});
        }
        
        // BFS to find all nodes reachable from city 1
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int city = queue.poll();
            
            for (int[] neighbor : graph[city]) {
                int nextCity = neighbor[0];
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                }
            }
        }
        
        // Find minimum edge weight among all edges that connect reachable nodes
        int minScore = Integer.MAX_VALUE;
        for (int[] road : roads) {
            int u = road[0], v = road[1], dist = road[2];
            if (visited[u] && visited[v]) {
                minScore = Math.min(minScore, dist);
            }
        }
        
        return minScore;
    }
}