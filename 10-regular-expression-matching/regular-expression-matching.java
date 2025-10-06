class Solution {
    public boolean isMatch(String s, String p) {
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int i, int j) {
        boolean ans;
        if(j == p.length()) {
            ans = i == s.length();
        } else {
            boolean dotmatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
            if(j+1 < p.length() && p.charAt(j+1) == '*') {
                ans = (dp(s, p, i, j+2) || dotmatch && dp(s, p, i+1,j));
            } else {
                ans = dotmatch && dp(s, p, i+1, j+1);
            }
        }
        return ans;
    }
}