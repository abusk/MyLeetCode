class Solution {
    public int minimumOperations(int[][] grid) {
        int ops = 0;
        for(int c = 0; c<grid[0].length; c++) {
            int next = grid[0][c]+1;
            for(int r = 1; r < grid.length; r++) {
                int k = grid[r][c];
                if(k <= next) {
                    ops += (next - k);
                    next += 1;
                } else {
                    next = k+1;
                }
            }
        }
        return ops;
    }
}