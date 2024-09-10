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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode f = head.next;
        ListNode s = head;
        while (f != null) {
            ListNode gNode = getGCDNode(s, f);
            s.next = gNode;
            gNode.next = f;
            s = f;
            f = f.next;
        }
        return head;
    }
    public ListNode getGCDNode(ListNode first, ListNode snd) {
        int f = first.val;
        int s = snd .val;
        int a = f >= s ? f : s;
        int b = a == f ? s : f; 
        int g = gcd(a, b);
        ListNode gNode = new ListNode(g);
        return gNode;
    }
    public int gcd(int a, int b) {
        while(a % b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return b;
    }
}