class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Integer[] sortedFreq = new Integer[26];
        for (int i = 0; i < 26; i++) {
            sortedFreq[i] = freq[i];
        }
        Arrays.sort(sortedFreq, (a, b) -> b - a);
        
        int pushes = 0;
        int pressCount = 1;
        int key = 8;
        
        for (int i = 0; i < 26; i++) {
            if (sortedFreq[i] == 0) break;
            pushes += sortedFreq[i] * pressCount;
            if ((i + 1) % key == 0) {
                pressCount++;
            }
        }
        return pushes;
    }
}