# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        fst = head
        if fst is None:
            return False
        snd = fst.next
        while fst != snd:
            if snd is None or snd.next is None:
                return False
            fst = fst.next
            snd = snd.next.next
        return True
        