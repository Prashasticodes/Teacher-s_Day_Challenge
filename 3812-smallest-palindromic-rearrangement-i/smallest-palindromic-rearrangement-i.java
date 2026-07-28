class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        char[] result = new char[n];
        int left = 0, right = n - 1;
        char middle = 0;
        
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
            for (int j = 0; j < count[i] / 2; j++) {
                result[left++] = result[right--] = (char) ('a' + i);
            }
        }
        
        if (middle != 0) {
            result[left] = middle;
        }
        
        return new String(result);
    }
}