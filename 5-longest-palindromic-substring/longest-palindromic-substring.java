class Solution {
    public static String longestPalindrome(String s) {
        String ans = "";
        for(int i = 0; i<s.length(); i++) {
            int[] odd = dp(s, i, i);
            int st = odd[0], en = odd[1];
            if(en - st + 1 > ans.length()) {
                ans = s.substring(st, en+1);
            }
        }
        for(int i = 0; i<s.length()-1; i++) {
            int[] even = dp(s, i, i+1);
            int st = even[0], en = even[1];
            if(en - st + 1 > ans.length()) {
                ans = s.substring(st, en+1);
            }
        }
        return ans;
    }
    public static int[] dp(String s, int i, int j) {
        if(i < 0 || j >= s.length()) {
            return new int[] {i+1, j-1};
        }
        if(s.charAt(i) != s.charAt(j)) {
            return new int[]{i+1, j-1};
        }
        if(s.charAt(i) == s.charAt(j)) {
            return dp(s, i-1, j+1);
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}