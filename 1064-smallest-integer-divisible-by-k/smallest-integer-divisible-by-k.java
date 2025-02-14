class Solution {
    public int smallestRepunitDivByK(int k) {
        int remainder = 0;
        for (int length_N = 1; length_N <= k; length_N++) {
            remainder = (remainder * 10 + 1) % k;
            if (remainder == 0) {
                return length_N;
            }
        } 
        return -1;
    }
}