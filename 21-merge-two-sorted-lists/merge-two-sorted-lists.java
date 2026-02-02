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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dNode = new ListNode(-1111);
        ListNode last = dNode;
        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                last.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                last.next = new ListNode(list2.val);
                list2 = list2.next;  
            }
            last = last.next;
        }
        if(list1 != null) {
            last.next = list1;
        }
        if(list2 != null) {
            last.next = list2;
        }
        return dNode.next;
    }
}