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
//     public ListNode reverse(ListNode node) {
//         if(node == null || node.next == null) {
//             return node;
//         }
//         ListNode prv = reverse(node.next);
//         node.next.next = node;
//         node.next = null;
//         return prv;
//     }
//     public ListNode reverseBetween(ListNode head, int left, int right) {
//         if(head == null || head.next == null){
//             return head;
//         }
//         ListNode leftP = head;
//         ListNode rightP = null;
//         ListNode nxt = head;
//         while(nxt.next != null) {
//             if(nxt.next.val == left) {
//                 leftP = nxt;
//             }
//             if(nxt.val == right) {
//                 rightP = nxt;
//             }
//             nxt = nxt.next;
//         }
//         ListNode rightN = null;
//         if(rightP != null){
//             rightN = rightP.next;
//             rightP.next = null;
//         }
        
//         ListNode rever = leftP;
//         leftP.next = rightN;
        
//         ListNode r = reverse(rever);
//         leftP.next = r;
//         while(leftP.next != null) {
//             leftP = leftP.next;
//         }
//         leftP.next = rightN;
//         return head;
//     }
    
// }

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Move the two pointers until they reach the proper starting point
        // in the list.
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // The two pointers that will fix the final connections.
        ListNode con = prev, tail = cur;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        // Adjust the final connections as explained in the algorithm
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }

        tail.next = cur;
        return head;
    }
}