class Solution {
    public int trap(int[] height) {
        int res = 0;
        for(int i = 0; i<height.length; i++) {
            int lmax = 0; 
            int rmax = 0;
            for(int j = i; j >=0; j--) {
                lmax = Math.max(lmax, height[j]);
            }
            for(int j = i; j < height.length; j++){
                rmax = Math.max(rmax, height[j]);
            }
            res += (Math.min(lmax, rmax) - height[i]);
        }
        return res;
    }
}