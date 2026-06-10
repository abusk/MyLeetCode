class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int start = Math.max(1, n-k);
        int end = n + k;
        int sum = 0;
        for( int i = start; i<= end; i++) {
            int and = n & i;
            if(and == 0) {
                sum += i;
            }
        }
        return sum;
    }
}