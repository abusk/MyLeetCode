class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = shortestPaths(n, edges);
        int small = n;
        int ans = 0;
        for(int i = 0; i<n; i++) {
            List<Integer> nei = new ArrayList<>();
            for(int j = 0; j<n; j++) {
                if(i != j && graph[i][j] <= distanceThreshold) {
                    nei.add(j);
                }
            }
            if(small >= nei.size()) {
                small = nei.size();
                ans = i;
            }
        }
        return ans;
    }

    public int[][] shortestPaths(int n, int[][] edges) {
        int[][] graph = new int[n][n];
        for(int i = 0; i<n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
        for(int[] edge : edges) {
            int r = edge[0];
            int c = edge[1];
            int w = edge[2];
            graph[r][c] = w;
            graph[c][r] = w;
        }
        for(int k = 0; k<n; k++) {
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<n; j++) {
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                    }
                }
            }
        }
        return graph;
    }
}