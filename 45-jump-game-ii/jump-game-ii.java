class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];  
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int maxJump = Math.min(i + nums[i], n - 1);
            for (int j = i + 1; j <= maxJump; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[0];
    }
}
