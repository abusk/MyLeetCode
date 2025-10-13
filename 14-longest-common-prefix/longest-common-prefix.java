class Solution {
    public String longestCommonPrefix(String[] strs) {
        int mLen = Integer.MAX_VALUE;
        for(String s : strs) {
            if(s.length() < mLen) {
                mLen = s.length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<mLen; i++) {
            char nch = ' ';
            for(String s : strs) {
                char sch = s.charAt(i);
                if(nch == ' ') {
                    nch = sch;
                } else if(nch != sch) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}