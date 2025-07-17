class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[k][k];
        int res = 0;
        for(int num : nums) {
            num %= k;
            for(int r = 0; r < k; r++) {
                dp[r][num] = dp[num][r] + 1;
                res = Math.max(res, dp[r][num]);
            }
        }
        return res;
    }
}