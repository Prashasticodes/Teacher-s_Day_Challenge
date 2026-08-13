#include <iostream>
using namespace std;

int main() {
    int t;
    cin >> t;
    
    int nearlyPrimes[] = {6, 10, 14, 15, 21, 22, 26, 33, 34, 35, 38, 39, 46, 51, 55, 57, 58, 62, 65, 69, 74, 77, 82, 85, 86, 87, 91, 93, 94, 95};
    int size = 30;
    
    while (t--) {
        int n;
        cin >> n;
        
        bool found = false;
        
        for (int i = 0; i < size && !found; i++) {
            for (int j = i + 1; j < size && !found; j++) {
                for (int k = j + 1; k < size && !found; k++) {
                    int sum = nearlyPrimes[i] + nearlyPrimes[j] + nearlyPrimes[k];
                    int fourth = n - sum;
                    if (fourth > 0 && fourth != nearlyPrimes[i] && fourth != nearlyPrimes[j] && fourth != nearlyPrimes[k]) {
                        cout << "YES\n";
                        cout << nearlyPrimes[i] << " " << nearlyPrimes[j] << " " << nearlyPrimes[k] << " " << fourth << "\n";
                        found = true;
                    }
                }
            }
        }
        
        if (!found) {
            cout << "NO\n";
        }
    }
    
    return 0;
}