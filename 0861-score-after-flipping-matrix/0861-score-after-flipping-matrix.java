class Solution {
    public int matrixScore(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        for(int i = 0; i < r; i++) {
            if(grid[i][0] == 0) {
                for(int j =0; j < c; j++){
                    grid[i][j] = 1 ^ grid[i][j];
                }
            }
        }
        for(int j = 1; j < c; j++) {
            if(count(grid, j)) {
                for(int i =0; i < r; i++){
                    grid[i][j] = 1 ^ grid[i][j];
                }
            }
        }
        int total = 0;
        for(int i = 0; i<r; i++) {
            total += getSum(grid, i);
        }
        return total;
    }
    public boolean count(int [][] grid, int j) {
        int z = 0;
        int on = 0;
        for(int i = 0; i< grid.length; i++){
            if(grid[i][j] == 0) {
                z++;
            } else {
                on++;
            }
        }
        return z > on;
    }
    
    public int getSum(int [][] grid, int i) {
        int s = 0;
        int c = grid[0].length;
        for(int j = 0; j<c; j++) {
           s += (grid[i][j] * Math.pow(2, c-j-1));
        }
        return s;
    }
}