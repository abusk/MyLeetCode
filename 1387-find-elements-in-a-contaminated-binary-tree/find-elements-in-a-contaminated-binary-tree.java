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
class FindElements {
    Set<Integer> st;
    public FindElements(TreeNode root) {
        st = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        root.val = 0;
        st.add(root.val);
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            if(left != null) {
                left.val = 2 * node.val + 1;
                st.add(left.val);
                q.offer(left);
            }
            TreeNode right = node.right;
            if(right != null) {
                right.val = 2 * node.val + 2;
                st.add(right.val);
                q.offer(right);
            }
        }
    }
    
    public boolean find(int target) {
        return st.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */