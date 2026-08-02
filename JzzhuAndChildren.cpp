#include <iostream>
#include <queue>
#include <vector>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    
    vector<int> a(n);
    queue<int> q;
    
    for (int i = 0; i < n; i++) {
        cin >> a[i];
        q.push(i);
    }
    
    int lastChild = 0;
    
    while (!q.empty()) {
        int child = q.front();
        q.pop();
        a[child] -= m;
        
        if (a[child] > 0) {
            q.push(child);
        }
        
        lastChild = child;
    }
    
    cout << lastChild + 1 << endl;
    
    return 0;
}