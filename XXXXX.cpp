#include <iostream>
#include <vector>
using namespace std;

int main() {
    int t;
    cin >> t;
    
    while (t--) {
        int n, x;
        cin >> n >> x;
        
        vector<int> a(n);
        int totalSum = 0;
        int firstNonDiv = -1;
        int lastNonDiv = -1;
        
        for (int i = 0; i < n; i++) {
            cin >> a[i];
            totalSum += a[i];
            if (a[i] % x != 0) {
                if (firstNonDiv == -1) {
                    firstNonDiv = i;
                }
                lastNonDiv = i;
            }
        }
        
        if (totalSum % x != 0) {
            cout << n << endl;
        } else if (firstNonDiv == -1) {
            cout << -1 << endl;
        } else {
            int removeFromLeft = firstNonDiv + 1;
            int removeFromRight = n - lastNonDiv;
            int maxLen = n - min(removeFromLeft, removeFromRight);
            cout << maxLen << endl;
        }
    }
    
    return 0;
}