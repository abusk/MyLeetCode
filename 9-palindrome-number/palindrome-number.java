class Solution {
    public boolean isPalindrome(int x) {
        int reverseNum = 0;
        int xx = x;
        while(x > 0) {
            int rem = x %10;
            reverseNum = reverseNum * 10 + rem;
            x = x/10;
        }
        if(xx == reverseNum) return true;
        else return false;
    }
}