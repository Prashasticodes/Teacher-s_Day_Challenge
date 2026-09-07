#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    int distinctSubseqII(string s) {
        int MOD = 1e9 + 7;
        vector<long long> last(26, 0);
        long long total = 0;
        
        for (char c : s) {
            int idx = c - 'a';
            long long newCount = (total + 1) % MOD;
            total = (total + newCount - last[idx] + MOD) % MOD;
            last[idx] = newCount;
        }
        
        return total;
    }
};