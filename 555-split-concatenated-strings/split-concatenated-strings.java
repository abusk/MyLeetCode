class Solution {
    public String splitLoopedString(String[] strs) {
    String stot = "";
    for (int i = 0; i < strs.length; i++) {
        String rever = new StringBuffer(strs[i]).reverse().toString();
        if (rever.compareTo(strs[i]) > 0) strs[i] = rever;
        stot = stot + strs[i];
    }
    int start = 0;
    String sol = stot;
    char maxch = 'a';
    for (int i = 0; i < strs.length; i++) {
        int n = strs[i].length();
        start += n;
        String rever = new StringBuffer(strs[i]).reverse().toString();
        String other_strs = stot.substring(start) + stot.substring(0, start - n);
        for (int j = 0; j < n; j++) {
            if (strs[i].charAt(j) - maxch >= 0) {
                maxch = strs[i].charAt(j);
                String s1 = strs[i].substring(j) + other_strs + strs[i].substring(0, j);
                String s2 = rever.substring(n-1-j) + other_strs + rever.substring(0, n-1-j);
                if (s1.compareTo(sol) > 0) sol = s1;
                if (s2.compareTo(sol) > 0) sol = s2;
            }
        }
    }    
    
    return sol;
}
}