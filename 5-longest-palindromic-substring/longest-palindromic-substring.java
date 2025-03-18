class Solution {
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean [][] dp = new boolean[len][len];
        int[] ans = new int[]{0, 0};
        for(int i = 0; i<len; i++) {
            dp[i][i] = true;
        }
        for(int i = 0; i<len-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                ans[0] = i;
                ans[1] = i+1;
            }
        }
        for(int i = 2; i<len; i++) {
            for(int start = 0; start < len - i; start++) {
                int end = start + i;
                if(s.charAt(start) == s.charAt(end) && dp[start+1][end-1]) {
                    dp[start][end] = true;
                    if(ans[1] - ans[0] < end - start) {
                        ans[0] = start;
                        ans[1] = end;
                    }
                }
            }
        }
        return s.substring(ans[0], ans[1]+1);
    }
    public static String dp(String s, int i, int j) {
        if(i > j) {
            return "";
        }
        if(isPal(s, i, j)) {
            return s.substring(i, j+1);
        }
        String p1 = dp(s, i+1, j);
        String p2 = dp(s, i, j-1);
        return p1.length() >= p2.length() ? p1 : p2;
    }
    public static boolean isPal(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}