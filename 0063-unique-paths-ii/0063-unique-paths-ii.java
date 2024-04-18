class Solution {
    public static int[][] grid = null;
    public static int m = 0;
    public static int n = 0;
    
    public int dp() {
        if(grid[0][0] == 1) {
            return 0;
        }
        grid[0][0] = 1;
        for(int i =1; i<m; i++) {
            grid[i][0] = (grid[i][0] == 0 && grid[i-1][0] == 1) ? 1 : 0;
        }
        for(int j =1; j<n; j++) {
            grid[0][j] = (grid[0][j] == 0 && grid[0][j-1] == 1) ? 1 : 0;
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j]  = grid[i-1][j] + grid[i][j-1];
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid[m-1][n-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid = obstacleGrid;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        return dp();
    }
}