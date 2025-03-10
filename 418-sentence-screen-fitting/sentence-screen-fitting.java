class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int i = 0;
        int ans = 0;
        for(int r = 0; r < rows; r++) {
            int c = 0;
            while(c + sentence[i].length() <= cols) {
                c += sentence[i].length() +1;
                i += 1;
                if(i == sentence.length) {
                    ans++;
                    i = 0;
                }
            }
        }
        return ans;
    }
}