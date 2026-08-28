#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct Segment {
    int left, right, length;
    
    Segment(int l, int r) : left(l), right(r), length(r - l + 1) {}
    
    bool operator<(const Segment& other) const {
        if (length != other.length) {
            return length < other.length;
        }
        return left > other.left;
    }
};

int main() {
    int t;
    cin >> t;
    
    while (t--) {
        int n;
        cin >> n;
        
        vector<int> a(n);
        priority_queue<Segment> pq;
        pq.push(Segment(0, n - 1));
        
        for (int i = 1; i <= n; i++) {
            Segment seg = pq.top();
            pq.pop();
            
            int mid = (seg.left + seg.right) / 2;
            a[mid] = i;
            
            if (seg.left <= mid - 1) {
                pq.push(Segment(seg.left, mid - 1));
            }
            if (mid + 1 <= seg.right) {
                pq.push(Segment(mid + 1, seg.right));
            }
        }
        
        for (int i = 0; i < n; i++) {
            cout << a[i] << " ";
        }
        cout << endl;
    }
    
    return 0;
}