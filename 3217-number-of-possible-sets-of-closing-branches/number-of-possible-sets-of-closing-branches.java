// class Solution {
//     public int numberOfSets(int n, int maxDistance, int[][] roads) {
//         int res = 0;

//         for (int i = 1; i < (1 << n); i++) {
//             List<Integer> connected = new ArrayList<>();
//             int[][] dist = new int[n][n];

//             for (int[] a : dist) Arrays.fill(a, (int)1e9);

//             for (int j = 0; j < n; j++) {
//                 if ((i & (1 << j)) != 0) connected.add(j);
//             }

//             for (int j = 0; j < n; j++) dist[j][j] = 0;

//             for (int[] road : roads) {
//                 int u = road[0], v = road[1], d = road[2];
//                 if ((i & (1 << u)) != 0 && (i & (1 << v)) != 0) {
//                     dist[u][v] = dist[v][u] = Math.min(d, dist[u][v]);
//                 }
//             }

//             for (int k1 = 0; k1 < n; k1++) {
//                 for (int k2 = 0; k2 < n; k2++) {
//                     for (int k3 = 0; k3 < n; k3++) {
//                         dist[k2][k3] = Math.min(dist[k2][k3], dist[k2][k1] + dist[k1][k3]);
//                     }
//                 }
//             }

//             int isFeasible = 1;

//             for (int v1 : connected) {
//                 for (int v2 : connected) {
//                     if (dist[v1][v2] > maxDistance) {
//                         isFeasible = 0;
//                         break;
//                     }
//                 }
//             }

//             res += isFeasible;
//         }   

//         return res + 1;
//     }
// }
public class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;

        // Total number of possible subsets with n nodes = 2^n = (1 << n) = Math.pow(2, n)
        for (int set = 0; set < (1 << n); set++) {
            // Create an adjacency matrix to represent the graph
            int[][] grid = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    grid[j][k] = 1_000_000_000; // Initialize with a large value
                }
            }

            // Update the graph based on the selected nodes in the subset
            for (int[] it : roads) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                if ((set >> u & 1) == 1 && (set >> v & 1) == 1) {
                    grid[u][v] = Math.min(grid[u][v], wt);
                    grid[v][u] = Math.min(grid[v][u], wt);
                }
            }

            // Set diagonal elements to 0
            for (int j = 0; j < n; j++) {
                grid[j][j] = 0;
            }

            // Floyd-Warshall algorithm for finding the shortest paths
            for (int via = 0; via < n; via++) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        grid[x][y] = Math.min(grid[x][y], grid[x][via] + grid[via][y]);
                    }
                }
            }

            // Check if the current subset forms a valid set
            boolean ok = true;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;

                    if ((set >> j & 1) == 1 && (set >> k & 1) == 1) {
                        if (grid[j][k] > maxDistance) {
                            ok = false;
                            break;
                        }
                    }
                }
            }

            // Increment the answer if the subset was valid
            ans += ok ? 1 : 0;
        }
        return ans;
    }
}