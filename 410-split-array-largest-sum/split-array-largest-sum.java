class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        int[] prefixSum = new int[n + 1];

        // Compute prefix sum to optimize subarray sum calculation
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Fill dp with large value
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Base case: Only one subarray, so we take sum of all elements
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefixSum[i];
        }

        // DP computation
        for (int j = 2; j <= k; j++) {  // Iterate over partitions
            for (int i = 1; i <= n; i++) {  // Iterate over elements
                for (int p = 0; p < i; p++) {  // Iterate over possible split points
                    int maxSubarraySum = Math.max(dp[p][j - 1], prefixSum[i] - prefixSum[p]);
                    dp[i][j] = Math.min(dp[i][j], maxSubarraySum);
                }
            }
        }

        return dp[n][k]; // Return the minimized largest sum for `n` elements and `k` subarrays
    }
}
