class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int, int> reserved;
        for (auto& seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reserved[row] |= (1 << (col - 1));
        }
        
        int groups = 0;
        // Rows without any reservation can accommodate 2 groups
        int emptyRows = n - reserved.size();
        groups += emptyRows * 2;
        
        // Check rows with reservations
        for (auto& [row, mask] : reserved) {
            bool left = (mask & 0b000011110) == 0; // seats 2-5
            bool middle = (mask & 0b001111000) == 0; // seats 4-7
            bool right = (mask & 0b111100000) == 0; // seats 6-9
            
            if (left && right) {
                groups += 2;
            } else if (left || middle || right) {
                groups += 1;
            }
        }
        return groups;
    }
};