class Solution {
    public void reverseWords(char[] s) {
        swap(s, 0, s.length);
        int start = 0;
        for(int i= 0; i<s.length; i++) {
            if(s[i] == ' ' || i == s.length-1) {
                swap(s, start, i);
                start = i+1;
            }
        }
    }
    public void swap(char[] s, int start, int end) {
        if(end != s.length-1) {
            end -=1;
        }
        while(start <= end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}