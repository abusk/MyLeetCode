class Solution {
    public int minFlips(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s).append(s); // Duplicate `s` for cyclic shifts

        int alt1 = 0, alt2 = 0; // Counts for two alternating patterns
        int minFlips = Integer.MAX_VALUE;

        for (int i = 0; i < 2 * n; i++) {
            // Expected characters for both patterns
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            // Count flips for both alternating patterns
            if (sb.charAt(i) != expected1) alt1++;
            if (sb.charAt(i) != expected2) alt2++;

            // Maintain a sliding window of size `n`
            if (i >= n) {
                int j = i - n; // Outgoing character from the window
                if (sb.charAt(j) != ((j % 2 == 0) ? '0' : '1')) alt1--;
                if (sb.charAt(j) != ((j % 2 == 0) ? '1' : '0')) alt2--;
            }

            // Only consider windows of size `n`
            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(alt1, alt2));
            }
        }
        return minFlips;
    }
}
