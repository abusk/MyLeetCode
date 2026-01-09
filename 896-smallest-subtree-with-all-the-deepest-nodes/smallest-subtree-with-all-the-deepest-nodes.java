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
    public TreeNode left;
    public TreeNode right;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        bfs(root);
        return commonAncestor(root);
    }
    public TreeNode commonAncestor(TreeNode node) {
        if(node == null || node == left || node == right) {
            return node;
        }
        TreeNode leftS = commonAncestor(node.left);
        TreeNode rightS = commonAncestor(node.right);
        if(leftS == left && rightS == right) {
            return node;
        }
        return leftS != null ? leftS : rightS; 
    }
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i< len; i++) {
                TreeNode poll = queue.poll();
                if(i == 0) {
                    left = poll;
                }
                right = poll;
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
    }

}