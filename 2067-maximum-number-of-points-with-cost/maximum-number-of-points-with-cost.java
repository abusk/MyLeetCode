class Solution {
    public long maxPoints(int[][] points) {
        int rl = points.length;
        int cl = points[0].length;
        long [][] res = new long[rl][cl];
        for(int i =0; i<cl; i++) {
            res[0][i] = points[0][i];
        }
        for(int i = 1; i<rl; i++) {
            for(int j = 0; j<cl; j++) {
                long max = Long.MIN_VALUE;
                for(int k = 0; k< cl; k++ ){
                    long point = points[i][j] + res[i-1][k] - Math.abs(k -j);
                    max = Math.max(max, point);
                }
                res[i][j] = max;
            }
        }
        long ans = Long.MIN_VALUE;
        for(int i = 0; i<cl; i++) {
            ans = Math.max(res[rl-1][i], ans);
        }
        return ans;
    }
}