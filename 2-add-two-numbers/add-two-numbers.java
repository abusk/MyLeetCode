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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = null;
        ListNode last = null;
        while (l1!= null || l2 != null) {
            int sum = 0;
            if(l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if(l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            int v = sum % 10;
            carry = sum / 10;
            if(result == null) {
                result = new ListNode(v);
                last = result;
            } else {
                last.next = new ListNode(v);
                last = last.next;
            }
        }
        if(carry > 0) {
            last.next = new ListNode(carry);
            last = last.next;
        }
        return result;
    }
}