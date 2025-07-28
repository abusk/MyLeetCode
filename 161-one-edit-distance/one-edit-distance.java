class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if((t.length() == 0 && s.length() == 1) || s.length() == 0 && t.length() == 1) {
            return true;
        }
        return dp(s, t, 0, 0, 1);
    }
    public boolean dp(String s, String t, int i, int j, int c) {
        if(i == s.length() && j == t.length() && c == 0) {
            return true;
        }
        if((i == s.length() && j == t.length()-1 && c > 0)) {
            return true;
        }
        if((i == s.length()-1 && j == t.length() && c > 0)) {
            return true;
        }
        if((i >= s.length() || j >= t.length())) {
            return false;
        }
        if(c < 0) {
            return false;
        }

        if(s.charAt(i) == t.charAt(j)) {
            return dp(s, t, i+1, j+1, c);
        }
        boolean insert = dp(s, t, i, j+1, c-1);
        boolean delete = dp(s, t, i+1, j, c-1);
        boolean replace = dp(s, t, i+1, j+1, c-1);
        return insert || delete || replace;
    }
}