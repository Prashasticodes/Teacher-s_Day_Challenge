#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> p(n + 1);
    vector<int> result(n + 1);
    
    for (int i = 1; i <= n; i++) {
        cin >> p[i];
        result[p[i]] = i;
    }
    
    for (int i = 1; i <= n; i++) {
        cout << result[i] << " ";
    }
    cout << endl;
    
    return 0;
}