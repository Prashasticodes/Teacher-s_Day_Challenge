#include <vector>
#include <queue>

using namespace std;

class Solution {
public:
    bool findSafeWalk(vector<vector<int>>& grid, int health) {
        int m = grid.size();
        int n = grid[0].size();
        
        vector<vector<int>> minCost(m, vector<int>(n, 1e9));
        minCost[0][0] = grid[0][0];
        
        // Min-heap storing {cost, r, c}
        priority_queue<vector<int>, vector<vector<int>>, greater<vector<int>>> pq;
        pq.push({grid[0][0], 0, 0});
        
        vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!pq.empty()) {
            auto curr = pq.top();
            pq.pop();
            
            int currCost = curr[0];
            int r = curr[1];
            int c = curr[2];
            
            if (r == m - 1 && c == n - 1) {
                return currCost < health;
            }
            
            if (currCost > minCost[r][c]) {
                continue;
            }
            
            for (auto& [dr, dc] : directions) {
                int nr = r + dr;
                int nc = c + dc;
                
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextCost = currCost + grid[nr][nc];
                    
                    if (nextCost < minCost[nr][nc]) {
                        minCost[nr][nc] = nextCost;
                        pq.push({nextCost, nr, nc});
                    }
                }
            }
        }
        
        return false;
    }
};