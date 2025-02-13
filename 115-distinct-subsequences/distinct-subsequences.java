class Solution {
    public int numDistinct(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        int[][] dp = new int [sl+1][tl+1];
        for(int i = 0; i<=sl; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i<=sl; i++) {
            for(int j = 1; j<=tl; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sl][tl];
    }

    // public int dp(String s, String t, int i, int j) {
    //     if(j < 0) {
    //         return 1;
    //     }
    //     if(i < 0) {
    //         return 0;
    //     }

    //     if(s.charAt(i) == t.charAt(j)) {
    //         return dp(s, t, i-1, j-1) + dp(s, t, i-1, j);
    //     }
    //     return dp(s, t, i-1, j);
    // }
}