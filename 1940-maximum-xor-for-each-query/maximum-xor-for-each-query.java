class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int len = nums.length;
        long [] xors = new long[len];
        xors[0] = nums[0];
        for(int i = 1; i<len; i++) {
            xors[i] = nums[i] ^ xors[i-1];
        }
        long max = (long) Math.pow(2, maximumBit) -1;
        int ans[] = new int[len];
        for(int i = len-1; i>=0; i--) {
            ans[len-1 -i] = (int) (xors[i] ^ max);
        }
        return ans;
    }
}