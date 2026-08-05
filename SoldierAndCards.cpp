#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    int k1;
    cin >> k1;
    queue<int> p1;
    for (int i = 0; i < k1; i++) {
        int x;
        cin >> x;
        p1.push(x);
    }
    
    int k2;
    cin >> k2;
    queue<int> p2;
    for (int i = 0; i < k2; i++) {
        int x;
        cin >> x;
        p2.push(x);
    }
    
    int fights = 0;
    int limit = 10000;
    
    while (!p1.empty() && !p2.empty() && fights < limit) {
        int card1 = p1.front();
        p1.pop();
        int card2 = p2.front();
        p2.pop();
        
        if (card1 > card2) {
            p1.push(card2);
            p1.push(card1);
        } else {
            p2.push(card1);
            p2.push(card2);
        }
        fights++;
    }
    
    if (p1.empty()) {
        cout << fights << " 2" << endl;
    } else if (p2.empty()) {
        cout << fights << " 1" << endl;
    } else {
        cout << -1 << endl;
    }
    
    return 0;
}