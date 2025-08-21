class Solution {
    public static int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    countForPos(mat, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans += mat[i][j];
            }
        }
        return ans;
    }

    public static void countForPos(int[][] mat, int i, int j) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int lastMin = m;
        for(int c = 0; c < n - j; c++) {
            if(lastMin == 0) {
                break;
            }
            for(int r = 0; r < Math.min(m-i, lastMin); r++) {
                int row = r + i;
                int col = c + j;
                if(mat[row][col] != 0) {
                    count++;
                } else {
                    lastMin = Math.min(lastMin, r);
                    break;
                }
            }
        }
        mat[i][j] = count;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 1 ,1,0}, {0,1,1,1}, {1,1,1,0}, {1, 0, 0, 0}};
        System.out.println(numSubmat(mat));
    }
}