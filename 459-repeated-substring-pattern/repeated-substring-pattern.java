class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int m = s.length();
        int lps[] = new int[m];
        int len =0;
        lps[0] = 0;
        int i = 1;
        while(i < m) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len != 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        int lp = lps[m-1];
        int lenthOfSubstring = m - lp;
        if(lp > 0 && m % lenthOfSubstring == 0) {
            return true;
        } else {
            return false;
        }
    }
}