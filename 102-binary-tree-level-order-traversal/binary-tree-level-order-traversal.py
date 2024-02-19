# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        q = []
        q.append(root)
        q.append(None)
        res = []
        lres = []
        while len(q) > 0:
            r = q.pop(0)
            if len(lres) > 0 and r is None:
                q.append(None)
                res.append(lres)
                lres = []
            elif len(lres) == 0 and r is None and len(q) > 0:
                q.append(None)
                lres = []
            elif r is not None:
                lres.append(r.val)
                if r.left is not None:
                    q.append(r.left)
                if r.right is not None:
                    q.append(r.right)
        return res
        
            
            
            
        
        