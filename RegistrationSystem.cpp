#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    unordered_map<string, int> map;
    
    for (int i = 0; i < n; i++) {
        string name;
        cin >> name;
        
        if (map.find(name) != map.end()) {
            int count = map[name];
            string newName = name + to_string(count);
            while (map.find(newName) != map.end()) {
                count++;
                newName = name + to_string(count);
            }
            cout << newName << endl;
            map[name] = count + 1;
            map[newName] = 1;
        } else {
            cout << "OK" << endl;
            map[name] = 1;
        }
    }
    
    return 0;
}