#include <iostream>
#include <string>
#include <algorithm>
#include <cstdlib>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    char current = 'a';
    int totalRotations = 0;
    
    for (char target : s) {
        int diff = abs(target - current);
        int rotations = min(diff, 26 - diff);
        totalRotations += rotations;
        current = target;
    }
    
    cout << totalRotations << endl;
    
    return 0;
}