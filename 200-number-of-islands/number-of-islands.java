class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dir = {{1,0}, {0,-1}, {-1, 0}, {0, 1}};
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    count += 1;
                    dfs(grid, i, j, dir);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j, int[][] dir) {
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }
        grid[i][j] = '2';
        for(int[] d : dir) {
            int nexti = i + d[0];
            int nextj = j + d[1];
            dfs(grid, nexti, nextj, dir);
        }
    }
}