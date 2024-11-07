class Solution {
    public int longestRepeatingSubstring(String s) {
        int l = s.length();
        String [] suffixArray = new String[l];
        for(int i= 0; i<l; i++) {
            suffixArray[i] = s.substring(i);
        }
        Arrays.sort(suffixArray);
        int maxlen = 0;
        for(int i= 1; i<l; i++) {
            int j = 0;
            while(j < Math.min(suffixArray[i].length(), suffixArray[i-1].length()) 
            && suffixArray[i].charAt(j) == suffixArray[i-1].charAt(j)) {
                j++;
            }
            maxlen = Math.max(maxlen, j);
        }
        return maxlen;
    }
}