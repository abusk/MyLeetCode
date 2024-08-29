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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lcaNode = lca(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        // Find paths from LCA to start and destination nodes
        findPath(lcaNode, startValue, pathToStart);
        findPath(lcaNode, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();

        // Add "U" for each step to go up from start to LCA
        directions.append("U".repeat(pathToStart.length()));

        // Append the path from LCA to destination
        directions.append(pathToDest);

        return directions.toString();
    }
    private boolean findPath(TreeNode node, int targetValue, StringBuilder path) {
        if (node == null) return false;

        if (node.val == targetValue) return true;

        // Try left subtree
        path.append("L");
        if (findPath(node.left, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        // Try right subtree
        path.append("R");
        if (findPath(node.right, targetValue, path)) {
            return true;
        }
        path.setLength(path.length() - 1); // Remove last character

        return false;
    }
    // public String start(TreeNode lcaNode, int start, String path) {
    //     if(lcaNode == null) {
    //         return "";
    //     }
    //     if(lcaNode.val == start) {
    //         return path;
    //     }
    //     String p1 = start(lcaNode.left, start, path + "U");
    //     String p2 = start(lcaNode.right, start, path + "U");
    //     return p1 + p2;
    // }
    // public String dest(TreeNode lcaNode, int dest, String path, String turn) {
    //     if(lcaNode == null) {
    //         return "";
    //     }
    //     path = path + turn;
    //     if(lcaNode.val == dest) {
    //         return path;
    //     }
    //     return dest(lcaNode.left, dest, path , "L") + dest(lcaNode.right, dest, path, "R");
    // }
    public TreeNode lca(TreeNode node, int startValue, int destValue) {
        if(node == null) {
            return null;
        }
        if(node.val == startValue || node.val == destValue) {
            return node;
        }
        TreeNode left = lca(node.left, startValue, destValue);
        TreeNode right = lca(node.right, startValue, destValue);
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        return node;
    }
}