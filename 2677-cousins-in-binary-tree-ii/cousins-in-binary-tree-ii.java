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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> levelSum = new ArrayList<>();
        while(!q.isEmpty()) {
            int levelSize = q.size();
            int ls = 0;
            for(int i = 0; i<levelSize; i++) {
                TreeNode cuNode = q.poll();
                ls += cuNode.val;
                if(cuNode.left != null) {
                    q.offer(cuNode.left);
                }
                if(cuNode.right != null) {
                    q.offer(cuNode.right);
                }
            }
            levelSum.add(ls);
        }
        q.offer(root);
        int level = 1;
        root.val = 0;
        while(!q.isEmpty()) {
            int lsize = q.size();
            for(int i = 0; i<lsize; i++) {
                TreeNode cur = q.poll();
                int sibling = (cur.left != null ? cur.left.val : 0) + (cur.right != null ? cur.right.val : 0);
                if(cur.left != null) {
                    cur.left.val = levelSum.get(level) - sibling;
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    cur.right.val = levelSum.get(level) - sibling;
                    q.offer(cur.right);
                }
            }
            level++;
        }
        return root;
    }
}