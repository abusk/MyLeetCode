class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int iLen = 1;
        int dLen = 1;
        int max = 1;
        for(int i = 1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                iLen++;
                dLen = 1;
            } else if(nums[i] < nums[i-1]) {
                dLen++;
                iLen = 1;
            } else {
                iLen =1;
                dLen =1;
            }
            max = Math.max(max, Math.max(iLen, dLen));
        }
        return max;
    }
}