#include <iostream>
using namespace std;

int main() {
    long long n, k;
    cin >> n >> k;
    
    long long oddCount = (n + 1) / 2;
    
    if (k <= oddCount) {
        cout << 2 * k - 1 << endl;
    } else {
        long long evenPos = k - oddCount;
        cout << 2 * evenPos << endl;
    }
    
    return 0;
}