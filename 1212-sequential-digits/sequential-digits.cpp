class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        vector<int> result;
        
        // Try all possible starting digits from 1 to 9
        for (int start = 1; start <= 9; start++) {
            int num = start;
            int nextDigit = start;
            
            // Build numbers by adding consecutive digits
            while (num <= high && nextDigit <= 9) {
                if (num >= low) {
                    result.push_back(num);
                }
                nextDigit++;
                num = num * 10 + nextDigit;
            }
        }
        
        sort(result.begin(), result.end());
        return result;
    }
};