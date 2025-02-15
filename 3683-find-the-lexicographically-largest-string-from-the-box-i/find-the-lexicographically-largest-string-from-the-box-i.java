class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) {
            return word;
        }
        int w = word.length() - (numFriends -1);
        int idx = 0;
        char ch = 'a';
        String max = "";
        for(int i = 0; i<word.length(); i++) {
            if(word.charAt(i)>= ch) {
                idx = i;
                ch = word.charAt(i);
                String ss = word.substring(idx, Math.min(idx+w, word.length()));
                if(ss.compareTo(max) > 0) {
                    max = ss;
                }
            }
        }
        return max;
        // String max = "";

        // for(int l = w; l >= 1; l--) {
        //     for(int i = 0; i<=word.length() - l; i++) {
        //         String ss = word.substring(i, i+l);
        //         if(ss.compareTo(max) > 0) {
        //             max = ss;
        //         }
        //     }
        // }
        // return max;
    }
}