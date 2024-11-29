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
    Map<Integer, Integer> parents = new HashMap<>();
    Map<Integer, Integer> depth = new HashMap<>();  
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode rootParent = new TreeNode(-1);
        dfs(root, rootParent, 0);
        return depth.get(x) == depth.get(y) && parents.get(x) != parents.get(y);
    }
    public void dfs(TreeNode node, TreeNode parent, int d) {
        if(node == null) {
            return;
        }
        parents.put(node.val, parent.val);
        depth.put(node.val, d);
        dfs(node.left, node, d+1);
        dfs(node.right, node, d+1);
    }
}