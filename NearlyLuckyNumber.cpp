#include <iostream>
#include <string>
using namespace std;

int main() {
    string n;
    cin >> n;
    
    int luckyCount = 0;
    
    for (char c : n) {
        if (c == '4' || c == '7') {
            luckyCount++;
        }
    }
    
    string countStr = to_string(luckyCount);
    bool isLucky = true;
    
    if (luckyCount == 0) {
        isLucky = false;
    } else {
        for (char c : countStr) {
            if (c != '4' && c != '7') {
                isLucky = false;
                break;
            }
        }
    }
    
    cout << (isLucky ? "YES" : "NO") << endl;
    
    return 0;
}