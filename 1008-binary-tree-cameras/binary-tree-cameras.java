class Solution {
    public int cam = 0;
    public int minCameraCover(TreeNode root) {
        if(minCameraCover_(root) == -1) {
            cam++;
        }
        return cam;
    }
    public int minCameraCover_(TreeNode root) {
        if(root == null) return 1;
        int lc = minCameraCover_(root.left);
        int rc = minCameraCover_(root.right);
        if(lc == -1 || rc == -1) {
            cam++;
            return 0;
        }
        if(lc == 0 || rc == 0) {
            return 1;
        }
        return -1;
    }
}
