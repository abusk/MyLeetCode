class Solution {
    public int minFallingPathSum(int[][] grid) {
        // Initialize a two-dimensional array to cache the result of each sub-problem
        int[][] memo = new int[grid.length][grid.length];

        // Fill the base case
        for (int col = 0; col < grid.length; col++) {
            memo[grid.length - 1][col] = grid[grid.length - 1][col];
        }

        // Fill the recursive cases
        for (int row = grid.length - 2; row >= 0; row--) {
            for (int col = 0; col < grid.length; col++) {
                // Select minimum from valid cells of next row
                int nextMinimum = Integer.MAX_VALUE;
                for (int nextRowCol = 0; nextRowCol < grid.length; nextRowCol++) {
                    if (nextRowCol != col) {
                        nextMinimum = Math.min(nextMinimum, memo[row + 1][nextRowCol]);
                    }
                }

                // Minimum cost from this cell
                memo[row][col] = grid[row][col] + nextMinimum;
            }
        }

        // Find the minimum from the first row
        int answer = Integer.MAX_VALUE;
        for (int col = 0; col < grid.length; col++) {
            answer = Math.min(answer, memo[0][col]);
        }

        // Return the answer
        return answer;
    }
}