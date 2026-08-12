#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    int n = s.length();
    int pos = -1;
    
    for (int i = 0; i < n; i++) {
        if (s[i] == '0') {
            pos = i;
            break;
        }
    }
    
    if (pos == -1) {
        cout << s.substr(1) << endl;
    } else {
        cout << s.substr(0, pos) << s.substr(pos + 1) << endl;
    }
    
    return 0;
}