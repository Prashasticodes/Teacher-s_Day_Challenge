#include <iostream>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    
    int scores[n];
    for (int i = 0; i < n; i++) {
        cin >> scores[i];
    }
    
    int cutoffScore = scores[k - 1];
    int advancers = 0;
    
    for (int i = 0; i < n; i++) {
        if (scores[i] >= cutoffScore && scores[i] > 0) {
            advancers++;
        } else {
            break;
        }
    }
    
    cout << advancers << endl;
    
    return 0;
}