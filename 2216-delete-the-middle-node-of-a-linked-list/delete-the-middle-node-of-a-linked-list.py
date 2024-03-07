# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        s = dummy
        f = head
        while f and f.next:
            s = s.next
            f = f.next.next
        s.next = s.next.next
        return dummy.next
        