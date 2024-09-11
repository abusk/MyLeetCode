class Solution {
    public int minBitFlips(int start, int goal) {
        int c = 0;
        while (start > 0 || goal > 0) {
            int f = start & 1;
            int g = goal & 1;
            int r = f ^ g;
            if(r > 0) {
                c++;
            }
            start = start >> 1;
            goal = goal >> 1;
        }
        return c;
    }
}