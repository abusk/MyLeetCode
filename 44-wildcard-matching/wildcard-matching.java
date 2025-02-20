class Solution {
    public boolean isMatch(String s, String p) {
        int sl = s.length(); 
        int pl = p.length();
        boolean dp[][] = new boolean[sl+1][pl+1];

        dp[0][0] = true;
        for(int j = 1; j<=pl; j++) {
            if(p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        for(int i = 1; i<=sl; i++) {
            for(int j = 1; j<=pl; j++) {
                if((p.charAt(j-1) == '?') || (p.charAt(j-1) == s.charAt(i-1))) {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
            }
        }
        return dp[sl][pl];

    }
    // public boolean dp(String s, String p, int i, int j) {
    //     if(i == s.length() && j == p.length()) {
    //         return true;
    //     }
    //     if(j == p.length()) {
    //         return false;
    //     }
    //     if (i == s.length()) {
    //         while (j < p.length() && p.charAt(j) == '*') j++;
    //         return j == p.length();
    //     }

    //     if((p.charAt(j) == '?') || (p.charAt(j) == s.charAt(i))) {
    //         return dp(s, p, i+1, j+1);
    //     }

    //     if(p.charAt(j) == '*') {
    //         return dp(s, p, i+1, j) || dp(s, p, i, j+1);
    //     }
    //     return false;
    // }
}