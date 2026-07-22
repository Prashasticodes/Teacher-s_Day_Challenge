#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    vector<int> a(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    
    for (int i = 0; i < n; i++) {
        int position = 1;
        for (int j = 0; j < n; j++) {
            if (a[j] > a[i]) {
                position++;
            }
        }
        cout << position << " ";
    }
    cout << endl;
    
    return 0;
}