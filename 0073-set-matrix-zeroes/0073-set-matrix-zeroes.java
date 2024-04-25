class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        boolean row = false;
        boolean col = false;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(i == 0 && j == 0 && matrix[i][j] == 0) {
                    row = true;
                    col = true;
                } else if(j == 0 && matrix[i][j] == 0) {
                    row = true;
                    matrix[0][0] = 0;
                } else if(i == 0 && matrix[i][j] == 0) {
                    col = true;
                    matrix[0][0] = 0;
                } else if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < R; i++) {
          for (int j = 1; j < C; j++) {
              if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                  matrix[i][j] = 0;
              }
          }
        }
        
        if(row) {
           for (int i = 0; i < R; i++) {
               matrix[i][0] = 0;
           } 
        }
        if(col) {
           for (int i = 0; i < C; i++) {
               matrix[0][i] = 0;
           } 
        }
    }
}