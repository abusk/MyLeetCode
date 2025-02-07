class Solution {
    public int lengthOfLIS(int[] nums) {

        int dp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j <i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}