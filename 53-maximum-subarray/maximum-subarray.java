class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                break;
            } else {
               maxSum = Math.max(maxSum, nums[i]); 
            }
        }
        
        int lsum = 0;
        for(int i = 0; i<nums.length; i++) {
            lsum += nums[i];
            if(lsum < 0) {
                lsum = 0;
            } else {
                maxSum = Math.max(maxSum, lsum);
            }
        }
        return maxSum;
    }
}