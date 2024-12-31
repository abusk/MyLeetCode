class Solution {
    public int minChanges(String s) {
        int c = 0;
        int i =0;
        while(i < s.length() -1) {
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            if(a != b) {
                c++;
            }
            i = i+2;
        }
        return c;
    }
}