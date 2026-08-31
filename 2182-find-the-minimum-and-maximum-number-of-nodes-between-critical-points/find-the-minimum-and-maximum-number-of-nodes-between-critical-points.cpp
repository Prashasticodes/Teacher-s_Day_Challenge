/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        if (!head || !head->next || !head->next->next) {
            return {-1, -1};
        }
        
        ListNode* prev = head;
        ListNode* curr = head->next;
        ListNode* next = curr->next;
        
        int firstIdx = -1;
        int lastIdx = -1;
        int minDist = INT_MAX;
        int idx = 1;
        
        while (next) {
            if ((curr->val > prev->val && curr->val > next->val) ||
                (curr->val < prev->val && curr->val < next->val)) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = min(minDist, idx - lastIdx);
                }
                lastIdx = idx;
            }
            prev = curr;
            curr = next;
            next = next->next;
            idx++;
        }
        
        if (firstIdx == -1 || lastIdx == firstIdx) {
            return {-1, -1};
        }
        
        return {minDist, lastIdx - firstIdx};
    }
};  
