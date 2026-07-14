#include <iostream>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    
    int current = 1;
    long long time = 0;
    
    for (int i = 0; i < m; i++) {
        int target;
        cin >> target;
        if (target >= current) {
            time += target - current;
        } else {
            time += n - current + target;
        }
        current = target;
    }
    
    cout << time << endl;
    
    return 0;
}