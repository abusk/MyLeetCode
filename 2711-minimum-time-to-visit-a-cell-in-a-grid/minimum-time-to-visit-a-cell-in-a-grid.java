// class Solution {
//     public int minimumTime(int[][] grid) {
//         int[][] dp = new int[grid.length][grid[0].length];
//         if(grid[0][0] != 0 || (grid[1][0] > 1 && grid[0][1] > 1)) {
//             return -1;
//         }
//         dp[0][0] = 0;
//         if(grid[0][1] <= 1) {
//             dp[0][1] = 1;
//             for(int i = 2; i<grid[0].length; i++) {
//                 dp[0][i] = grid[0][i] > dp[0][i-1] +1 ? grid[0][i]+1 : dp[0][i-1] +1;
//             }
//         } else {
//             for(int i = 1; i<grid[0].length; i++) {
//                 dp[0][i] = Integer.MAX_VALUE;
//             }
//         }
//         if(grid[1][0] <= 1) {
//             dp[1][0] = 1;
//             for(int i = 2; i<grid.length; i++) {
//                 dp[i][0] = grid[i][0] > dp[i-1][0] +1 ? grid[i][0]+1 : dp[i-1][0] +1;
//             }
//         } else {
//             for(int i = 1; i<grid.length; i++) {
//                 dp[i][0] = Integer.MAX_VALUE;
//             }
//         }
//         for(int i = 1; i < grid.length; i++) {
//             for(int j = 1; j<grid[0].length; j++) {
//                 int min = Math.min(dp[i-1][j], dp[i][j-1]);
//                 if(grid[i][j] > min+1) {
//                     if((grid[i][j] - min) % 2 == 0) {
//                         dp[i][j] = grid[i][j] +1;
//                     } else {
//                         dp[i][j] = grid[i][j];
//                     }
//                 } else {
//                     dp[i][j] = min+1;
//                 }
//             }
//         }
//         return dp[grid.length-1][grid[0].length-1];
//     }
// }

class Solution {
    private static final int[][] DIRS = new int[][] { { 1, 0 }, { -1, 0}, { 0, 1 }, { 0, -1 } };
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[] { 0, 0, 0 }); // row, col, time
        
        boolean[][] visited = new boolean[m][n];
        
        while (!heap.isEmpty()) {
            int[] entry = heap.poll();
            int row = entry[0];
            int col = entry[1];
            int time = entry[2];
            if (row == m - 1 && col == n - 1) {
                return time;
            }
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
                
            for (int[] dir : DIRS) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r < 0 || r == m || c < 0 || c == n || visited[r][c]) {
                    continue;
                }
                
                if (grid[r][c] <= time + 1) {
                    // if it is possible to move to neighbor, do it
                    heap.offer(new int[] { r, c, time + 1 });
                } else {
                    // If we cant move to neighbor yet, we can hop to the previous cell
                    // and back to current cell as many times as we need to until
                    // sufficient time has passed.
                    // The trick here is that if the difference between the current time
                    // and the time we need is even, we will arrive back at the current cell
                    // 1 second "late" and so we will move to the neighbor 1 second after
                    // the minimum neighbor time.
                    int diff = grid[r][c] - time;
                    if (diff % 2 == 1) {
                        heap.offer(new int[] { r, c, grid[r][c] });
                    } else {
                        heap.offer(new int[] { r, c, grid[r][c] + 1 });
                    }
                }
            }
        }
        return -1; // will never reach here
    }
}