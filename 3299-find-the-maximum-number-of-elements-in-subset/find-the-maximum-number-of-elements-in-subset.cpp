class Solution {
public:
    int maximumLength(vector<int>& nums) {
        unordered_map<long long, int> freq;
        
        // Count frequency of each number
        for (int num : nums) {
            freq[(long long)num]++;
        }
        
        int maxLen = 1; // At least one element can always be selected
        
        // Special case: 1 can form patterns with only 1s
        int countOnes = freq[1];
        if (countOnes > 0) {
            // If we have 1s, we can use all of them (1,1,1,...)
            maxLen = max(maxLen, countOnes % 2 == 0 ? countOnes - 1 : countOnes);
        }
        
        // For each number as the base (except 1)
        for (auto& entry : freq) {
            long long num = entry.first;
            if (num == 1) continue;
            
            long long current = num;
            int length = 0;
            
            // Count how many elements we can take in the increasing part
            while (freq.count(current) && freq[current] >= 2) {
                length += 2; // We take one on each side of the symmetric pattern
                current = current * current;
                
                // Check for overflow beyond 1e9
                if (current > 1000000000LL) {
                    // Need to check if current exists in map one more time
                    if (freq.count(current)) {
                        length++;
                    }
                    break;
                }
            }
            
            // If we found the peak element (where count is 1 or we couldn't continue)
            if (freq.count(current)) {
                // We can take the central element once
                length += 1;
            } else {
                // We overshot, the previous current was the peak
                // We took two for each step, but we need to adjust
                // Actually we need to go back one step
                // Since we added 2 for the last transition, we need to remove one
                // and add the previous element as central
                if (length >= 2) {
                    // The previous current (before squaring) can be the center
                    // We already counted it twice, need to adjust to count it once
                    // Actually in our loop, we added 2 for each pair, but the peak should be counted once
                    // Let's just handle it by not adding the extra +1
                    length = length - 1; // Remove the extra count
                }
            }
            
            maxLen = max(maxLen, length);
        }
        
        return maxLen;
    }
};