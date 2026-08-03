#include <iostream>
#include <string>
#include <cmath>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    int len = s.length();
    int index = 0;
    
    for (int i = 1; i < len; i++) {
        index += pow(2, i);
    }
    
    for (int i = 0; i < len; i++) {
        if (s[i] == '7') {
            index += pow(2, len - 1 - i);
        }
    }
    
    cout << index + 1 << endl;
    
    return 0;
}