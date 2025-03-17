class Solution {
    int[][] dirs = {{1,0},{-1, 0}, {0,1}, {0,-1}};
    int m;
    int n;
    char[][] g;
    public int numIslands(char[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        int c = 0;
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(grid[i][j] == '1') {
                    c++;
                    dfs(i, j);
                }
            }
        }
        return c;
    }

    public void dfs(int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || g[i][j] == '0') {
            return;
        }
        g[i][j] = '0';
        for(int[] nst : dirs) {
            int nxtX = i + nst[0];
            int nxtY = j + nst[1];
            dfs(nxtX, nxtY);
        }
    }
}