#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> cards(n);
    for (int i = 0; i < n; i++) {
        cin >> cards[i];
    }
    
    int left = 0, right = n - 1;
    int sereja = 0, dima = 0;
    bool serejaTurn = true;
    
    while (left <= right) {
        int taken;
        if (cards[left] > cards[right]) {
            taken = cards[left];
            left++;
        } else {
            taken = cards[right];
            right--;
        }
        
        if (serejaTurn) {
            sereja += taken;
        } else {
            dima += taken;
        }
        serejaTurn = !serejaTurn;
    }
    
    cout << sereja << " " << dima << endl;
    
    return 0;
}