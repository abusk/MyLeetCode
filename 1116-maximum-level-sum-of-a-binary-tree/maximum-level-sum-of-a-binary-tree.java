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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int ans = 0;
        int level = 0;
        long max = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            long sum = 0;
            int l = queue.size();
            for(int i = 0; i<l; i++) {
                TreeNode next = queue.poll();
                sum += next.val;
                if(next.left != null) {
                    queue.add(next.left);
                }
                if(next.right != null) {
                    queue.add(next.right);
                }
            }
            if(sum > max) {
                max = sum;
                ans = level;
            }
        }
        return ans;
    }

}