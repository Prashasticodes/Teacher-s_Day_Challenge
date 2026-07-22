#include <iostream>
using namespace std;

int main() {
    int n, m, k;
    cin >> n >> m >> k;
    
    int bowls = m;
    int plates = k;
    int washes = 0;
    
    for (int i = 0; i < n; i++) {
        int type;
        cin >> type;
        
        if (type == 1) {
            if (bowls > 0) {
                bowls--;
            } else {
                washes++;
            }
        } else {
            if (plates > 0) {
                plates--;
            } else if (bowls > 0) {
                bowls--;
            } else {
                washes++;
            }
        }
    }
    
    cout << washes << endl;
    
    return 0;
}