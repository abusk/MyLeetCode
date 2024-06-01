class Solution {
    public int scoreOfString(String s) {
        int t = 0;
        for(int i = 1; i<s.length(); i++) {
            int a = s.charAt(i-1) - 'a';
            int b = s.charAt(i) - 'a';
            t += Math.abs(a-b);
        }
        return t;
    }
}