class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;
        int key = 8; // keys 2-9 = 8 keys
        int pressCount = 1;
        
        for (int i = 0; i < n; i++) {
            pushes += pressCount;
            if ((i + 1) % key == 0) {
                pressCount++;
            }
        }
        return pushes;
    }
}