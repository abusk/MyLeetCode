# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
        
        def dfs(node, s):
            global t
            if node is None:
                return 0
            if s == node.val:
                t+=1
            dfs(node.left, s-node.val)
            dfs(node.right, s-node.val)
        
        def traverse(node, s):
            if node is None:
                return
            dfs(node, s)
            traverse(node.left, s)
            traverse(node.right, s)
        global t
        t = 0
        traverse(root, targetSum)
        return t
        