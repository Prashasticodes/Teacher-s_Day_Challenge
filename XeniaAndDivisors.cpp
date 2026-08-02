#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int count[8] = {0};
    
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        count[x]++;
    }
    
    if (count[5] > 0 || count[7] > 0) {
        cout << -1 << endl;
        return 0;
    }
    
    int c1 = count[1], c2 = count[2], c3 = count[3], c4 = count[4], c6 = count[6];
    
    for (int g126 = 0; g126 <= min(c1, min(c2, c6)); g126++) {
        int remaining1 = c1 - g126;
        int remaining2 = c2 - g126;
        int remaining6 = c6 - g126;
        
        int g124 = min(remaining1, min(remaining2, c4));
        remaining1 -= g124;
        remaining2 -= g124;
        int remaining4 = c4 - g124;
        
        int g136 = min(remaining1, min(c3, remaining6));
        remaining1 -= g136;
        int remaining3 = c3 - g136;
        remaining6 -= g136;
        
        if (remaining1 == 0 && remaining2 == 0 && remaining3 == 0 && remaining4 == 0 && remaining6 == 0) {
            for (int i = 0; i < g124; i++) {
                cout << "1 2 4\n";
            }
            for (int i = 0; i < g126; i++) {
                cout << "1 2 6\n";
            }
            for (int i = 0; i < g136; i++) {
                cout << "1 3 6\n";
            }
            return 0;
        }
    }
    
    cout << -1 << endl;
    return 0;
}