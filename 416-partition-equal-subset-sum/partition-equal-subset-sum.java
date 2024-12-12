class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if(total % 2 == 1) {
            return false;
        }
        int sum = total / 2;
        int len = nums.length;
        boolean dp[][] = new boolean[len+1][sum +1];
        dp[0][0] = true;
        for(int i = 1; i <= len; i++) {
            for(int w = 0; w <= sum; w++) {
                if(w < nums[i-1]){
                    dp[i][w] = dp[i-1][w];
                } else {
                    dp[i][w] = dp[i-1][w - nums[i-1]] || dp[i-1][w];
                }
            }
        }
        return dp[len][sum];
        //return dp(nums, total / 2, 0);
    }
    // public boolean dp(int[] nums, int target, int i) {
    //     if(target == 0) {
    //         return true;
    //     }
    //     if(i == nums.length) {
    //         return false;
    //     }
    //     return dp(nums, target - nums[i], i+1) || dp(nums, target, i+1);
    // }
}