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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode nxt = head;
        int c = 0;
        while(nxt != null) {
            c++;
            nxt = nxt.next;
        }
        k = k%c;
        if(k == 0) {
            return head;
        }
        nxt = head;
        while(nxt != null && k > 0) {
            nxt = nxt.next;
            k--;
        }
        ListNode start = head;
        
        while(nxt.next != null) {
            start = start.next;
            nxt = nxt.next;
        }
        ListNode dummyH = start.next;
        start.next = null;
        ListNode dummyT = dummyH;
        while(dummyT.next != null){
            dummyT = dummyT.next;
        }
        dummyT.next = head;
        return dummyH;
    }
}