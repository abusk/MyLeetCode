class Solution {
    int memo[][];
    public boolean stoneGame(int[] piles) {
        memo = new int[piles.length][piles.length];
        int start = 0;
        int end = piles.length-1;
        int sum = Arrays.stream(piles).sum();
        int alice = dp(piles, start, end);
        if(alice > sum -alice) {
            return true;
        }
        return false;
        // int len = piles.length;
        // int dp[][] = new int[len][len];
        // for(int i = 0; i < len; i++) {
        //     dp[i][i+1] = Math.max(piles[i], piles[i+1]);
        // }
        // for(int i = 0; i<len; i++) {
        //     for(int j = len-1; j>=0; j--) {
        //         if(i < j) {
        //             int fromStart = piles[i] + Math.max(dp[i+2][j], dp[i+1][j-1]);
        //             int fromEnd = piles[j] + Math.max(dp[i][j-2], dp[i+1][j-1]);
        //             dp[i][j] = Math.max(fromStart, fromEnd);
        //         }
        //     }
        // }
        // return 0;
    }
    public int dp(int[] piles, int start, int end) {

        if(start > end) {
            return 0;
        }
        if(memo[start][end] > 0) {
            return memo[start][end];
        }
        if(end - start == 1) {
            memo[start][end] = Math.max(piles[start], piles[end]);
            return memo[start][end];
        }
        memo[start][end] = Math.max(piles[start] + Math.max(dp(piles, start+2, end), dp(piles, start+1, end -1)), 
        piles[end] + Math.max(dp(piles, start, end-2), dp(piles, start+1, end-1)));
        return memo[start][end];
    }
}