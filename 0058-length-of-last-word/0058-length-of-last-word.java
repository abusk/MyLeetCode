class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.length()-1;
        while(s.charAt(j) == ' ') {
            j--;
        }
        int c = 0;
        for(int i = j; i>=0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            c++;
        }
        return c;
    }
}