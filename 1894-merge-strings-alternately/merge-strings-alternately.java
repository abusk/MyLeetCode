class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i< Math.min(word1.length(), word2.length()); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        String ss = sb.toString();
        if(word1.length() > word2.length()) {
            return ss + word1.substring(i);
        } else if(word1.length() < word2.length()) {
            return ss + word2.substring(i);
        }
        return ss;
    }
}