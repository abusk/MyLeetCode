class Solution {
    public boolean checkPowersOfThree(int n) {
        return recur(n, -1);
    }
    public boolean recur(int n, int p){
        if(n < 0) {
            return false;
        }
        if(n == 0) {
            return true;
        }
        boolean rs = false;
        for(int i = p+1;  (int)Math.pow(3, i)<= n; i++) {
            rs = rs || recur(n - (int)Math.pow(3, i), i);
        }
        return rs;
    }
}