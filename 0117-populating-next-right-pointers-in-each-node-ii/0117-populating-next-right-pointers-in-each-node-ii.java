/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        if(root == null){
            return;
        }
        q.add(root);
        while(!q.isEmpty()){
            int l = q.size();
            while(l>1){
                Node pl = q.poll();
                pl.next = q.peek();
                if(pl.left != null) {
                    q.add(pl.left);
                }
                if(pl.right != null){
                    q.add(pl.right);
                }
                l--;
            }
            Node pk = q.poll();
            if(pk.left != null){
                q.add(pk.left);
            }
            if(pk.right != null) {
                q.add(pk.right);
            }
        }
    }
    public Node connect(Node root) {
        bfs(root);
        return root;
    }
}