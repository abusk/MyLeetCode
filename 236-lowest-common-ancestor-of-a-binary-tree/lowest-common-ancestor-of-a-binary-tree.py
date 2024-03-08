# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def dfs(node, p, q):
            if node is None:
                return None
            if node.val == p.val or node.val == q.val:
                return node
            lc = dfs(node.left, p, q)
            rc = dfs(node.right, p, q)
            if lc and rc:
                return node
            if not lc:
                return rc
            if not rc:
                return lc
        return dfs(root, p, q)
            