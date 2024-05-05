/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // Overwrite data of next node on current node.
        node.val = node.next.val;
        // Make current node point to next of next node.
        node.next = node.next.next;
    }
}