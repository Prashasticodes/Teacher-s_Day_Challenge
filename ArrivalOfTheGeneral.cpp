#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> a(n);
    int maxVal = INT_MIN, minVal = INT_MAX;
    int maxIdx = 0, minIdx = 0;
    
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        if (a[i] > maxVal) {
            maxVal = a[i];
            maxIdx = i;
        }
        if (a[i] <= minVal) {
            minVal = a[i];
            minIdx = i;
        }
    }
    
    int moves = maxIdx + (n - 1 - minIdx);
    if (maxIdx > minIdx) {
        moves--;
    }
    
    cout << moves << endl;
    
    return 0;
}