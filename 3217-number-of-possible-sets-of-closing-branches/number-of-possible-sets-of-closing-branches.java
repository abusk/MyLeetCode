class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int res = 0;

        for (int i = 1; i < (1 << n); i++) {
            List<Integer> connected = new ArrayList<>();
            int[][] dist = new int[n][n];

            for (int[] a : dist) Arrays.fill(a, (int)1e9);

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) connected.add(j);
            }

            for (int j = 0; j < n; j++) dist[j][j] = 0;

            for (int[] road : roads) {
                int u = road[0], v = road[1], d = road[2];
                if ((i & (1 << u)) != 0 && (i & (1 << v)) != 0) {
                    dist[u][v] = dist[v][u] = Math.min(d, dist[u][v]);
                }
            }

            for (int k1 = 0; k1 < n; k1++) {
                for (int k2 = 0; k2 < n; k2++) {
                    for (int k3 = 0; k3 < n; k3++) {
                        dist[k2][k3] = Math.min(dist[k2][k3], dist[k2][k1] + dist[k1][k3]);
                    }
                }
            }

            int isFeasible = 1;

            for (int v1 : connected) {
                for (int v2 : connected) {
                    if (dist[v1][v2] > maxDistance) {
                        isFeasible = 0;
                        break;
                    }
                }
            }

            res += isFeasible;
        }   

        return res + 1;
    }
}