import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        
        int[][] minCost = new int[m][n];
        for (int[] row : minCost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        minCost[0][0] = grid.get(0).get(0);
        
        // Min-heap ordered by total cost/health lost ascending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{minCost[0][0], 0, 0}); // {cost, r, c}
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currCost = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if (r == m - 1 && c == n - 1) {
                return currCost < health;
            }
            
            if (currCost > minCost[r][c]) {
                continue;
            }
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextCost = currCost + grid.get(nr).get(nc);
                    
                    if (nextCost < minCost[nr][nc]) {
                        minCost[nr][nc] = nextCost;
                        pq.offer(new int[]{nextCost, nr, nc});
                    }
                }
            }
        }
        
        return false;
    }
}