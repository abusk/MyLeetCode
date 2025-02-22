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
    public TreeNode recoverFromPreorder(String traversal) {
        List<String> lst = new ArrayList<>();
        int s = 0;
        boolean flag = true;
        for(int i = 0; i<traversal.length(); i++) {
            if(Character.isDigit(traversal.charAt(i))) {
                if(!flag) {
                    lst.add(traversal.substring(s, i));
                    s = i;
                    flag = true;
                }
            } else {
                if(flag) {
                    lst.add(traversal.substring(s, i));
                    s = i;
                    flag = false;
                }
            }
        }
        lst.add(traversal.substring(s));
        TreeNode root = new TreeNode(Integer.valueOf(lst.get(0)));
        if(lst.size() > 1) {
            recur(root, lst, 1);
        }
        return root;
    }
    public void recur(TreeNode node, List<String> traversal, int level) {
        List<List<String>> subTree = split(traversal, level);
        if(subTree.size() == 0) {
            return;
        }
        List<String> left = subTree.get(0);
        node.left = new TreeNode(Integer.valueOf(left.get(0)));
        if(left.size() > 1) {
            recur(node.left, left, level+1);
        }

        if(subTree.size() == 2) {
            List<String> right = subTree.get(1);
            node.right = new TreeNode(Integer.valueOf(right.get(0)));
            if(right.size() > 1) {
                recur(node.right, right, level+1);
            }
        }
    }
    
    public List<List<String>> split(List<String> lst, int level) {
        List<List<String>> ans = new ArrayList<>();
        if(lst.size() == 1) {
            ans.add(lst);
            return ans;
        }
        String dash = "";
        for(int i = 0; i<level; i++) {
            dash += "-";
        }
        int index1 = lst.indexOf(dash);
        int index2 = lst.lastIndexOf(dash);
        if(index2 != index1) {
            ans.add(lst.subList(index1+1, index2));
            ans.add(lst.subList(index2+1, lst.size()));
        } else {
            ans.add(lst.subList(index1+1, lst.size()));
        }
        return ans;
    }
}