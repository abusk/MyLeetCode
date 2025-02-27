class Solution {

    public int lenLongestFibSubseq(int[] arr) {
        int maxLen = 0;
        // dp[prev][curr] stores length of Fibonacci sequence ending at indexes prev,curr
        int[][] dp = new int[arr.length][arr.length];

        // Map each value to its index for O(1) lookup
        Map<Integer, Integer> valToIdx = new HashMap<>();

        // Fill dp array
        for (int curr = 0; curr < arr.length; curr++) {
            valToIdx.put(arr[curr], curr);

            for (int prev = 0; prev < curr; prev++) {
                // Find if there exists a previous number to form Fibonacci sequence
                int diff = arr[curr] - arr[prev];
                int prevIdx = valToIdx.getOrDefault(diff, -1);

                // Update dp if valid Fibonacci sequence possible
                // diff < arr[prev] ensures strictly increasing sequence
                if (diff < arr[prev] && prevIdx >= 0) {
                    dp[prev][curr] = dp[prevIdx][prev] + 1;
                } else {
                    dp[prev][curr] = 2;
                }

                maxLen = Math.max(maxLen, dp[prev][curr]);
            }
        }

        // Return 0 if no sequence of length > 2 found
        return maxLen > 2 ? maxLen : 0;
    }
}