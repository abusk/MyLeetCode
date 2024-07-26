class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int total = 0;
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                total += findTarget(matrix, target, i, j);
            }
        }
        return total;
    }
    public int findTarget(int[][] matrix, int target, int m, int n) {
        int c = 0;
        int [][] ps = cloneM(matrix);
        for(int i = m; i < matrix.length; i++) {
            for(int j = n; j<matrix[0].length; j++) {
                if(i == m && j == n) {
                    ps[i][j] = ps[i][j];
                } else if(i == m && j > n) {
                    ps[i][j] = ps[i][j] + ps[i][j-1];
                } else if(j == n && i > m) {
                    ps[i][j] = ps[i][j] + ps[i-1][j];
                } else {
                    ps[i][j] = ps[i][j] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
                }
                if(ps[i][j] == target) {
                    c++;
                }
            }
        }
        return c;
    }

    public int[][] cloneM(int[][] matrix) {
        int[][] clone = new int[matrix.length][matrix[0].length];
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++) {
                clone[i][j] = matrix[i][j];
            }
        }
        return clone;
    }
}