# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        self.f = head
        
        def pdl(s):
            if s is not None:
                if not pdl(s.next):
                    return False
                if self.f.val != s.val:
                    return False
                self.f = self.f.next
            return True
        return pdl(head)
            
            
            
        
        
        