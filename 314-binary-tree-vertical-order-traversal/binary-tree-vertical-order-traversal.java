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
    record Pair(Integer nVal, Integer nH){}
    Map<Integer, List<Pair>> map = new HashMap<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        dfs(root, 0, 0);
        List<Integer> keys = new ArrayList<>(map.keySet());
        keys.sort((a,b) -> a-b);
        List<List<Integer>> ans = new ArrayList<>();
        for(int k : keys) {
            List<Pair> ps = map.get(k);
            ps.sort((a,b)-> a.nH - b.nH);
            List<Integer> lst = ps.stream().map(a -> a.nVal).toList();
            ans.add(lst);
        }
        return ans;
    }
    public void dfs(TreeNode node, int level, int height) {
        if(node == null) {
            return;
        }
        List<Pair> st = map.getOrDefault(level, new ArrayList<>());
        st.add(new Pair(node.val, height));
        map.put(level, st);
        dfs(node.left, level-1, height+1);
        dfs(node.right, level+1, height+1);
    }
    
} 