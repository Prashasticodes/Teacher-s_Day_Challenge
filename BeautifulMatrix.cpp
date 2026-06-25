#include <iostream>
#include <cstdlib>
using namespace std;

int main() {
    int rowPos = 0, colPos = 0;
    
    for (int i = 1; i <= 5; i++) {
        for (int j = 1; j <= 5; j++) {
            int value;
            cin >> value;
            if (value == 1) {
                rowPos = i;
                colPos = j;
            }
        }
    }
    
    int moves = abs(rowPos - 3) + abs(colPos - 3);
    cout << moves << endl;
    
    return 0;
}