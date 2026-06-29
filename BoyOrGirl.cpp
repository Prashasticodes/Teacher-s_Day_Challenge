#include <iostream>
#include <string>
#include <unordered_set>
using namespace std;

int main() {
    string s;
    cin >> s;
    
    unordered_set<char> distinct;
    
    for (char c : s) {
        distinct.insert(c);
    }
    
    if (distinct.size() % 2 == 0) {
        cout << "CHAT WITH HER!" << endl;
    } else {
        cout << "IGNORE HIM!" << endl;
    }
    
    return 0;
}