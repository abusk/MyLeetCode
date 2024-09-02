class Solution {
    public int passThePillow(int n, int time) {
        int pos = time % (n-1);
        int d = time / (n-1);
        if(d % 2 == 0) {
            return pos+1;
        } 
        return n - pos;
    }
}