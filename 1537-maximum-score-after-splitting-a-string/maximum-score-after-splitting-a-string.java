class Solution {
    public int maxScore(String s) {
        int right = totalOne(s);
        int left = 0;
        if(s.charAt(0) == '0') {
            left += 1;
        } else {
            right -= 1;
        }
        int ans = left + right;

        for(int i= 1; i < s.length()-1; i++) {
            if(s.charAt(i) == '0') {
                left += 1;
            } else {
                right -= 1;
            }
            ans = Math.max(ans, left + right);
        }
        return ans;
    }
    public int totalOne(String s) {
        int c = 0;
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '1') {
                c++;
            }
        }
        return c;
    }
}