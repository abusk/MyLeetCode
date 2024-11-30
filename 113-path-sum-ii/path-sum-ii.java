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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
    public void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if(node == null) {
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null && targetSum == node.val) {
            ans.add(new ArrayList<>(path));
        } else {
            dfs(node.left, targetSum - node.val, path, ans);
            dfs(node.right, targetSum - node.val, path, ans);
        }
        path.removeLast();
    }
}