#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    int maxLen = 1;
    int currentLen = 1;
    
    for (int i = 1; i < n; i++) {
        if (a[i] >= a[i - 1]) {
            currentLen++;
            maxLen = max(maxLen, currentLen);
        } else {
            currentLen = 1;
        }
    }
    
    cout << maxLen << endl;
    
    return 0;
}