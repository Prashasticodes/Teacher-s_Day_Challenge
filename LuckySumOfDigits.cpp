#include <iostream>
#include <string>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long n;
    if (!(cin >> n)) return 0;

    int count4 = -1;
    int count7 = -1;

    // Maximize '7's to minimize total digits
    for (int b = n / 7; b >= 0; --b) {
        int rem = n - 7 * b;
        if (rem % 4 == 0) {
            count4 = rem / 4;
            count7 = b;
            break;
        }
    }

    if (count4 == -1) {
        cout << -1 << "\n";
    } else {
        // Output all '4's first, followed by all '7's
        cout << string(count4, '4') + string(count7, '7') << "\n";
    }

    return 0;
}