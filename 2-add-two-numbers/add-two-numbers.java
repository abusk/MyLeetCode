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
        ListNode ans = new ListNode(-1);
        ListNode next = ans;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int total = (l1.val + l2.val + carry);
            int val = total % 10;
            carry = total /10;
            next.next = new ListNode(val);
            next = next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode rest = l1 != null ? l1 : l2;
        while(rest != null) {
            int total = (rest.val + carry);
            int val = total % 10;
            carry = total /10;
            next.next = new ListNode(val);
            next = next.next;
            rest = rest.next;
        }
        if(carry != 0) {
            next.next = new ListNode(carry);
        }

        return ans.next;
    }
}