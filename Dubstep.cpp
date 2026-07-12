#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    string result = "";
    int i = 0;
    
    while (i < s.length()) {
        if (s.substr(i, 3) == "WUB") {
            if (result != "" && result[result.length() - 1] != ' ') {
                result += ' ';
            }
            i += 3;
        } else {
            result += s[i];
            i++;
        }
    }
    
    cout << result << endl;
    
    return 0;
}