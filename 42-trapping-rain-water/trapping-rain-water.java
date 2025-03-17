class Solution {
    public int trap(int[] height) {
        int res = 0;
        int len = height.length;
        int[] rmax = new int[len];
        int[] lmax = new int[len];
        int lm = height[0];
        for(int i = 1; i<len; i++) {
            lmax[i] = lm;
            lm = Math.max(lm, height[i]);
        }
        int rm = height[len-1];
        for(int i = len-2; i>=0; i--) {
            rmax[i] = rm;
            rm = Math.max(rm, height[i]);
        }
        for(int i = 0; i<height.length; i++) {
            int min = Math.min(lmax[i], rmax[i]);
            int water = min - height[i];
            if(water > 0) {
                res += water;
            }
        }
        return res;
    }
}