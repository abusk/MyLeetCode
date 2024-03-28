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
    private int postIn;
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postIn = postorder.length -1;
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildFromArray(postorder, 0, postorder.length-1);
    }
    private TreeNode buildFromArray(int[] postorder, int l, int r) {
        if(l > r) return null;
        int val = postorder[postIn--];
        TreeNode root = new TreeNode(val);
        root.right = buildFromArray(postorder, map.get(val)+1, r);
        root.left = buildFromArray(postorder, l, map.get(val)-1);
        return root;
    }
}