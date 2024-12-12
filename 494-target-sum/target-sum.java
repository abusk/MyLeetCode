// class Solution {
//     public int findTargetSumWays(int[] nums, int target) {
//         return dp(nums, target, 0);
//     }
//     public int dp(int[] nums, int target, int i) {
//         if(i == nums.length && target == 0 ) {
//             return 1;
//         }
//         if(i == nums.length && target != 0) {
//             return 0;
//         }

//         return dp(nums, target + nums[i], i+1) + dp(nums, target - nums[i], i+1);
//     }
// }

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int total = Arrays.stream(nums).sum();
        int dp[][] = new int[len][2 * total +1];
        dp[0][nums[0] + total] = 1;
        dp[0][-nums[0] + total] += 1;
        for(int i = 1; i < len; i++) {
            for(int s = -total; s <= total; s++) {
                if(dp[i-1][s + total] > 0) {
                    dp[i][s + nums[i] + total] += dp[i-1][s + total];
                    dp[i][s - nums[i] + total] += dp[i-1][s + total];
                }
            }
        }
        return Math.abs(target) > total ? 0 : dp[len -1][target + total];
    }
}
