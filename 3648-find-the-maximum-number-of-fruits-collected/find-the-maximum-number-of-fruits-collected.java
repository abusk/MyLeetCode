// class Solution {
//     public static int maxCollectedFruits(int[][] fruits) {
//         int n = fruits.length;
//         int mainDiagonalFruits = 0;

//         // 1. Collect and remove main diagonal fruits
//         for (int i = 0; i < n; i++) {
//             mainDiagonalFruits += fruits[i][i];
//             fruits[i][i] = 0;
//         }

//         // 2. Collect max fruits for child from (0, n-1)
//         int topRightPath = maxFruitsFromTopRight(fruits);

//         // 3. Flip matrix along main diagonal
//         int[][] transposed = transpose(fruits);

//         // 4. Collect max fruits for child from (n-1, 0) in transposed matrix
//         int bottomLeftPath = maxFruitsFromTopRight(transposed);

//         // 5. Return total
//         return mainDiagonalFruits + topRightPath + bottomLeftPath;
//     }

//     public static int maxFruitsFromTopRight(int[][] fruits) {
//         int n = fruits.length;
//         int[][] dp = new int[n][n];

//         // Base case: first row
//         for (int j = 0; j < n; j++) {
//             dp[0][j] = fruits[0][j];
//         }

//         for (int i = 1; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) { // j > i
//                 int maxPrev = Integer.MIN_VALUE;

//                 for (int dj = -1; dj <= 1; dj++) {
//                     int prevJ = j + dj;
//                     if (prevJ > i - 1 && prevJ < n) { // stay strictly above diagonal
//                         maxPrev = Math.max(maxPrev, dp[i - 1][prevJ]);
//                     }
//                 }

//                 if (maxPrev != Integer.MIN_VALUE) {
//                     dp[i][j] = maxPrev + fruits[i][j];
//                 }
//             }
//         }

//         return dp[n - 2][n - 1]; // end at (n-2, n-1)
//     }

//     public static int[][] transpose(int[][] matrix) {
//         int n = matrix.length;
//         int[][] transposed = new int[n][n];
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 transposed[i][j] = matrix[j][i];
//         return transposed;
//     }

//     public static void main(String[] args) {
//         int[][] fruits = {
//             {8, 5, 0, 17, 15},
//             {6, 0, 15, 6, 0},
//             {7, 19, 16, 8, 18},
//             {11, 3, 2, 12, 13},
//             {17, 15, 15, 4, 6}
//         };
//         System.out.println(maxCollectedFruits(fruits));
//     }
// }
class Solution {
    public int maxCollectedFruits(int[][] A) {
        int n = A.length;
        // Set inaccessible cells to 0
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i < j && j < n - 1 - i) {
                    A[i][j] = 0;
                }
                if (j < i && i < n - 1 - j) {
                    A[i][j] = 0;
                }
            }
        }

        // First child
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += A[i][i];
        }

        // Second child
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                A[i][j] += Math.max(A[i - 1][j - 1],
                                  Math.max(A[i - 1][j], (j + 1 < n) ? A[i - 1][j + 1] : 0));
            }
        }

        // Third child
        for (int j = 1; j < n; ++j) {
            for (int i = j + 1; i < n; ++i) {
                A[i][j] += Math.max(A[i - 1][j - 1],
                                  Math.max(A[i][j - 1], (i + 1 < n) ? A[i + 1][j - 1] : 0));
            }
        }

        return res + A[n - 1][n - 2] + A[n - 2][n - 1];
    }
}