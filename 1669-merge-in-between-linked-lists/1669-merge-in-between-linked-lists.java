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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, list1);
        int fst = 0;
        int snd = 0;
        ListNode tr = dummy;
        ListNode aprev = dummy;
        ListNode bprev = dummy;
        while(tr != null){
            if(fst == a){
                aprev = tr;
            }
            if(snd == b+2){
                bprev = tr;
            }
            fst++;
            snd++;
            tr = tr.next;
        }
        ListNode sndList = list2;
        while(sndList.next != null){
            sndList = sndList.next;
        }
        sndList.next = bprev;
        aprev.next = list2;
        return dummy.next;
    }
}