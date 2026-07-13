class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        
        // Try all possible starting digits from 1 to 9
        for (int start = 1; start <= 9; start++) {
            int num = start;
            int nextDigit = start;
            
            // Build numbers by adding consecutive digits
            while (num <= high && nextDigit <= 9) {
                if (num >= low) {
                    result.add(num);
                }
                nextDigit++;
                num = num * 10 + nextDigit;
            }
        }
        
        Collections.sort(result);
        return result;
    }
}