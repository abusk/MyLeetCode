// class Solution {
//     public int maxEnvelopes(int[][] envelopes) {
//         Arrays.sort(envelopes, (a, b) -> a[0] - b[0]); 
//         int len = envelopes.length;
//         int dp[] = new int[len];
//         for(int i = 0; i<len; i++) {
//             dp[i] = 1;
//         }
//         for(int i = 0; i<len; i++) {
//             for(int j = i-1; j >=0; j--) {
//                 if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
//                     dp[i] = Math.max(dp[i], dp[j] +1);
//                 }
//             }
//         }
//         int max = 1;
//         for (int i = 0; i < len; i++) {
//             max = Math.max(max, dp[i]); 
//         }
//         return max;
//     }

// }

import java.util.*;

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        // Step 1: Sort envelopes (Width Ascending, Height Descending)
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int n = envelopes.length;
        int[] dp = new int[n]; // DP array to store LIS
        int length = 0; // Tracks max LIS length

        // Step 2: Perform LIS on heights using Binary Search
        for (int[] env : envelopes) {
            int height = env[1];

            // Find the position to replace using binary search
            int pos = Arrays.binarySearch(dp, 0, length, height);
            if (pos < 0) pos = -(pos + 1); // Get correct insertion index

            dp[pos] = height; // Place height at the correct position
            if (pos == length) length++; // Increase LIS length if needed
        }

        return length;
    }
}

