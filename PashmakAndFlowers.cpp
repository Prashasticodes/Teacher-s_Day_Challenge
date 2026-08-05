#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<long long> b(n);
    long long minVal = LLONG_MAX;
    long long maxVal = LLONG_MIN;
    
    for (int i = 0; i < n; i++) {
        cin >> b[i];
        if (b[i] < minVal) minVal = b[i];
        if (b[i] > maxVal) maxVal = b[i];
    }
    
    long long diff = maxVal - minVal;
    
    if (diff == 0) {
        long long ways = (long long)n * (n - 1) / 2;
        cout << diff << " " << ways << endl;
    } else {
        long long countMin = 0, countMax = 0;
        for (int i = 0; i < n; i++) {
            if (b[i] == minVal) countMin++;
            if (b[i] == maxVal) countMax++;
        }
        cout << diff << " " << (countMin * countMax) << endl;
    }
    
    return 0;
}