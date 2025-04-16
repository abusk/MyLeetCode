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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(!isLeaf(root)) {
            ans.add(root.val);
        }
        TreeNode t = root.left;
        while(t != null) {
            if(!isLeaf(t)) {
                ans.add(t.val);
            }
            if(t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        addLeaves(root, ans);
        Stack<Integer> st = new Stack<>();
        t = root.right;
        while(t != null) {
            if(!isLeaf(t)) {
                st.push(t.val);
            }
            if(t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void addLeaves(TreeNode node, List<Integer> leaves) {
        if(node == null) {
            return;
        }
        if(isLeaf(node)) {
            leaves.add(node.val);
        }
        addLeaves(node.left, leaves);
        addLeaves(node.right, leaves);
    }
}