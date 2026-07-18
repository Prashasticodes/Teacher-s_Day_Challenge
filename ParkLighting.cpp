#include <iostream>
using namespace std;

int main() {
    int t;
    cin >> t;
    
    while (t--) {
        int n, m;
        cin >> n >> m;
        
        int cells = n * m;
        int lanterns = (cells + 1) / 2;
        
        cout << lanterns << endl;
    }
    
    return 0;
}