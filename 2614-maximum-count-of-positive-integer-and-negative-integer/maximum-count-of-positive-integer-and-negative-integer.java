class Solution {
    public int maximumCount(int[] nums) {
        int p = 0;
        int n = 0;
        for(int a : nums) {
            if(a < 0) {
                n++;
            } else if(a > 0) {
                p++;
            }
        }
        return Math.max(p, n);
    }
}