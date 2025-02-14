class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[] plus = new int[len];
        int [] minus = new int[len];
        for(int i = 0; i < len; i++) {
            plus[i] = values[i] + i;
            minus[i] = values[i] - i;
        }
        int mplus = plus[0];
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<len; i++) {
            max = Math.max(max, minus[i] + mplus);
            mplus = Math.max(mplus, plus[i]);
        }
        return max;
    }
}