class Solution {
    public boolean validPalindrome(String s) {
        return dp(s, 0, s.length()-1, false);
    }
    public boolean dp(String s, int i, int j, boolean deleted) {
        if(i >= j) {
            return true;
        }
        if(deleted && s.charAt(i) != s.charAt(j)) {
            return false;
        }
        if(s.charAt(i) != s.charAt(j)) {
            return dp(s, i+1, j, true) || dp(s, i, j-1, true);
        }
        return dp(s, i+1, j-1, deleted);
    }
}