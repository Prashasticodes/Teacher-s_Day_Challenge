#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    int numbers[s.length() / 2 + 1];
    int index = 0;
    
    for (int i = 0; i < s.length(); i += 2) {
        numbers[index++] = s[i] - '0';
    }
    
    sort(numbers, numbers + index);
    
    for (int i = 0; i < index; i++) {
        cout << numbers[i];
        if (i < index - 1) {
            cout << "+";
        }
    }
    
    return 0;
}