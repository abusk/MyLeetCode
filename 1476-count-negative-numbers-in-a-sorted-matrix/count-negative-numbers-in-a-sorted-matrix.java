class Solution {
    public int countNegatives(int[][] grid) {
        int c = grid[0].length;
        int r = grid.length;
        int i = 0;
        int total = c*r;
        int j = c -1;
        while (j >= 0 && i < r) {
            if(grid[i][j] >= 0) {
                total -= (j +1);
                i++;
            } else {
                j--;
            }
        }
        return total;
    }
}