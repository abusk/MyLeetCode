class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((p , q) -> (p[0] - q[0]));
        boolean isMST[] = new boolean[n];
        int minCost = 0;
        int edgesUsed = 0;

        pq.offer(new int[]{0, 0});

        while(edgesUsed < n) {
            int[] top = pq.poll();
            int cur = top[1];
            int weight = top[0];

            if(isMST[cur]) {
                continue;
            }
            minCost += weight;
            isMST[cur] = true;
            edgesUsed++;

            for(int j = 0; j<n; j++) {
                if(!isMST[j]) {
                    int c = Math.abs(points[cur][0] - points[j][0]) + Math.abs(points[cur][1] - points[j][1]);
                    pq.offer(new int[]{c, j});
                }
            }
        }
        return minCost;
    }
}