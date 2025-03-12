class Solution {
    public static int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int [][] nei = {{-1,0}, {0, -1}, {1, 0}, {0, 1}};
        int peri = 0;
        for(int i = 0; i<row; i++) {
            for(int j = 0; j<col; j++) {
                if(grid[i][j] == 1) {
                    for(int[] ne : nei) {
                        int ni = i+ne[0];
                        int nj = j+ne[1];
                        if(ni < 0 || ni >= row || nj < 0 || nj >= col || grid[ni][nj] == 0) {
                            peri += 1;
                        }
                    }
                }
            }
        }
        return peri;
    }

    public static void main(String[] args) {
        //int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = {{1, 0}}; 
        System.out.println(islandPerimeter(grid));
    }
}