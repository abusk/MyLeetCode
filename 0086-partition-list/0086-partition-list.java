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
    public ListNode partition(ListNode head, int x) {
        ListNode lHead = new ListNode(0);
        ListNode lh = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rh = rHead;
        while(head != null) {
            if(head.val < x) {
                ListNode tmp = head;
                lh.next = tmp;
                head = head.next;
                tmp.next = null;
                lh = lh.next;
            } else {
                ListNode tmp = head;
                rh.next = tmp;
                head = head.next; 
                tmp.next = null;
                rh = rh.next;
            }
        }
        lh.next = rHead.next;
        return lHead.next;
    }
}