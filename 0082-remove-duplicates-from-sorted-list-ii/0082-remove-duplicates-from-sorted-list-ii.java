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
// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         ListNode start = head;
//         Map<Integer, Integer> map = new HashMap<>();
//         while(start != null){
//             map.compute(start.val, (k, v) -> (v == null) ? 1 : v + 1);
//             start = start.next;
//         }
//         ListNode dummy = new ListNode(Integer.MIN_VALUE);
//         ListNode nxt = dummy;
//         ListNode tr = head;
//         while(tr != null){
//             if(map.get(tr.val) == 1){
//                 ListNode node = new ListNode(tr.val);
//                 nxt.next = node;
//                 nxt = nxt.next;
//             }
//             tr = tr.next;
//         }
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Sentinel
        ListNode sentinel = new ListNode(0, head);

        // predecessor = the last node 
        // before the sublist of duplicates
        ListNode pred = sentinel;
        
        while (head != null) {
            // If it's a beginning of the duplicates sublist 
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // Move till the end of the duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;    
                }

                // Skip all duplicates
                pred.next = head.next;
    
            // otherwise, move predecessor
            } else {
                pred = pred.next;    
            }
                
            // move forward
            head = head.next;    
        }  
        return sentinel.next;
    }
}