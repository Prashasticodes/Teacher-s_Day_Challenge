class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> reserved = new HashMap<>();
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            reserved.put(row, reserved.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        
        int groups = 0;
        // Rows without any reservation can accommodate 2 groups
        int emptyRows = n - reserved.size();
        groups += emptyRows * 2;
        
        // Check rows with reservations
        for (int row : reserved.keySet()) {
            int mask = reserved.get(row);
            boolean left = (mask & 0b000011110) == 0; // seats 2-5
            boolean middle = (mask & 0b001111000) == 0; // seats 4-7
            boolean right = (mask & 0b111100000) == 0; // seats 6-9
            
            if (left && right) {
                groups += 2;
            } else if (left || middle || right) {
                groups += 1;
            }
        }
        return groups;
    }
}