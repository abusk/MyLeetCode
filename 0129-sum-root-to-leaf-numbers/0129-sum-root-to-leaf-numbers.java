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
    private void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        if(node.left != null){
            node.left.val = node.val * 10 + node.left.val;
            dfs(node.left);
        }
        if(node.right != null){
            node.right.val = node.val * 10 + node.right.val;
            dfs(node.right);
        }
    }
    private int getSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        return getSum(root.left) + getSum(root.right);
    }
    
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return getSum(root);
    }
}