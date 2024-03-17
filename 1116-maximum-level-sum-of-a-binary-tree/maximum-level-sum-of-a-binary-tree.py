# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        mx, ans, l = float('-inf'), 0, 0
        q = collections.deque()
        q.append(root)
        
        while q:
            l +=1
            ls = 0
            for _ in range(len(q)):
                n = q.popleft()
                ls += n.val
                if n.left:
                    q.append(n.left)
                if n.right:
                    q.append(n.right)
            if mx < ls:
                mx, ans = ls, l
        return ans
            
                
                    
                    
                
            
            
        