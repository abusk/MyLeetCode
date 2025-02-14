class Solution {
    public int numWays(String[] words, String target) {
        //return dp(words, target, 0, 0);
        int mod = 1000000007;
        int wl = words[0].length();
        int tl = target.length();

        int[][] cf = new int[wl][26];
        for (String word : words) {
            for (int j = 0; j < wl; ++j) {
                cf[j][word.charAt(j) - 'a']++;
            }
        }

        long dp[][] = new long[wl+1][tl+1];
        for(int i = 0; i <= wl; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i<=wl; i++) {
            for(int j = 1; j<=tl; j++) {
                dp[i][j] = dp[i-1][j];
                int curPos = target.charAt(j - 1) - 'a';
                dp[i][j] +=
                    (cf[i - 1][curPos] *
                        dp[i - 1][j - 1]) % mod;
                dp[i][j] %= mod;
            }
        }
        return (int)dp[wl][tl];
    }
    // public int dp(String[] words, String target, int i, int j) {
    //     if(j == target.length()) {
    //         return 1;
    //     }
    //     if(i >= words[0].length()) {
    //         return 0;
    //     }
    //     int notTake = dp(words, target, i+1, j);
    //     int take = 0;
    //     for(int k = 0; k < words.length; k++) {
    //         if(target.charAt(j) == words[k].charAt(i)) {
    //              take += dp(words, target, i+1, j+1);
    //         }
    //     }
    //     return notTake + take;
    // }
}