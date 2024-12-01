/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return max;
    }
    public int dfs(TreeNode node, int prevVal) {
        if(node == null) {
            return 0;
        }
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        max = Math.max(max, left + right);
        return node.val == prevVal ? Math.max(left, right) +1 : 0;
    }
}