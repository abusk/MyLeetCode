class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int p :  prices) {
            if(p < min) {
                min = p;
                max = p;
            } else if(p > max) {
                max = p;
            }
            profit = Math.max(profit, max - min);
        }
        return profit;
    }
}