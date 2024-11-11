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
    int count;
    int target;
    Map<Long, Integer> map;
    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        count = 0;
        map = new HashMap<>();
        dfs(root, 0L);
        return count;
    }

    public void dfs(TreeNode node, long curSum) {
        if(node == null) {
            return;
        }
        curSum += node.val;
        if(curSum == target) {
            count++;
        }
        count += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        dfs(node.left, curSum);
        dfs(node.right, curSum);
        map.put(curSum, map.get(curSum)-1);
    }
}