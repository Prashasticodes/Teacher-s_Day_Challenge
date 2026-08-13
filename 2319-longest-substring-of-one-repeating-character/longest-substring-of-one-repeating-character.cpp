#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
private:
    vector<char> treePrefixChar;
    vector<char> treeSuffixChar;
    vector<int> treePrefixLen;
    vector<int> treeSuffixLen;
    vector<int> treeMaxLen;

    void merge(int node, int leftChild, int rightChild, int lLen, int rLen) {
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

        treeMaxLen[node] = max({treeMaxLen[leftChild], treeMaxLen[rightChild], midCross});
    }

    void build(int node, int start, int end, const string& s) {
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

    void update(int node, int start, int end, int idx, char ch) {
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

public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        int n = s.length();
        int k = queryIndices.size();

        // Allocate segment tree arrays (4 * n space is sufficient)
        treePrefixChar.resize(4 * n);
        treeSuffixChar.resize(4 * n);
        treePrefixLen.resize(4 * n);
        treeSuffixLen.resize(4 * n);
        treeMaxLen.resize(4 * n);

        build(1, 0, n - 1, s);

        vector<int> result(k);
        for (int i = 0; i < k; i++) {
            int idx = queryIndices[i];
            char ch = queryCharacters[i];

            update(1, 0, n - 1, idx, ch);
            result[i] = treeMaxLen[1]; // Root node holds the answer for the full string
        }

        return result;
    }
};