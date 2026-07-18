#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    int n, k, l, c, d, p, nl, np;
    cin >> n >> k >> l >> c >> d >> p >> nl >> np;
    
    int totalDrink = k * l;
    int totalLime = c * d;
    
    int toastsByDrink = totalDrink / nl;
    int toastsByLime = totalLime;
    int toastsBySalt = p / np;
    
    int totalToasts = min(toastsByDrink, min(toastsByLime, toastsBySalt));
    int perFriend = totalToasts / n;
    
    cout << perFriend << endl;
    
    return 0;
}