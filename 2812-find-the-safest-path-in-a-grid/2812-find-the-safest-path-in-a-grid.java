class Solution {

    // Directions for moving to neighboring cells: right, left, down, up
    final int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] mat = new int[n][n];
        Queue<int[]> multiSourceQueue = new LinkedList<>();

        // To make modifications and navigation easier, the grid is converted into a 2-d array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    // Push thief coordinates to the queue
                    multiSourceQueue.add(new int[] {i, j});
                    // Mark thief cell with 0
                    mat[i][j] = 0;
                } else {
                    // Mark empty cell with -1
                    mat[i][j] = -1;
                }
            }
        }

        // Calculate safeness factor for each cell using BFS
        while (!multiSourceQueue.isEmpty()) {
            int size = multiSourceQueue.size();
            while (size-- > 0) {
                int[] curr = multiSourceQueue.poll();
                // Check neighboring cells
                for (int[] d : dir) {
                    int di = curr[0] + d[0];
                    int dj = curr[1] + d[1];
                    int val = mat[curr[0]][curr[1]];
                    // Check if the neighboring cell is valid and unvisited
                    if (isValidCell(mat, di, dj) && mat[di][dj] == -1) {
                        // Update safeness factor and push to the queue
                        mat[di][dj] = val + 1;
                        multiSourceQueue.add(new int[] {di, dj});
                    }
                }
            }
        }

        // Priority queue to prioritize cells with higher safeness factor
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        // Push starting cell to the priority queue
        pq.add(new int[] {0, 0, mat[0][0]}); // [x-coordinate, y-coordinate, maximum_safeness_till_now]
        mat[0][0] = -1; // Mark the source cell as visited

        // BFS to find the path with maximum safeness factor
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            // If reached the destination, return safeness factor
            if (curr[0] == n - 1 && curr[1] == n - 1) {
                return curr[2];
            }
            // Explore neighboring cells
            for (int[] d : dir) {
                int di = d[0] + curr[0];
                int dj = d[1] + curr[1];
                if (isValidCell(mat, di, dj) && mat[di][dj] != -1) {
                    // Update safeness factor for the path and mark the cell as visited
                    pq.add(new int[] {di, dj, Math.min(curr[2], mat[di][dj])});
                    mat[di][dj] = -1;
                }
            }
        }

        return -1; // No valid path found
    }

    // Check if a given cell lies within the grid
    private boolean isValidCell(int[][] mat, int i, int j) {
        int n = mat.length;
        return i >= 0 && j >= 0 && i < n && j < n;
    }
}