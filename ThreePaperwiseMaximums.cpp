#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int t;
    cin >> t;
    
    while (t--) {
        int x, y, z;
        cin >> x >> y >> z;
        
        int maxVal = max(x, max(y, z));
        int countMax = 0;
        if (x == maxVal) countMax++;
        if (y == maxVal) countMax++;
        if (z == maxVal) countMax++;
        
        if (countMax < 2) {
            cout << "NO" << endl;
            continue;
        }
        
        int a, b, c;
        if (x == maxVal && y == maxVal) {
            a = maxVal;
            b = maxVal;
            c = z;
        } else if (x == maxVal && z == maxVal) {
            a = maxVal;
            b = y;
            c = maxVal;
        } else {
            a = x;
            b = maxVal;
            c = maxVal;
        }
        
        if (a > 0 && b > 0 && c > 0) {
            cout << "YES" << endl;
            cout << a << " " << b << " " << c << endl;
        } else {
            cout << "NO" << endl;
        }
    }
    
    return 0;
}