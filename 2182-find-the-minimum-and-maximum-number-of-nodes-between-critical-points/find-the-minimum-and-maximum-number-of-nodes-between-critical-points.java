/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        
        int firstIdx = -1;
        int lastIdx = -1;
        int minDist = Integer.MAX_VALUE;
        int idx = 1;
        
        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {
                if (firstIdx == -1) {
                    firstIdx = idx;
                } else {
                    minDist = Math.min(minDist, idx - lastIdx);
                }
                lastIdx = idx;
            }
            prev = curr;
            curr = next;
            next = next.next;
            idx++;
        }
        
        if (firstIdx == -1 || lastIdx == firstIdx) {
            return new int[]{-1, -1};
        }
        
        return new int[]{minDist, lastIdx - firstIdx};
    }
}    
