class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dp(nums, target, 0);
    }
    public int dp(int[] nums, int target, int i) {
        if(i == nums.length && target == 0 ) {
            return 1;
        }
        if(i == nums.length && target != 0) {
            return 0;
        }

        return dp(nums, target + nums[i], i+1) + dp(nums, target - nums[i], i+1);
    }
}

// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         int len = nums.length;
//         int dp[][] = new int[len][target+1];
//         for(int i = 0; i < len; i++) {
//             dp[i][0] = 0;
//         }
//     }
// }
