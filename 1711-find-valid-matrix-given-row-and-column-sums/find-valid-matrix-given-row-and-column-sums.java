class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for(int i = 0; i<rowSum.length; i++) {
            for(int j = 0; j <colSum.length; j++) {
                if(rowSum[i] <= colSum[j]) {
                    matrix[i][j] = rowSum[i];
                    rowSum[i] = 0;
                } else {
                    matrix[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                }
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }
}