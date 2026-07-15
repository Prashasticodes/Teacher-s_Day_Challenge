#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n, m, a, b;
    cin >> n >> m >> a >> b;
    
    int cost1 = n * a;
    int cost2 = (n / m) * b + (n % m) * a;
    int cost3 = ((n + m - 1) / m) * b;
    
    int result = min(cost1, min(cost2, cost3));
    cout << result << endl;
    
    return 0;
}