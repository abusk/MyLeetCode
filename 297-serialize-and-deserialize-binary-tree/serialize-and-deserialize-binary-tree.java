/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                sb.append(",null");
            } else {
                sb.append("," + node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sb.substring(1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] split = data.split("[,]");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = getNode(split[0]);
        q.add(root);
        int i = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node != null) {
                node.left = getNode(split[++i]);
                node.right = getNode(split[++i]);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return root;
    }
    private TreeNode getNode(String val) {
        if(val.equals("null")) {
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));