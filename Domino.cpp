#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int sumUpper = 0;
    int sumLower = 0;
    bool hasOddPair = false;
    
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        sumUpper += x;
        sumLower += y;
        if ((x % 2 == 1 && y % 2 == 0) || (x % 2 == 0 && y % 2 == 1)) {
            hasOddPair = true;
        }
    }
    
    if (sumUpper % 2 == 0 && sumLower % 2 == 0) {
        cout << 0 << endl;
    } else if (sumUpper % 2 == 1 && sumLower % 2 == 1 && hasOddPair) {
        cout << 1 << endl;
    } else {
        cout << -1 << endl;
    }
    
    return 0;
}