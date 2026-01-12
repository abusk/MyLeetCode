class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for(int i = 1; i <points.length; i++) {
            int[] p0 = points[i-1];
            int[] p1 = points[i];
            ans += Math.max(Math.abs(p0[0] -p1[0]), Math.abs(p0[1] - p1[1]));
        }
        return ans;
    }
}