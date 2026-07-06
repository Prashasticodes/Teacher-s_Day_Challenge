class Solution {
public:
    int removeCoveredIntervals(vector<vector<int>>& intervals) {
        // Sort intervals by start ascending, and if start equal, by end descending
        sort(intervals.begin(), intervals.end(), [](const vector<int>& a, const vector<int>& b) {
            if (a[0] == b[0]) {
                return b[1] < a[1]; // larger end first
            }
            return a[0] < b[0];
        });
        
        int count = 0;
        int maxEnd = 0;
        
        for (const vector<int>& interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            
            // If current interval's end is beyond the maximum end seen so far,
            // it is not covered by any previous interval.
            if (end > maxEnd) {
                count++;
                maxEnd = end; // update max end
            }
            // Otherwise, it is covered by an interval with start <= current start
            // and end >= current end (since we processed larger ends first for same start)
        }
        
        return count;
    }
};