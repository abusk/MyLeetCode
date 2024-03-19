class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;
        for(int i = 0; i<l; i++) {
            for(int j = i; j<l; j++) {
                if(i != j){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        for(int i = 0; i<l; i++) {
            int m = 0;
            int n = l-1;
            while(m<=n) {
                int tmp = matrix[i][m];
                matrix[i][m] = matrix[i][n];
                matrix[i][n] = tmp;
                m++;
                n--;
            }
        }
    }
}