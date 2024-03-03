# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        node = dummy
        fst = dummy
        while n >=0:
            node = node.next
            n -=1
        while node is not None:
            node = node.next
            fst = fst.next
        fst.next = fst.next.next
        return dummy.next
        