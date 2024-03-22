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
    private ListNode front;
    private boolean check(ListNode head) {
        if(head == null){
            return true;
        }
        if(!check(head.next)){
            return false;
        }
        if(head.val != front.val) {
            return false;
        }
        front = front.next;
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        front = head;
        return check(head);
    }
}