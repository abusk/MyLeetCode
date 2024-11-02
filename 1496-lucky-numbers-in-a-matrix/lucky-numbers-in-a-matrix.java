class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<matrix.length; i++) {
            int c = minRow(matrix, i);
            int r = maxCol(matrix, c);
            if(matrix[i][c] == matrix[r][c]) {
                ans.add(matrix[i][c]);
            }
        }
        return ans;
    }
    private int minRow(int[][] matrix, int row) {
        int min = Integer.MAX_VALUE;
        int col = 0;
        for(int i= 0; i<matrix[0].length; i++) {
            if(min > matrix[row][i]) {
                min = matrix[row][i];
                col = i;
            }
        }
        return col;
    }
    private int maxCol(int[][] matrix, int col) {
        int max = Integer.MIN_VALUE;
        int row = 0;
        for(int i= 0; i<matrix.length; i++) {
            if(max < matrix[i][col]) {
                max = matrix[i][col];
                row = i;
            }
        }
        return row;
    }
}