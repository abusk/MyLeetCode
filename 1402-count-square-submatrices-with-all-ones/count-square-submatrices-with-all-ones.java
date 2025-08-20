class Solution {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i =0; i<m; i++) {
            for (int j =0; j<n; j++) {
                if(matrix[i][j] != 0) {
                    allSquare(matrix, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                ans += matrix[i][j];
            }
        }
        return ans;
    }
    public static void allSquare(int[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        int c = 0;
        int lc = Math.min(m - i, n - j);
        int k = 0;
        while (k < lc) {
            if (isValid(matrix, i , j, k)) {
                c++;
            } else {
                break;
            }
            k++;
        }
        matrix[i][j] = c;
    }

    public static boolean isValid(int[][] matrix, int i, int j, int k) {
        for(int r = i; r <= i+k; r++) {
            if(matrix[r][j+k] == 0) {
                return false;
            }
        }
        for(int c = j; c <= j +k; c++) {
            if(matrix[i+k][c] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,1,1}, {1,1,0,1}, {1,1,1,0}};
        System.out.println(countSquares(matrix));
    }
}