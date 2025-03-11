class Solution {
    public int numberOfSubstrings(String s) {
        int a = 0; 
        int b = 0;
        int c = 0;

        int len = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < len) {
            if(s.charAt(j) == 'a') {
                a++;
            } else if(s.charAt(j) == 'b') {
                b++;
            } else {
                c++;
            }
            while(a >= 1 && b >= 1 && c>=1) {
                ans+= len - j;
                if(s.charAt(i) == 'a') {
                    a--;
                } else if(s.charAt(i) == 'b') {
                    b--;
                } else {
                    c--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}