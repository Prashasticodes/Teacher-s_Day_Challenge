#include <iostream>
using namespace std;

int main() {
    // Read the weight of the watermelon
    int weight;
    cin >> weight;
    
    // Check if the watermelon can be divided into two even parts
    // The weight must be even and greater than 2 because each part must have positive weight
    if (weight % 2 == 0 && weight > 2) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
    
    return 0;
}