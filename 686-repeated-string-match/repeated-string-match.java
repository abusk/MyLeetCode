class Solution {
    public int repeatedStringMatch(String a, String b) {
        int r = (int)Math.ceil((double)b.length() / a.length());
        String ra = a.repeat(r);
        if(kmp(ra, b)) {
            return r;
        }
        ra += a;
        if(kmp(ra, b)) {
            return r+1;
        }
        return -1;
    }
    public boolean kmp(String a, String b) {
        int lps[] = getLPS(b);
        int i = 0;
        int j = 0;
        while(i < a.length()) {
            if(a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
                if(j == b.length()) {
                    return true;
                }
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    public int[] getLPS(String b) {
        int m = b.length();
        int [] lps = new int[m];
        lps[0] = 0;
        int len =0;
        int i=1;
        while(i < m) {
            if(b.charAt(i) == b.charAt(len)) {
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
        return lps;
    }
}