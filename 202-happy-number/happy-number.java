class Solution {
    public boolean isHappy(int n) {
        Set<Long> st = new HashSet<>();
        long ln = (long) n;
        while(ln !=1 && !st.contains(ln)) {
            st.add(ln);
            ln = getSquare(ln);
        }
        if(ln == 1) {
            return true;
        }
        return false;

    }
    public long getSquare(long n) {
        long sum = 0;
        while(n > 0) {
            long rem = n % 10;
            sum += rem * rem;
            n = n/10;
        }
        return sum;
    }
}