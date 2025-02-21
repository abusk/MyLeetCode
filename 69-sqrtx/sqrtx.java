class Solution {
    public int mySqrt(int x) {
        if(x <= 1) {
            return x;
        }
        return bs(x);
    }
    public int bs(int x) {
        int s = 2;
        int e = x /2;
        while (s <= e) {
            int mid = s + (e-s)/2;
            long num = (long) mid * mid;
            if(num == x) {
                return mid;
            }
            if(num > x) {
                e = mid -1;
            } else {
                s = mid + 1;
            }
        }
        return e;
    }
}