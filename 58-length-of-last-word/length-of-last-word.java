class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        for(int i = split.length-1; i>=0; i--) {
            String w = split[i];
            if(w.length() > 0) {
                return w.length();
            }
        }
        return 0;
    }
}