import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Edge Case: If start or end contains a thief, safeness factor is 0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        
        // Step 1: Multi-Source BFS to compute minimum distance to any thief
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == Integer.MAX_VALUE) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        // Step 2: Modified Dijkstra using a Max-Heap
        // PriorityQueue sorts by safeness factor descending: (b[0] - a[0])
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{dist[0][0], 0, 0});
        
        int[][] maxSafenessTo = new int[n][n];
        for (int[] row : maxSafenessTo) {
            Arrays.fill(row, -1);
        }
        maxSafenessTo[0][0] = dist[0][0];
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currSafe = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if (r == n - 1 && c == n - 1) {
                return currSafe;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nextSafe = Math.min(currSafe, dist[nr][nc]);
                    
                    if (nextSafe > maxSafenessTo[nr][nc]) {
                        maxSafenessTo[nr][nc] = nextSafe;
                        pq.offer(new int[]{nextSafe, nr, nc});
                    }
                }
            }
        }
        
        return 0;
    }
}