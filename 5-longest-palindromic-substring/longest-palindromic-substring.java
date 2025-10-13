class Solution {
    public String longestPalindrome(String s) {
        // Map<String, Boolean> memo = new HashMap<>();
        // int maxL = -1;
        // String ans = "";
        // for(int j = 0; j <s.length(); j++) {
        //     for(int i = 0; i <= j; i++) {
        //         if(dp(s, i, j, memo)) {
        //             if(maxL < j - i) {
        //                 maxL = j-i;
        //                 ans = s.substring(i, j+1);
        //             }
        //         }
        //     }
        // }
        // return ans;
        int maxL = 1;
        int start = 0;
        int end = 0;
        boolean [][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i<s.length(); i++) {
            dp[i][i] = true;
        }
        for(int i = 0; i<s.length()-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                maxL = 2;
                start = i;
                end = i+1;
                dp[i][i+1] = true;
            } else {
                dp[i][i+1] =false;
            }
        }
        for(int w = 2; w<s.length(); w++) {
            for(int i = 0; i<s.length()-w; i++) {
                int j = i + w;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    if(maxL < w+1) {
                        start = i;
                        end = j;
                        maxL = w+1;
                    }
                    dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(start, end+1);
    }

    // public boolean dp(String s, int i, int j, Map<String, Boolean> memo) {
    //     String key = i + ":" + j;
    //     if(memo.containsKey(key)) {
    //         return memo.get(key);
    //     }
    //     if(i < 0 || j >= s.length()) {
    //         return false;
    //     }
    //     if(i == j) {
    //         return true;
    //     }
    //     if(i+1 == j && s.charAt(i) == s.charAt(j)) {
    //         return true;
    //     }
    //     boolean result = false;
    //     if(s.charAt(i) != s.charAt(j)) {
    //         result = false;
    //     } else {
    //         result =  dp(s, i+1, j-1, memo);
    //     }
    //     memo.put(key, result);
    //     return result;
    // }
}