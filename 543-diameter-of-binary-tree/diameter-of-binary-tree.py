# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        diameter = 0
        def mpath(node):
            if node is None:
                return 0
            nonlocal diameter
            lp = mpath(node.left)
            rp = mpath(node.right)
            diameter = max(diameter, lp+rp)
            return max(lp, rp) +1
        mpath(root)
        return diameter
            
        