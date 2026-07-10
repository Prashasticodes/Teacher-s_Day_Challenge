#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    int count = 1;
    bool dangerous = false;
    
    for (int i = 1; i < s.length(); i++) {
        if (s[i] == s[i - 1]) {
            count++;
            if (count >= 7) {
                dangerous = true;
                break;
            }
        } else {
            count = 1;
        }
    }
    
    cout << (dangerous ? "YES" : "NO") << endl;
    
    return 0;
}