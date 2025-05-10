class Solution {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length()-1, 1);
    }
    public boolean check(String s, int i, int j, int c) {
        if(i >= j) {
            return true;
        }
        if(s.charAt(i) == s.charAt(j)) {
            return check(s, i+1, j-1, c);
        }
        if(s.charAt(i) != s.charAt(j) &&  c <= 0) {
            return false;
        }
        return check(s, i+1, j, c-1) || check(s, i, j-1, c-1);
    }
}