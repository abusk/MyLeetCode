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
    public long max = 0;
    public int rrv = 0;
    public int maxProduct(TreeNode root) {
       this.rrv = sum(root); 
       dfs(root);
       return (int) (max % 1000000007);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lv = dfs(root.left);
        int rv = dfs(root.right);
        int ts = root.val + lv + rv;
        long p = (long) (rrv -ts) * ts;
        this.max = Math.max(max, p);
        return ts;
    }
    public int sum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int lv = sum(root.left);
        int rv = sum(root.right);
        return root.val + lv + rv;
    }
}