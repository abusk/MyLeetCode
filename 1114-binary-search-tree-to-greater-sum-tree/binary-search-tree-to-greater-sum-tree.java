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
    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        inorder(root);
        return root;
    }

    public void inorder(TreeNode node) {
        if(node == null) {
            return;
        }
        inorder(node.right);
        node.val += val;
        val = node.val;
        inorder(node.left);
    }
}