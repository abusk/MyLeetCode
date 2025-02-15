class Solution {
    public int punishmentNumber(int n) {
        int sum = 0;
        for(int i = 1; i<= n; i++) {
            int sq = i * i;
            if(recur(sq, i)) {
                sum += sq;
            }
        }
        return sum;
    }

    public boolean recur(int sq, int num){
        if(sq == num) {
            return true;
        }
        if(num < 0) {
            return false;
        }
        boolean res = false;
        for(int i = 10; i <= sq; i*=10) {
            res = res || recur(sq / i, num - sq % i);
        }
        return res;
    }
}