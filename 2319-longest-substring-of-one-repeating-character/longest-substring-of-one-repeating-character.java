class Solution {
    private char[] treePrefixChar;
    private char[] treeSuffixChar;
    private int[] treePrefixLen;
    private int[] treeSuffixLen;
    private int[] treeMaxLen;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        int k = queryIndices.length;

        // Allocate segment tree arrays (4 * n space is sufficient)
        treePrefixChar = new char[4 * n];
        treeSuffixChar = new char[4 * n];
        treePrefixLen = new int[4 * n];
        treeSuffixLen = new int[4 * n];
        treeMaxLen = new int[4 * n];

        char[] sArr = s.toCharArray();
        build(1, 0, n - 1, sArr);

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters.charAt(i);
            
            update(1, 0, n - 1, idx, ch);
            result[i] = treeMaxLen[1]; // Root node holds the answer for the full string
        }

        return result;
    }

    private void build(int node, int start, int end, char[] s) {
        if (start == end) {
            treePrefixChar[node] = s[start];
            treeSuffixChar[node] = s[start];
            treePrefixLen[node] = 1;
            treeSuffixLen[node] = 1;
            treeMaxLen[node] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        build(2 * node, start, mid, s);
        build(2 * node + 1, mid + 1, end, s);
        merge(node, 2 * node, 2 * node + 1, mid - start + 1, end - mid);
    }

    private void update(int node, int start, int end, int idx, char ch) {
        if (start == end) {
            treePrefixChar[node] = ch;
            treeSuffixChar[node] = ch;
            treePrefixLen[node] = 1;
            treeSuffixLen[node] = 1;
            treeMaxLen[node] = 1;
            return;
        }

        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, ch);
        } else {
            update(2 * node + 1, mid + 1, end, idx, ch);
        }
        merge(node, 2 * node, 2 * node + 1, mid - start + 1, end - mid);
    }

    private void merge(int node, int leftChild, int rightChild, int lLen, int rLen) {
        // Prefix update
        treePrefixChar[node] = treePrefixChar[leftChild];
        treePrefixLen[node] = treePrefixLen[leftChild];
        if (treePrefixLen[leftChild] == lLen && treePrefixChar[leftChild] == treePrefixChar[rightChild]) {
            treePrefixLen[node] += treePrefixLen[rightChild];
        }

        // Suffix update
        treeSuffixChar[node] = treeSuffixChar[rightChild];
        treeSuffixLen[node] = treeSuffixLen[rightChild];
        if (treeSuffixLen[rightChild] == rLen && treeSuffixChar[rightChild] == treeSuffixChar[leftChild]) {
            treeSuffixLen[node] += treeSuffixLen[leftChild];
        }

        // Boundary cross update
        int midCross = 0;
        if (treeSuffixChar[leftChild] == treePrefixChar[rightChild]) {
            midCross = treeSuffixLen[leftChild] + treePrefixLen[rightChild];
        }

        treeMaxLen[node] = Math.max(Math.max(treeMaxLen[leftChild], treeMaxLen[rightChild]), midCross);
    }
}