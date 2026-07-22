#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    int n = s.length();
    int result = 26 * (n + 1) - n;
    
    cout << result << endl;
    
    return 0;
}