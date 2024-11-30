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
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, new ArrayList<>(), paths);
        List<String> ans = new ArrayList<>();
        for(List<Integer> lst : paths) {
            ans.add(lst.stream().map(String::valueOf).collect(Collectors.joining("->")));
        }
        return ans;
    }
    public void dfs(TreeNode node, List<Integer> path, List<List<Integer>> paths) {
        if(node == null) {
            return;
        }
        path.add(node.val);
        if(node.left == null && node.right == null) {
            paths.add(new ArrayList<>(path));
        } else {
            dfs(node.left, path, paths);
            dfs(node.right, path, paths);
        }
        path.removeLast();
    }
}