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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> q1 = new Stack<>();
        Stack<TreeNode> q2 = new Stack<>();
        if(root == null) {
            return Collections.EMPTY_LIST;
        }
        q1.push(root);
        while(!q1.isEmpty() || !q2.isEmpty()) {
            List<Integer> ir1 = new ArrayList<>();
            while(!q1.isEmpty()){
                TreeNode nxt = q1.pop();
                ir1.add(nxt.val);
                if(nxt.left != null) {
                   q2.push(nxt.left);   
                }
                if(nxt.right != null){
                    q2.push(nxt.right);
                }
                
            }
            if(!ir1.isEmpty()){
                res.add(ir1);
            }
            List<Integer> ir2 = new ArrayList<>();
            while(!q2.isEmpty()){
                TreeNode nxt = q2.pop();
                ir2.add(nxt.val);
                if(nxt.right != null) {
                   q1.push(nxt.right);   
                }
                if(nxt.left != null){
                    q1.push(nxt.left);
                }
            }
            if(!ir2.isEmpty()){
                res.add(ir2);
            }
        }
        return res;
    }
}